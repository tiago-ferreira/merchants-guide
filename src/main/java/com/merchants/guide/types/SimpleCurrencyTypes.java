package com.merchants.guide.types;

public enum SimpleCurrencyTypes {
	GLOB("glob"),
	PROK("prok"),
	PISH("pish"),
	TEGJ("tegj");

	private String description;
	
	SimpleCurrencyTypes(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description.toLowerCase();
	}
}
