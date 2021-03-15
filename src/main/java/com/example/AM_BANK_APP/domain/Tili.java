package com.example.AM_BANK_APP.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "tili")
@Entity
public class Tili {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String tilinro;
	private double saldo;
	private String omistaja;
	


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
		return "Tili1 [id=" + id + ", tilinro=" + tilinro + ", saldo=" + saldo + ", omistaja=" + omistaja + "]";
	}
	
}
