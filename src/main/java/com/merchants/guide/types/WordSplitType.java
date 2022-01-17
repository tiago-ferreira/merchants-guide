package com.merchants.guide.types;

public enum WordSplitType {

	TYPE_SPLIT(" is ");
	
	
	private String description;
	
	WordSplitType(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description.toLowerCase();
	}

}
