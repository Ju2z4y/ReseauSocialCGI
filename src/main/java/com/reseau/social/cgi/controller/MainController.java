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

import com.reseau.social.cgi.model.Topic;
import com.reseau.social.cgi.service.DbService;
 
@Controller
public class MainController {
	
	
	private DbService dbService = new DbService();

 
    @RequestMapping(value = { "/index" }, method = RequestMethod.GET)
    public String testMestod(HttpServletRequest request){
    	if ((request.getSession().getAttribute("prenom") == null) || (request.getSession().getAttribute("nom") == null)) {
    		return "identification";
    	} else {
    		return "index";
    	}
      }
    
    @RequestMapping(value = { "/fildactu" }, method = RequestMethod.GET)
    public ModelAndView getActu(HttpServletRequest request){
    	if ((request.getSession().getAttribute("prenom") == null) || (request.getSession().getAttribute("nom") == null)) {
    		return new ModelAndView("identification");
    	} else {
    		Topic topic = dbService.createTopic();
    		return new ModelAndView("/fildactu/actu-main","topic", topic);
    	}
      }    
    
    @RequestMapping(value = { "/index" }, method = RequestMethod.POST)
    public String recoverPass(@RequestParam("prenom") String prenom,
    		@RequestParam("nom") String nom, HttpServletRequest request){
    	if ((prenom == null)||(nom == null)) {
    		return "identification";
    	} else {
    		request.getSession().setAttribute("prenom", prenom);
    		request.getSession().setAttribute("nom", nom);
    		return "index";
    	}

      }    
}