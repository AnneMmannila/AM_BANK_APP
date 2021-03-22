package com.example.AM_BANK_APP.domain;

public class Maksu {

	private String tililta;
	private String tilille;
	private double maara;

	
	public Maksu() {
		super();
	}

	public Maksu(String tililta, String tilille, double maara) {
		super();
		this.tililta = tililta;
		this.tilille = tilille;
		this.maara = maara;
	}

	public String getTililta() {
		return tililta;
	}

	public void setTililta(String tililta) {
		this.tililta = tililta;
	}

	public String getTilille() {
		return tilille;
	}

	public void setTilille(String tilille) {
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
