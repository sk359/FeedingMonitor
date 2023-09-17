package com.example.demo.model.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stamm_product_taste")
public class StammProductTaste extends Base {
	
	@Column(length = 32, nullable = false)	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private StammProduct product;
	
	@ManyToOne // in neueeren Version direkt ueber Attribut???
	@JoinColumn(name="stamm_product_id", nullable=false)
	public StammProduct getProduct() {
		return product;
	}
	
	public void setProduct(StammProduct prod) {
		this.product = prod;
	}

}
