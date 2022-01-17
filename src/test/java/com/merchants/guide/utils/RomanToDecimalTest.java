package com.merchants.guide.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanToDecimalTest {

	@Test
	public void testRomanToDecimal() {
		RomanToDecimal rd = new RomanToDecimal();
		int actual = rd.romanToDecimal("MCMIII");
		int expected = 1903;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsRoman() {
		RomanToDecimal rd = new RomanToDecimal();
		String actual = "MCMIII";
		boolean resp = rd.isRoman(actual);
		assertTrue(resp);
	}
	
	@Test
	public void testIsNotRoman() {
		RomanToDecimal rd = new RomanToDecimal();
		String actual = "34";
		boolean resp = rd.isRoman(actual);
		assertFalse(resp);
	}

}
