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
	private String taste;

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}
	
	private StammProduct product;
	
	@ManyToOne // in neueeren Version direkt ueber Attribut???
	@JoinColumn(name="stamm_product_id", nullable=false)
	public StammProduct getProduct() {
		return product;
	}

}
