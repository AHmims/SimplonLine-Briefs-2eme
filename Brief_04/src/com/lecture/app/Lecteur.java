package com.lecture.app;

import com.lecture.app.Personne;

public class Lecteur extends Personne {
	
	private int numérotel;
	private int nombrelu;
	
	//Constructors 
	
	public Lecteur (String nom, String mail, int numérotel, int nombrelu) {
		super(nom, mail);
		this.numérotel=numérotel;
		this.nombrelu = nombrelu;
	}
		
	public Lecteur (Personne p, int numérotel, int nombrelu) {
		super(p.getNom(), p.getMail());
		this.numérotel= numérotel;
		this.nombrelu = nombrelu;	
	}
	
	public Lecteur() {
		// TODO Auto-generated constructor stub
	}

	//Getters & setters
	public int getNumérotel() {
		return numérotel;
	}
	
	public void setNumérotel(int numérotel) {
		this.numérotel = numérotel;
	}

	public int getNombrelu() {
		return nombrelu;
	}

	public void setNombrelu(int nombrelu) {
		this.nombrelu = nombrelu;
	}

	@Override
	public String toString()
	{
		return super.toString() + " Numéro de télephone : " + this.numérotel + " Nombre de livres lus : " + this.nombrelu;
	}
}
