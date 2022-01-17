package com.merchants.guide.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Test;

public class PropertiesDAOTest {

	@Test
	public void testAddProperties() {
		PropertiesDAO.addProperties("glob", "I");
		PropertiesDAO.addProperties("pish", "X");
		String glob = PropertiesDAO.getProperty("glob");
		String pish = PropertiesDAO.getProperty("pish");
		assertEquals(glob, "I");
		assertEquals(pish, "X");
	}

	@Test
	public void testGetProperty() {
		PropertiesDAO.addProperties("glob", "I");
		PropertiesDAO.addProperties("pish", "X");
		String glob = PropertiesDAO.getProperty("glob");
		String pish = PropertiesDAO.getProperty("pish");
		String other = PropertiesDAO.getProperty("adsfadf");
		assertNotNull(glob);
		assertNotNull(pish);
		assertNull(other);
	}

	@Test
	public void testGetProperties() {
		Map<String,String> properties = PropertiesDAO.getProperties();
		assertNotNull(properties);
	}

}
