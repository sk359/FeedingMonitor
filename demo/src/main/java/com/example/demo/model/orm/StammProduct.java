package com.example.demo.model.orm;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="stamm_product")
public class StammProduct extends Base {
	
	@Column(length = 32, nullable = false)	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length = 16, nullable = false, name="food_type")	
	private String foodType;
	
	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String food_type) {
		this.foodType = food_type;
	}
	
	//@ManyToOne
	//@JoinColumn(name="stamm_brand_id", nullable=false)
	private StammBrand brand;

	@ManyToOne // in neueeren Version direkt ueber Attribut???
	@JoinColumn(name="stamm_brand_id", nullable=false)
	public StammBrand getBrand() {
		return brand;
	}
	
	
	private String brandName;
	
	@Transient
	public String getBrandName() {
		return brand.getName();
	}
	
	
	public void setBrandName(String name) {
		brand.setName(name);
	}

	public void setBrand(StammBrand brand) {
		this.brand = brand;
	}
	
	//@OneToMany(mappedBy="brand")
	private List<StammProductTaste> tastes;	
		
	@OneToMany(mappedBy="product")
	public List<StammProductTaste> getTastes() {
		if (tastes != null) {
		    return tastes;
		}
		return new ArrayList<StammProductTaste>();
	}

	public void setTastes(List<StammProductTaste> tastes) {
		this.tastes = tastes;
	}
	
	@ElementCollection
    @CollectionTable(name = "stamm_product_taste", joinColumns = @JoinColumn(name = "product_id"))
	@Column(name="taste") // => stamm_product_taste.taste
    private Set<String> tasteNames;
	

}
