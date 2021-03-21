package com.example.AM_BANK_APP.domain;

public class Maksu {

	private Long tililta;
	private Long tilille;
	private double saldo;

	
	public Maksu() {
		super();
	}

	public Maksu(Long tililta, Long tilille, double saldo) {
		super();
		this.tililta = tililta;
		this.tilille = tilille;
		this.saldo = saldo;
	}

	public Long getTililta() {
		return tililta;
	}

	public void setTililta(Long tililta) {
		this.tililta = tililta;
	}

	public Long getTilille() {
		return tilille;
	}

	public void setTilille(Long tilille) {
		this.tilille = tilille;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Maksu [tililta=" + tililta + ", tilille=" + tilille + ", saldo=" + saldo + "]";
	}

}
