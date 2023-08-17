package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.Feeding;

// 

@Controller
@RequestMapping("/fuetterung")
public class FeedingController {
	
	@GetMapping
	String get(Model model){
	    //mapped to hostname:port/home/
		model.addAttribute("data", null);
	    return "feeding";
	}
	  
	@PostMapping
	String post(@ModelAttribute("newFeeding") Feeding mf, Model model){
	    //mapped to hostname:port/home/
	    return "feeding";
	}

}
