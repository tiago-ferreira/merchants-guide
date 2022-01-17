package com.merchants.guide.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class CurrecyValueDAOTest {

	@Test
	public void testAdd() {
		CurrencyValueDAO.add("glob is I");
		CurrencyValueDAO.add("prok is V");
		CurrencyValueDAO.add("tegj is X");
		List<String> questions = CurrencyValueDAO.getCurrencyValues();
		assertNotNull(questions);
		assertTrue(questions.size() == 3);
	}

	@Test
	public void testGetQuestions() {
		List<String> questions = CurrencyValueDAO.getCurrencyValues();
		assertNotNull(questions);
		assertTrue(questions.size() == 3);
	}

}
