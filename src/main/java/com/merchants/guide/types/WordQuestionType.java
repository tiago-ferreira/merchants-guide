package com.merchants.guide.types;

public enum WordQuestionType {

	TYPE_ONE("how much"),
	TYPE_TWO("how many");
	
	
	private String description;
	
	WordQuestionType(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description.toLowerCase();
	}
}
