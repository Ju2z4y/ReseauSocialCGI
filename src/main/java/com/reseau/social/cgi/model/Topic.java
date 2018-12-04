package com.reseau.social.cgi.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

public class Topic {
	
	private Integer id;
	private String auteur;
	private List<Message> messages;
	private String titre;
	private Date date;

	
	public Topic(Integer id, String auteur, String titre) {
		this.id = id;
		this.auteur = auteur;
		this.titre = titre;
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


	public List<Message> getMessages() {
		return messages;
	}


	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	public void addMessage(Message message) {
		messages.add(message);
	}

	
}
