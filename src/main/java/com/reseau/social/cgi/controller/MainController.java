package com.reseau.social.cgi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
public class MainController {

 
    @RequestMapping(value = { "/index" }, method = RequestMethod.GET)
    public String testMestod(HttpServletRequest request){
    	if (request.getSession().getAttribute("name") == null) {
    		return "identification";
    	} else {
    		return "index";
    	}
      }
    
    @RequestMapping(value = { "/login" }, method = RequestMethod.POST)
    public String recoverPass(@RequestParam("identifiant") String username, HttpServletRequest request){
    	System.out.println(username);
    	if (username == null) {
    		return "identification";
    	} else {
    		request.getSession().setAttribute("name", username);
    		return "index";
    		
    	}

      }    
}