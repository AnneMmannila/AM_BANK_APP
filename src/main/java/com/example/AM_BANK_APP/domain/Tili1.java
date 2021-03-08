package com.example.AM_BANK_APP.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tili1 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String tilinro;
	private Long saldo;
	private String omistaja;
	
	
	
	public Tili1(String tilinro, long saldo, String omistaja) {
		super();
		this.tilinro = tilinro;
		this.saldo = saldo;
		this.omistaja = omistaja;
	}

	public Tili1() {
		
	}
	
	public String getTilinro() {
		return tilinro;
	}
	public void setTilinro(String tilinro) {
		this.tilinro = tilinro;
	}
	public long getSaldo() {
		return saldo;
	}
	public void setSaldo(long saldo) {
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
