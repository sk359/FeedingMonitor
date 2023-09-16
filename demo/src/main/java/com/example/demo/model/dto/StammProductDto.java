package com.example.demo.model.dto;



public class StammProductDto {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	private String foodType;
	
	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String food_type) {
		this.foodType = food_type;
	}
	
	public long getStammBrandId() {
		return stammBrandId;
	}

	public void setStammBrandId(long stammBrandId) {
		this.stammBrandId = stammBrandId;
	}

	private long stammBrandId;
	
	@Override
	public String toString() {
		return String.format("Product DTO name %s, brand ID %s", getName(), getStammBrandId());		
	}

}
