package com.merchants.guide.utils;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilityTest {

	@Test
	public void testCapitalizeFirstLetter() {
		StringUtility stringUtility = new StringUtility();
		String input = "glob";
		String output = stringUtility.capitalizeFirstLetter(input);
		Assert.assertEquals(output, "Glob");
	}
	
}
