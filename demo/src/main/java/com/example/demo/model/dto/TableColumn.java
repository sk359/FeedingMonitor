package com.example.demo.model.dto;

public class TableColumn {
	
	private String displayName;
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	private String dbName;
	
	public TableColumn(String dbName, String display) {
		this.setDbName(dbName);
		this.setDbName(dbName);
	}

}
