package com.merchants.guide.types;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpecialCurrencyTypesTest {

	@Test
	public void testGetDescription() {
		assertNotNull(SpecialCurrencyTypes.GOLD.getDescription());
		assertNotNull(SpecialCurrencyTypes.SILVER.getDescription());
		assertNotNull(SpecialCurrencyTypes.IRON.getDescription());
	}

}
