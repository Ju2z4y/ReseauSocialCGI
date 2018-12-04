package com.reseau.social.cgi.service;

import com.reseau.social.cgi.model.Topic;

public class DbService {
	
	public int idTopic = 0;
	
	public Topic createTopic() {
		idTopic ++;
		Topic topic = new Topic(idTopic, "Auteur du topic", "Message du topic", "Titre du topic");
		return topic;
		
	}

}
