package com.example.AM_BANK_APP.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class TiliRepository{

	  @Autowired
	  public EntityManager entityManager;
	      
	 
	    public TiliRepository() {
	    }
	 
	    @Transactional
	    public void insertWithQuery(Tili tili) {
	        entityManager.createNativeQuery("INSERT INTO tili (id, tilinro, saldo, omistaja) VALUES (?,?,?,?)")
	        .setParameter(1, tili.getId())
	          .setParameter(2, tili.getTilinro())
	          .setParameter(3, tili.getSaldo())
	          .setParameter(4, tili.getOmistaja())
	          .executeUpdate();
	    }
	    
	    public Tili findById(Long id) { 
	        return this.entityManager.find(Tili.class, id);
	    }
	 
	    public List<Tili> listTilit() {
	        String sql = "Select new " + Tili.class.getName() //
	                + "(e.tilinro, e.saldo, e.omistaja) " //
	                + " from " + Tili.class.getName() + " e ";
	        Query query = entityManager.createQuery(sql, Tili.class);
	        return query.getResultList();
	    }
	 
	    // MANDATORY: Transaction must be created before.
	    @Transactional(propagation = Propagation.MANDATORY )
	    public void addAmount(Long id, double amount) throws TilitapahtumaException {
	        Tili tili = this.findById(id);
	        if (tili == null) {
	            throw new TilitapahtumaException("Tiliä ei löytynyt " + id);
	        }
	        double uusisaldo = tili.getSaldo() + amount;
	        if (tili.getSaldo() + amount < 0) {
	            throw new TilitapahtumaException(
	                    "Tilin '" + id + "' kate ei riitä (" + tili.getSaldo() + ")");
	        }
	        tili.setSaldo(uusisaldo);
	    }
	 
	    // Do not catch BankTransactionException in this method.
	    @Transactional(propagation = Propagation.REQUIRES_NEW, 
	                        rollbackFor = TilitapahtumaException.class)
	    public void sendMoney(Long tililta, Long tilille, double amount) throws TilitapahtumaException {
	 
	        addAmount(tililta, amount);
	        addAmount(tilille, -amount);
	    }
	 
	}

