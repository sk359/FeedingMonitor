package com.example.demo.model.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "stamm_brand")
public class StammBrand extends Base {
	
	@Column(length = 32, nullable = false)	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	@Override
	public String toString() {
		return String.format("Bramd name %s", getName());		
	}

}
