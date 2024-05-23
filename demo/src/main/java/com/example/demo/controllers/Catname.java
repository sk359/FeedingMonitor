package com.example.demo.controllers;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import com.example.demo.model.dto.CatInfo;


/*
 * Einstiegsmaske mit Input fuer Name
 */

@Controller
@RequestMapping("/home")
public class Catname {
	
	
	@GetMapping
	String get(Model model){	    
	    return "home";
	}
	
	// Multiple submits in one form => different params
	
	@PostMapping(params = "stammdaten")
	public RedirectView cancelUpdateUser(HttpServletRequest request) {
		return new RedirectView("/stammdaten");	    
	}
	  
	@PostMapping(params = "cat")
	public RedirectView post(@ModelAttribute CatInfo cat, RedirectAttributes attributes){	    
		System.out.println(cat);	    
		attributes.addAttribute("catname", cat.getName());
		return new RedirectView("/fuetterung");	    
	}

}
