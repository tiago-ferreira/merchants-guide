package com.merchants.guide.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class QuestionDAOTest {

	@Test
	public void testAdd() {
		QuestionDAO.add("how much is pish tegj glob glob ?");
		QuestionDAO.add("how many Credits is glob prok Silver ?");
		List<String> questions = QuestionDAO.getQuestions();
		assertNotNull(questions);
		assertTrue(questions.size() == 2);
	}

	@Test
	public void testGetQuestions() {
		List<String> questions = QuestionDAO.getQuestions();
		assertNotNull(questions);
		assertTrue(questions.size() == 2);
	}

}
