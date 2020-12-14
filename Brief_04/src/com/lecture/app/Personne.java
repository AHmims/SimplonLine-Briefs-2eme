package com.lecture.app;

public class Personne {

	private String nom;
	private String mail ;
	
	public Personne()
	{
		
	}
	public Personne (String nom, String mail) 
	{
		this.nom = nom;
		this.mail = mail;
	}
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	public void setMail(String mail)
	{
		this.mail = mail;
	}
	
	public String getMail()
	{
		return mail;
	}
	
	
	@Override
	public String toString() 
	{ 
		return "Nom : "+this.nom + " Mail : "+ this.mail;
	}
	
}