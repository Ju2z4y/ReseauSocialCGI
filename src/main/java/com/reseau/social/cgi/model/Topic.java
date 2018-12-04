package com.reseau.social.cgi.model;

import java.util.Date;

public class Topic {
	
	private int id;
	private String auteur;
	private String message;
	private String titre;
	private Date date;
	
	public Topic(int id, String auteur, String message, String titre) {
		this.id = id;
		this.auteur = auteur;
		this.message = message;
		this.titre = titre;
		this.date = new Date();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
