package com.example.AM_BANK_APP.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Tilitapahtumat {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private double tapahtuma;

	

	public Tilitapahtumat(double tapahtuma) {
		super();
		this.tapahtuma = tapahtuma;
	}

	public Tilitapahtumat() {
		super();
	}



	
	public double getTapahtuma() {
		return tapahtuma;
	}

	public void setTapahtuma(double tapahtuma) {
		this.tapahtuma = tapahtuma;
	}

	@Override
	public String toString() {
		return "Tilitapahtumat [id=" + id + ", tapahtuma=" + tapahtuma + "]";
	}

	
	 
	
	
	
	
}
