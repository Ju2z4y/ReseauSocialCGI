package com.reseau.social.cgi.service;

import java.util.ArrayList;
import java.util.List;

import com.reseau.social.cgi.model.Topic;

public class DbService {
	
	private int idTopic = 0;
	
	public Topic createTopic() {
		idTopic++;
		Topic topic = new Topic(idTopic, "Thomas", "Test Message", "Test Titre");
		return topic;
		
		
	}

}
