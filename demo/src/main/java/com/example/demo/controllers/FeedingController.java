package com.example.demo.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.dto.Feeding;
import com.example.demo.model.repositories.FeedingRepository;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

// 

@Controller
@RequestMapping("/fuetterung")
public class FeedingController {
	
	@Autowired
	private FeedingRepository repo;
	
	@GetMapping
	String get(Model model, @RequestParam(required = false) String catname){
	    //mapped to hostname:port/home/
		boolean submitDisabled = false; 
		if (catname ==null) {
			catname = "";
			submitDisabled = true;
		}
		model.addAttribute("catname", catname);
		model.addAttribute("newFeeding", new Feeding());	
		model.addAttribute("submitDisabled", submitDisabled);		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();  
		String nowString = dtf.format(now);
		model.addAttribute("nowTime", nowString);
	    return "feeding_overview";
	}
	  
	@PostMapping
	RedirectView post(@ModelAttribute("newFeeding") Feeding mf, Model model, RedirectAttributes attributes){
	    //mapped to hostname:port/home/
		//attributes.addAttribute("catname", mf.getCatname());
		//attributes.addFlashAttribute("catname", mf.getCatname());
		System.out.println(mf);
		com.example.demo.model.orm.Feeding newOrm = new com.example.demo.model.orm.Feeding();
		BeanUtils.copyProperties(mf, newOrm);
		repo.save(newOrm);
		String url = String.format("/fuetterung?catname=%s", mf.getCatname());
		return new RedirectView(url);
	}

}
