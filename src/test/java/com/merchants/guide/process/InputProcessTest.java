package com.merchants.guide.process;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.StringTokenizer;

import com.merchants.guide.dao.PropertiesDAO;
import com.merchants.guide.types.SimpleCurrencyTypes;
import org.junit.Test;

public class InputProcessTest {

	@Test
	public void testGetValues() {
		InputProcess input = new InputProcess();
		String str = "glob is I";
		StringTokenizer tokenizer = input.getTokens(str);
		assertNotNull(tokenizer);
		assertTrue(tokenizer.countTokens() == 3);
	}
	
	@Test
	public void testIsQuestion() {
		InputProcess input = new InputProcess();
		String question = "how many Credits is glob prok Silver ?";
		boolean resp = input.isQuestion(question);
		assertTrue(resp);
	}

	@Test
	public void testProcessData() {
		InputProcess input = new InputProcess();
		input.loadFileData("input_test_data.txt");
		input.processCurrencyValues();
		String value = PropertiesDAO.getProperty(SimpleCurrencyTypes.GLOB.getDescription());
		assertNotNull(value);
	}
}
