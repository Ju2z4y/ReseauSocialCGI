package com.reseau.social.cgi.service;

import java.util.ArrayList;
import java.util.List;

import com.reseau.social.cgi.model.Commentaire;
import com.reseau.social.cgi.model.Message;
import com.reseau.social.cgi.model.Topic;

public class DbService {
	
	private int idTopic = 0;
	private int idMessage = 0;
	private int idCommentaire = 0;
	
	public Topic createTopic(String auteur, String titre) {
		idTopic++;
		Topic topic = new Topic(idTopic, auteur, titre);
		return topic;
	}
	
	public Message createMessage(String auteur, String texte) {
		idMessage++;
		Message message = new Message(idMessage, auteur, texte);
		return message;
	}
	
	public Commentaire createCommentaire(String auteur, String texte) {
		idCommentaire++;
		Commentaire commentaire = new Commentaire(idCommentaire, auteur, texte);
		return commentaire;
	}


}
