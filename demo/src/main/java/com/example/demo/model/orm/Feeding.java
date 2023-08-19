package com.example.demo.model.orm;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import com.example.demo.model.enums.FoodType;

@Entity
@Table(name = "feeding")
public class Feeding extends Base {
	
	
	@Column(length = 32, nullable = false)	
	private String catname;
	
	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	@Column(nullable = false)	
	private String brandname;
	
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
		return type.toString();
	}

	public void setType(String type) {
		this.type =type;
	}

	public java.util.Date getFeedingtime() {
		return feedingtime;
	}

	public void setFeedingtime(java.util.Date feedingtime) {
		this.feedingtime = feedingtime;
	}

	public Integer getEatenpercentage() {
		return eatenpercentage;
	}

	public void setEatenpercentage(Integer eatenpercentage) {
		this.eatenpercentage = eatenpercentage;
	}

	@Column(nullable = false)	
	private String productname;
	
	@Column(nullable = false)	
	private String taste;
	
	//@Enumerated(EnumType.STRING) // macht in Postgresql grosse Probleme!!
	@Column(name="type", nullable = false, length = 32)
    private String type;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP) // soll postgres timestamp mappen
	@Column
	private java.util.Date feedingtime;
	
	@Column	
	private Integer eatenpercentage;

}
