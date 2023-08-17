package com.example.demo.model.orm;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class Base {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)	
	//@Column
	private long id;
	
	@Basic
	@Temporal(TemporalType.TIME)
	@Column
	private java.util.Date created;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}
