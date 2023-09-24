package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.dto.Credentials;
import com.example.demo.services.LogIn;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private LogIn loginService; 
	
	@GetMapping
	String get(Model model){	    
	    return "login";
	}
	  
	@PostMapping
	public RedirectView post(@ModelAttribute Credentials credentials, RedirectAttributes attributes){
	    //mapped to hostname:port/home/
		// redirect
		System.out.println(credentials);
	    //return "home";
		if (credentials.getPwd().equals("Tobi2008")) {
			loginService.setLoggedIn(true);			
			return new RedirectView("/home");
		} else {
			System.out.println("failed");
			loginService.setLoggedIn(false);
			return new RedirectView("/");
		}
	    
	}

}
