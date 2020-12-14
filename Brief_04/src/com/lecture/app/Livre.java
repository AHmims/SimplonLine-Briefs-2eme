package com.lecture.app;

public class Livre {

	private String titre;
	private int edition;
	private int date;
	
	public Livre()
	{
		
	}
	
	public Livre (String titre, int edition, int date)
	{
		this.titre = titre;
		this.edition= edition;
		this.date=date;
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	@Override
	public String toString()
	{
		return "titre :"+ this.titre +" édition : "+ this.edition + " date d’édition" + this.date;
	}

}