package com.merchants.guide.types;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordQuestionTypeTest {

	@Test
	public void testGetDescription() {
		assertNotNull(WordQuestionType.TYPE_ONE.getDescription());
		assertNotNull(WordQuestionType.TYPE_TWO.getDescription());
	}

}
