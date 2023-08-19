package com.example.demo.model.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Feeding {
	
	private String catname;
	private String brandname;
	private String productname;
	private String taste;
	private String type;
	private java.util.Date feedingtime;
	private Integer eatenpercentage;
	
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public java.util.Date getFeedingtime() {
		return feedingtime;
	}
	public void setFeedingtime(String feedingtimeString) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.ENGLISH);

		
		try {
			Date date = formatter.parse(feedingtimeString);
			this.feedingtime = date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*
	public void setFeedingtime(java.util.Date feedingtime) {
		this.feedingtime = feedingtime;
	}
	*/
	public Integer getEatenpercentage() {
		return eatenpercentage;
	}
	public void setEatenpercentage(Integer eatenpercentage) {
		this.eatenpercentage = eatenpercentage;
	}
	
	@Override
	public String toString() {
		return String.format("Cat with name %s, Art: %s", getCatname(), getType());		
	}

}
