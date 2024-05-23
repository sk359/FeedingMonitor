package com.example.demo.model.orm;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="stamm_brand")
public class StammBrand extends Base {
	
	@Column(length = 32, nullable = false)	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//@OneToMany(mappedBy="brand")
	private List<StammProduct> products;	
	
	@OneToMany(mappedBy="brand")
	public List<StammProduct> getProducts() {
		if (products != null) {
		    return products;
		}
		return new ArrayList<StammProduct>();
	}

	public void setProducts(List<StammProduct> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return String.format("Brand ID %d with name %s", getId(), getName());		
	}

}
