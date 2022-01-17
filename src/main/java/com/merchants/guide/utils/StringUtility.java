package com.merchants.guide.utils;

import java.util.List;

public class StringUtility {

	public void printList(List<String> listToPrint) {
		listToPrint.forEach(System.out::println);
	}
	
	public String capitalizeFirstLetter(String input){
		return input.substring(0, 1).toUpperCase() + input.substring(1);
	}
	
}
