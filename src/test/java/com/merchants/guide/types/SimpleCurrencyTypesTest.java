package com.merchants.guide.types;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleCurrencyTypesTest {

	@Test
	public void testGetDescription() {
		assertNotNull(SimpleCurrencyTypes.GLOB.getDescription());
		assertNotNull(SimpleCurrencyTypes.PROK.getDescription());
		assertNotNull(SimpleCurrencyTypes.PISH.getDescription());
		assertNotNull(SimpleCurrencyTypes.TEGJ.getDescription());
	}

}
