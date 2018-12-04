package com.reseau.social.cgi.service;

import java.util.ArrayList;
import java.util.List;

import com.reseau.social.cgi.model.Topic;

public class DbService {
	
	public List<Topic> createTopic() {
		List<Topic> result = new ArrayList();
		Topic topic = new Topic(1, "Thomas", "Test Message", "Test Titre");
		
		
		result.add(topic);
		return result;
		
	}

}
