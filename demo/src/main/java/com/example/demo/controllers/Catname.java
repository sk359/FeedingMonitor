package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Einstiegesmaske mit Input fuer Name
 */

@Controller
@RequestMapping("/")
public class Catname {
	
	@GetMapping
	String get(){
	    //mapped to hostname:port/home/
	    return "home";
	}
	  
	@PostMapping
	String post(){
	    //mapped to hostname:port/home/
		// redirect
	    return "home";
	}

}
