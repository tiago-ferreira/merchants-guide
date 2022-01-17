package com.merchants.guide.dao;

import java.util.LinkedList;
import java.util.List;

public class QuestionDAO {

	private static List<String> questions = new LinkedList<>();
	
	public static void add(String question) {
		QuestionDAO.questions.add(question);
	}
	
	public static List<String> getQuestions() {
		return QuestionDAO.questions;
	}

}
