package com.example.demo.model.orm;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "feeding")
public class Feeding extends Base {
	
	@Column(length = 32, nullable = false, unique = true)	
	private String catname;
	
	@Column(nullable = false, unique = true)	
	private String brandname;
	
	@Column(nullable = false, unique = true)	
	private String productname;
	
	@Column(nullable = false, unique = true)	
	private String taste;
	
	@Enumerated(EnumType.STRING)
    private String type;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP) // soll postgres timestamp mappen
	@Column
	private java.util.Date feedingtime;
	
	@Column	
	private Integer eatenpercentage;

}
