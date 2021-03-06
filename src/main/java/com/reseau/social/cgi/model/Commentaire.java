package com.reseau.social.cgi.model;

import java.util.Date;

public class Commentaire {
	
	private Integer id;
	private String auteur;
	private String message;
	private Date date;
	
	
	public Commentaire(Integer id, String auteur, String message) {
		this.id = id;
		this.auteur = auteur;
		this.message = message;
		this.date = new Date();
	}
	
	public Commentaire(String auteur, String message) {
		this.auteur = auteur;
		this.message = message;
		this.date = new Date();
	}	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
