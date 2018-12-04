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
	
	public Topic createTopic() {
		idTopic++;
		Topic topic = new Topic(idTopic, "Thomas", "Test Titre");
		topic.addMessage(createMessage());
		return topic;
	}
	
	public Message createMessage() {
		idMessage++;
		Message message = new Message(idMessage, "Auteur message", "message");
		message.addCommentaire(createCommentaire());
		return message;
	}
	
	public Commentaire createCommentaire() {
		idCommentaire++;
		Commentaire commentaire = new Commentaire(idCommentaire, "Auteur commentaire", "commentaire");
		return commentaire;
	}


}
