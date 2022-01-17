package com.merchants.guide.dao;

import java.util.LinkedList;
import java.util.List;

public class CurrencyValueDAO {

	private static List<String> currencyValues = new LinkedList<>();
	
	public static void add(String string) {
		CurrencyValueDAO.currencyValues.add(string);
	}

	public static List<String> getCurrencyValues() {
		return CurrencyValueDAO.currencyValues;
	}
}
