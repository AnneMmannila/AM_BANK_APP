package com.example.AM_BANK_APP.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TiliRepository {

	@Autowired
	public EntityManager entityManager;

	public TiliRepository() {
	}

	@Transactional
	public void insertWithQuery(Tili tili) {
		entityManager.createNativeQuery("INSERT INTO tili (tilinro, saldo, omistaja) VALUES (?,?,?)")
				.setParameter(1, tili.getTilinro()).setParameter(2, tili.getSaldo()).setParameter(3, tili.getOmistaja())
				.executeUpdate();
	}

	public Tili findByTilinro(String tilinro) {
		return this.entityManager.find(Tili.class, tilinro);
	}

	public List<Tili> listTilinrot(User userNow) {
		List<Tili> nrot = entityManager.createQuery("Select new " + Tili.class.getName() + "(e.tilinro) from "
				+ Tili.class.getName() + " e " + " where e.omistaja = ?1")
				.setParameter(1, userNow.getUsername())
				.getResultList();
		return nrot;
	}
	
	
	public List<Tili> listkaikkiTilinrot() {
		String sql = "Select new " + Tili.class.getName() //
				+ "(e.tilinro) " //
				+ " from " + Tili.class.getName() + " e ";
		Query query = entityManager.createQuery(sql, Tili.class);
		return query.getResultList();
		
	}
	

	public List<Tili> listTilit() {
		String sql = "Select new " + Tili.class.getName() //
				+ "(e.tilinro, e.saldo, e.omistaja) " //
				+ " from " + Tili.class.getName() + " e ";
		Query query = entityManager.createQuery(sql, Tili.class);
		return query.getResultList();
	}

	// MANDATORY: Transaction must be created before.
	@Transactional(propagation = Propagation.MANDATORY)
	public void addAmount(String tilinro, double amount) throws TilitapahtumaException {
		Tili tili = this.findByTilinro(tilinro);
		if (tili == null) {
			throw new TilitapahtumaException("Tiliä ei löytynyt " + tilinro);
		}
		double uusisaldo = tili.getSaldo() + amount;
		if (tili.getSaldo() + amount < 0) {
			throw new TilitapahtumaException("Tilin '" + tilinro + "' kate ei riitä (" + tili.getSaldo() + ")");
		}
		tili.setSaldo(uusisaldo);
	}

	// tilitapahtumat alkaa

	// Do not catch BankTransactionException in this method.
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = TilitapahtumaException.class)
	public void sendMoney(String tililta, String tilille, double amount) throws TilitapahtumaException {

		addAmount(tililta, -amount);
		addAmount(tilille, amount);

		addTapahtuma(tililta, String.valueOf(-amount));
		addTapahtuma(tilille, String.valueOf(amount));

	}

	@Transactional
	public void insertWithQueryT(Tilitapahtumat tilitapahtuma) {
		entityManager.createNativeQuery("INSERT INTO tilitapahtumat (id, tilinro, tapahtuma) VALUES (?, ?, ?)")
				.setParameter(1, tilitapahtuma.getId()).setParameter(2, tilitapahtuma.getTilinro())
				.setParameter(3, tilitapahtuma.getTapahtuma()).executeUpdate();
	}

	// tilitapahtuman lisääminen
	@Transactional(propagation = Propagation.MANDATORY)
	public void addTapahtuma(String tilinro, String amount) throws TilitapahtumaException {
		String uniqueID = UUID.randomUUID().toString();
		Tili tili = new Tili(tilinro);
		Tilitapahtumat uusitapahtuma = new Tilitapahtumat(uniqueID, tili, amount);
		insertWithQueryT(uusitapahtuma);

	}

	// kaikkitilitapahtumat
	public List<Tilitapahtumat> listTapahtumat(User userNow) {

		List<Tilitapahtumat> list = entityManager
				.createQuery("SELECT new " + Tilitapahtumat.class.getName() + "(e.id, e.tapahtuma) from "
						+ Tilitapahtumat.class.getName() + " e " + "join " + Tili.class.getName()
						+ " o  on o.tilinro = e.tilinro where o.omistaja = ?1")
				.setParameter(1, userNow.getUsername()).getResultList();

		return list;
	}

	public List<Tili> findByUser(User userNow) {
		List<Tili> tili = entityManager
				.createQuery("SELECT new " + Tili.class.getName() + "(e.tilinro, e.saldo, e.omistaja) from "
						+ Tili.class.getName() + " e " + " where e.omistaja = ?1")
				.setParameter(1, userNow.getUsername()).getResultList();
		return tili;
	}

}
