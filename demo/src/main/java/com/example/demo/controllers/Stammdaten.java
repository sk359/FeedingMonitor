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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.dto.CatInfo;
import com.example.demo.model.dto.Feeding;
import com.example.demo.model.dto.ProductTasteDto;
import com.example.demo.model.dto.StammProductDto;
import com.example.demo.model.dto.TableColumn;
import com.example.demo.model.dto.TableParams;
import com.example.demo.model.orm.StammBrand;
import com.example.demo.model.orm.StammProduct;
import com.example.demo.model.orm.StammProductTaste;
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
		
		System.out.println(tableName);
		
		
		if (tableName.equals("stamm_product")) {
			System.out.println("Podukte");
			model.addAttribute("brands", brands);
			Collection<StammProduct> rows = stammRepository.getAllProducts();
			model.addAttribute("rows", rows);
			for (StammProduct row : rows) {
				System.out.println(row);
			}
		} else if (tableName.equals("stamm_brand")) {
			model.addAttribute("rows", brands);
		} else if (tableName.equals("stamm_product_taste")) {
			Collection<StammProduct> rows = stammRepository.getAllProducts();
			/*
			List<String> productNames = new ArrayList<String>();			
			for (StammProduct row : rows) {
				productNames.add(row.getName());
			}
			*/
			model.addAttribute("products", rows);
			Collection<StammProductTaste> tastes = stammRepository.getAllTastes();
			model.addAttribute("rows", tastes);
		}
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
	
	// Individual tables:
	
	@PostMapping(value="/stamm_brand")
	public RedirectView post(@ModelAttribute StammBrand brand, RedirectAttributes attributes){
		stammRepository.save(brand);
		return new RedirectView("/stammdaten");
	}
	
	@PostMapping(value="/stamm_product")
	public RedirectView postProduct(@ModelAttribute StammProductDto productDto, RedirectAttributes attributes){
		System.out.println(productDto);
		StammProduct product = productFromDto(productDto);
		stammRepository.save(product);
		return new RedirectView("/stammdaten?name=stamm_product");
	}
	
	private StammProduct productFromDto(StammProductDto dto) {
		StammProduct product = new StammProduct();
		product.setName(dto.getName());
		product.setFoodType(dto.getFoodType());
		StammBrand brand = stammRepository.getBrandById(dto.getStammBrandId());
		product.setBrand(brand);
		return product;
	}
	
	@PostMapping(value="/stamm_product_taste")
	public RedirectView postTaste(@ModelAttribute ProductTasteDto tasteDto, RedirectAttributes attributes){
		StammProductTaste dbTaste = tasteFromDto(tasteDto);
		stammRepository.save(dbTaste);
		return new RedirectView("/stammdaten?name=stamm_product_taste");
	}
	
	private StammProductTaste tasteFromDto(ProductTasteDto dto) {
		StammProductTaste dbTaste = new StammProductTaste();
		dbTaste.setName(dto.getTaste());		
		StammProduct prod = stammRepository.getProductById(dto.getStammProductId());
		dbTaste.setProduct(prod);		
		return dbTaste;
	}

}
