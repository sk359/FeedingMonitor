package com.example.demo.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.dto.Feeding;
import com.example.demo.model.dto.TableColumn;
import com.example.demo.model.dto.TableParams;
import com.example.demo.model.orm.StammBrand;
import com.example.demo.model.repositories.StammdatenRepository;

@Controller
@RequestMapping("/stammdaten")
public class Stammdaten {
	
	@Autowired
	StammdatenRepository stammRepository;
	
	@GetMapping
	String get(Model model, @RequestParam(required = false) String tableName){
	    //mapped to hostname:port/home/
		if (tableName == null) {
			tableName = "stamm_brand";
		}
		model.addAttribute("tableName", tableName);
		//model.addAttribute("newFeeding", new Feeding());
		
		Collection<StammBrand> brands = stammRepository.getAllBrands();
		
		for (StammBrand brand : brands) {
			System.out.println(brand);
		}
		
		model.addAttribute("rows", brands);
		/*
		List<TableColumn> cols = new ArrayList<TableColumn>();	
	    cols.add(new TableColumn("name", "Marke"));
		model.addAttribute("columns", cols);
		*/
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();  
		String nowString = dtf.format(now);
		model.addAttribute("nowTime", nowString);
	    return "stammdaten";
	}
	
	private TableParams constructTableParams(String tableName) {
		TableParams params = new TableParams();
		params.setTableName(tableName);
		if (tableName == "stamm_brand") {
		    List<TableColumn> cols = new ArrayList<TableColumn>();	
		    cols.add(new TableColumn("name", "Marke"));
		}
		
		return params;
	}

}
