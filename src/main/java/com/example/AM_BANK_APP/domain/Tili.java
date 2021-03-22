package com.example.AM_BANK_APP.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Table(name = "tili")
@Entity
public class Tili {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	

	private String tilinro;
	private double saldo;
	private String omistaja;
	
	

	public Tili(long id, String tilinro, double saldo, String omistaja) {
		super();
		this.id = id;
		this.tilinro = tilinro;
		this.saldo = saldo;
		this.omistaja = omistaja;
	}

	public Tili(String tilinro, double saldo, String omistaja) {
		super();
		this.tilinro = tilinro;
		this.saldo = saldo;
		this.omistaja = omistaja;
	}

	public Tili() {
		
	}
	
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		return "Tili1 [id=" + id + ", tilinro=" + tilinro + ", saldo=" + saldo + ", omistaja=" + omistaja + "]";
	}
	
}
