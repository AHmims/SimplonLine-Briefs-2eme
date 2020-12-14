package com.lecture.app;

import com.lecture.app.Personne;

public class Lecteur extends Personne {
	
	private int num�rotel;
	private int nombrelu;
	
	//Constructors 
	
	public Lecteur (String nom, String mail, int num�rotel, int nombrelu) {
		super(nom, mail);
		this.num�rotel=num�rotel;
		this.nombrelu = nombrelu;
	}
		
	public Lecteur (Personne p, int num�rotel, int nombrelu) {
		super(p.getNom(), p.getMail());
		this.num�rotel= num�rotel;
		this.nombrelu = nombrelu;	
	}
	
	public Lecteur() {
		// TODO Auto-generated constructor stub
	}

	//Getters & setters
	public int getNum�rotel() {
		return num�rotel;
	}
	
	public void setNum�rotel(int num�rotel) {
		this.num�rotel = num�rotel;
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
		return super.toString() + " Num�ro de t�lephone : " + this.num�rotel + " Nombre de livres lus : " + this.nombrelu;
	}
}
