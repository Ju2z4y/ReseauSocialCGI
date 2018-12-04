package com.reseau.social.cgi.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Topic {
	
	private Integer id;
	private String auteur;
	private String message;
	private String titre;
	private Date date;
	private List<Message> listMessage;
	
	public Topic(Integer id, String auteur, String message, String titre) {
		this.id = id;
		this.auteur = auteur;
		this.message = message;
		this.titre = titre;
		this.date = new Date();
	}

}
