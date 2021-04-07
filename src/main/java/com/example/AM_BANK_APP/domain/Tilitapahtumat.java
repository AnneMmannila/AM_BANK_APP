package com.example.AM_BANK_APP.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Tilitapahtumat {

	
	@Id
	private String id;

	private String omistaja;
	
	
	

	public String getOmistaja() {
		return omistaja;
	}




	public void setOmistaja(String omistaja) {
		this.omistaja = omistaja;
	}

	private String tapahtuma;
	
	
	@ManyToOne
	@JoinColumn(name = "tilinro")
	private Tili tilinro;
	
	
	public Tili getTilinro() {
		return tilinro;
	}




	public void setTilinro(Tili tilinro) {
		this.tilinro = tilinro;
	}




	public Tilitapahtumat(String id, Tili tilinro, String tapahtuma) {
		super();
		this.id = id;
		this.tapahtuma = tapahtuma;
		this.tilinro = tilinro;
	}




	public Tilitapahtumat(String id, String tapahtuma) {
		super();
		this.id = id;
		this.tapahtuma = tapahtuma;
	}




	public Tilitapahtumat() {
		super();
	}


	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public Tilitapahtumat(String tapahtuma) {
		super();
		this.tapahtuma = tapahtuma;
	}


	
	public String getTapahtuma() {
		return tapahtuma;
	}

	public void setTapahtuma(String tapahtuma) {
		this.tapahtuma = tapahtuma;
	}

	@Override
	public String toString() {
		return "Tilitapahtumat [id=" + id + ", tapahtuma=" + tapahtuma + "]";
	}


	
	 
	
	
	
	
}
