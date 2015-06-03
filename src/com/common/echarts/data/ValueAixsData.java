package com.common.echarts.data;

public class ValueAixsData {
	
	private String name;
	private String formatter;
	
	public ValueAixsData(String name, String formatter) {
		super();
		this.name = name;
		this.formatter = formatter;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFormatter() {
		return formatter;
	}
	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}
	
}
