package com.reseau.social.cgi.model;

import java.util.ArrayList;
import java.util.Date;

public class Message {
	
	private Integer id;
	private String auteur;
	private String message;
	private Date date;
	private ArrayList<Commentaire> commentaires = new ArrayList<Commentaire>();

	
	public Message(Integer id, String auteur, String message) {
		this.id = id;
		this.auteur = auteur;
		this.message = message;
		this.date = new Date();
	}
	
	public Message(String auteur, String message) {
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
	
	public void addCommentaire(Commentaire commentaire) {
		this.commentaires.add(commentaire);
	}


	public ArrayList<Commentaire> getCommentaires() {
		return commentaires;
	}


	public void setCommentaires(ArrayList<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	

}
