package com.merchants.guide.utils;

import java.io.File;

public class FileHelper {

	public File getFile(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		return file;
	}

}
