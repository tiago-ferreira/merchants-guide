package com.merchants.guide.dao;

import java.util.HashMap;
import java.util.Map;

public class PropertiesDAO {
	
	private static Map<String ,String> properties = new HashMap<String, String>();

	public static void addProperties(String key,String value) {
		PropertiesDAO.properties.put(key, value);
	}

	public static String getProperty(String key) {
		return PropertiesDAO.properties.get(key);
	}
	
	public static Map<String ,String> getProperties() {
		return PropertiesDAO.properties;
	}

}
