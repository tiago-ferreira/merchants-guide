package com.merchants.guide.types;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordSplitTypeTest {

	@Test
	public void testGetDescription() {
		assertNotNull(WordSplitType.TYPE_SPLIT.getDescription());
	}
}