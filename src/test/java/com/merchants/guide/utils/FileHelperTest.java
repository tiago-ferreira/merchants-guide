package com.merchants.guide.utils;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class FileHelperTest {

	@Test
	public void testGetFile() {
		FileHelper fileHelper = new FileHelper();
		File file = fileHelper.getFile("input_data.txt");
		Assert.assertNotNull(file);
	}

}
