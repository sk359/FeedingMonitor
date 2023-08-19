package com.example.demo.model.enums;

public enum FoodType {
	TROCKEN("trocken"), NASS("nass");

    private String name;

    private FoodType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
