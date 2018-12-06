package com.reseau.social.cgi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.reseau.social.cgi.model.Commentaire;
import com.reseau.social.cgi.model.Message;
import com.reseau.social.cgi.model.Topic;
import com.reseau.social.cgi.service.DbService;
 
@Controller
public class MainController {
	
	
	private DbService dbService = new DbService();

 
    @RequestMapping(value = { "/index" }, method = RequestMethod.GET)
    public String testMestod(HttpServletRequest request){
    	if ((request.getSession().getAttribute("userName") == null) || (request.getSession().getAttribute("userName") == "empty")) {
    		System.out.println(request.getSession().getAttribute("userName"));
    		return "identification";
    	} else {
    		return "index";
    	}
      }
    
    @RequestMapping(value = { "/fildactu" }, method = RequestMethod.GET)
    public ModelAndView getActu(HttpServletRequest request){
    	if ((request.getSession().getAttribute("userName") == null) || (request.getSession().getAttribute("userName") == "empty")) {
    		return new ModelAndView("identification");
    	} else {
    		if (request.getSession().getAttribute("topics") == null) {
    			ArrayList<Topic> topics = initialisationFilActu();
        		request.getSession().setAttribute("topics", topics);
        		return new ModelAndView("/fildactu/actu-main","topics", topics);
    		} else {
    			return new ModelAndView("/fildactu/actu-main","topics", request.getSession().getAttribute("topics"));
    		}

    	}
      }    
    
    @RequestMapping(value = { "/index" }, method = RequestMethod.POST)
    public ModelAndView recoverPass(@RequestParam("prenom") String prenom,
    		@RequestParam("nom") String nom, HttpServletRequest request){
    	if ((prenom == null)||(nom == null)) {
    		return new ModelAndView("inscription");
    	} else {
    		setUserName(prenom, nom, request);
    		return new ModelAndView("index");
    	}

      }    
    
    @RequestMapping(value = { "/ajoutCommentaire" }, method = RequestMethod.POST)
    public ModelAndView ajoutCommentaire(@RequestParam("idTopic") int idTopic,
    		@RequestParam("idMessage") int idMessage, @RequestParam("newCommentaire") String newCommentaire, HttpServletRequest request){
    	if ((newCommentaire == null)||(newCommentaire == "")) {
    		return new ModelAndView("index");
    	} else {
    		ArrayList<Topic> topics = (ArrayList<Topic>)request.getSession().getAttribute("topics");
    		for (Topic topic : topics) {
    			if (topic.getId() == idTopic) {
    				for (Message message : topic.getMessages()) {
    					if (message.getId() == idMessage) {
    						String auteur = (String)request.getSession().getAttribute("userName");
    						message.addCommentaire(new Commentaire(auteur, newCommentaire));
    					}
    				}
    			}
    		}
    		request.getSession().setAttribute("topics", topics);
    		return new ModelAndView("/fildactu/actu-main","topics", topics);
    	}

      }  
    
    @RequestMapping(value = { "/ajoutMessage" }, method = RequestMethod.POST)
    public ModelAndView ajoutMessage(@RequestParam("idTopic") int idTopic,
    		 @RequestParam("newMessage") String newMessage, HttpServletRequest request){
    	if ((newMessage == null)||(newMessage == "")) {
    		return new ModelAndView("index");
    	} else {
    		ArrayList<Topic> topics = (ArrayList<Topic>)request.getSession().getAttribute("topics");
    		for (Topic topic : topics) {
    			if (topic.getId() == idTopic) {
    				int newId = topic.getMessages().size() + 1;
    				String auteur = (String)request.getSession().getAttribute("userName");
    				topic.addMessage(new Message(newId, auteur, newMessage));
    			}
    		}
    		request.getSession().setAttribute("topics", topics);
    		return new ModelAndView("/fildactu/actu-main","topics", topics);
    	}
      }   
    
    @RequestMapping(value = { "/ajoutTopic" }, method = RequestMethod.POST)
    public ModelAndView ajoutTopic(@RequestParam("newTopic") String msgTopic,
    		 @RequestParam("newTopicMessage") String newMessage, HttpServletRequest request){
    	if (((newMessage == null)||(newMessage == "")) || ((msgTopic == null)||(msgTopic == ""))) {
    		return new ModelAndView("/fildactu/actu-main");
    	} else {
    		ArrayList<Topic> topics = (ArrayList<Topic>)request.getSession().getAttribute("topics");
    		String auteur = (String)request.getSession().getAttribute("userName");
    		
    		Topic topic = new Topic(topics.size(), auteur, msgTopic);
    		Message message = new Message(1, auteur, newMessage);
    		topic.addMessage(message);
    		topics.add(topic);
    		request.getSession().setAttribute("topics", topics);
    		return new ModelAndView("/fildactu/actu-main","topics", topics);
    	}
      }  
    
    private ArrayList<Topic> initialisationFilActu(){
		ArrayList<Topic> topics = new ArrayList<Topic>();
		
		Topic topic1 = dbService.createTopic("Walid", "Ré-intégration U'Dev");
		Message message11 = dbService.createMessage("Walid", "Je vais revenir tous les jours jusqu'à ce que je sois ré-embauché!");
		Message message12 = dbService.createMessage("Mederick", "Tu devrais prendre rendez vous sur malaise TV");
		Commentaire commentaire111 = dbService.createCommentaire("Walid", "Je passe à l'IPI ce soir");
		message12.addCommentaire(commentaire111);
		topic1.addMessage(message11);
		topic1.addMessage(message12);
		
		Topic topic2 = dbService.createTopic("Thomas", "Crash Destiny 2");
		Message message21 = dbService.createMessage("Thomas", "J'arrête pas de crash sur D2, je comprends pas pq, je craque !!!");
		Message message22 = dbService.createMessage("Max", "Je pense que c'est pq ton PC est trop puissant!");
		Commentaire commentaire211 = dbService.createCommentaire("Julien", "Arrete de cracher sal lama");
		message21.addCommentaire(commentaire211);
		topic2.addMessage(message21);
		topic2.addMessage(message22);
		
		topics.add(topic1);
		topics.add(topic2);
		return topics;
		
    }
    
    @RequestMapping(value = { "/deconnexion" }, method = RequestMethod.GET)
    public String deconnexion(HttpServletRequest request){
    	request.getSession().setAttribute("userName", "empty");
    	return "identification";
      }    
    
    private void setNullSession(HttpServletRequest request) {
    	request.getSession().setAttribute("prenom", "coucou");
    	request.getSession().setAttribute("nom", "coucou");
    }
    
    private void setUserName(String prenom, String nom, HttpServletRequest request) {
    	request.getSession().setAttribute("userName", prenom + " " + nom);
    }
}