package com.example.AM_BANK_APP.domain;

public class Maksu {

	private Long tililta;
	private Long tilille;
	private double maara;

	
	public Maksu() {
		super();
	}

	public Maksu(Long tililta, Long tilille, double maara) {
		super();
		this.tililta = tililta;
		this.tilille = tilille;
		this.maara = maara;
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

	public double getMaara() {
		return maara;
	}

	public void setMaara(double maara) {
		this.maara = maara;
	}

	@Override
	public String toString() {
		return "Maksu [tililta=" + tililta + ", tilille=" + tilille + ", maara=" + maara + "]";
	}

}
