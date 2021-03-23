package com.example.AM_BANK_APP.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Table(name = "tili")
@Entity
public class Tili {


	@Id
	@Column(name="tilinro", nullable=false, updatable=false)
	private String tilinro;
	
	private double saldo;
	private String omistaja;
	
	

	public Tili(String tilinro) {
		super();
		this.tilinro = tilinro;
	}


	public Tili(String tilinro, double saldo, String omistaja) {
		super();
		this.tilinro = tilinro;
		this.saldo = saldo;
		this.omistaja = omistaja;
	}



	public Tili() {
		
	}
	

	public String getTilinro() {
		return tilinro;
	}
	public void setTilinro(String tilinro) {
		this.tilinro = tilinro;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getOmistaja() {
		return omistaja;
	}
	public void setOmistaja(String omistaja) {
		this.omistaja = omistaja;
	}
	
	@Override
	public String toString() {
		return "Tili1 [ tilinro=" + tilinro + ", saldo=" + saldo + ", omistaja=" + omistaja + "]";
	}
	
}
