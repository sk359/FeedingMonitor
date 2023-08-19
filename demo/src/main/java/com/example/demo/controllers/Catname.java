package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.dto.CatInfo;
import com.example.demo.services.LogIn;

/*
 * Einstiegsmaske mit Input fuer Name
 */

@Controller
@RequestMapping("/")
public class Catname {
	
	@Autowired
	private LogIn loginService; 
	
	@GetMapping
	String get(Model model){
	    //mapped to hostname:port/home/
		model.addAttribute("greeting", "Hallo Welt!!");
	    return "home";
	}
	  
	@PostMapping
	public RedirectView post(@RequestBody CatInfo cat, RedirectAttributes attributes){
	    //mapped to hostname:port/home/
		// redirect
		System.out.println(cat);
	    //return "home";
		if (cat.getName().equals("Tobi")) {
			loginService.setLoggedIn(true);
			attributes.addAttribute("catname", cat.getName());
			return new RedirectView("/fuetterung");
		} else {
			System.out.println("failed");
			loginService.setLoggedIn(false);
			return new RedirectView("/");
		}
	    
	}

}
