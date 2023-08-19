package com.example.demo.model.dto;

public class CatInfo {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("Cat with name %s", getName());		
	}

}
