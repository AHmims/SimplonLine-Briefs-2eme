package com.lecture.app;

public class Bienfaiteur {

	private String surnom;
	private String mail;
	private int nombrelo;
	
	public Bienfaiteur()
	{
		
	}
	public Bienfaiteur(String surnom, String mail, int nombrelo) 
	{
		this.surnom = surnom;
		this.mail = mail;
		this.nombrelo = nombrelo;
	}
	
	public String getSurnom() {
		return surnom;
	}
	public void setSurnom(String surnom) {
		this.surnom = surnom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getNombrelo() {
		return nombrelo;
	}
	public void setNombrelo(int nombrelo) {
		this.nombrelo = nombrelo;
	}
	@Override
	public String toString() 
	{
		return "Surnom : "+this.surnom + " Mail : "+ this.mail +" Nombre de livres offerts : " + this.nombrelo;
	}
	
}