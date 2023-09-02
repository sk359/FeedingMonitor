package com.example.demo.model.dto;

import java.util.List;

/*
 * 
 * Konfiguriert Tabelle im HTML-Template fuer Stammdatenbearbeitung und Anzeige
 * 
 */

public class TableParams {
	
	private String tableName;
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<TableColumn> getColumns() {
		return columns;
	}

	public void setColumns(List<TableColumn> columns) {
		this.columns = columns;
	}

	private List<TableColumn> columns;

}
