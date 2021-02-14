package com.restapi.extent;

public class ExtentLogger {

	
	
	
	public static void addauthor(String[] author)
	{
		for (String string : author) {
			ExtentManager.getExtentTest().assignAuthor(author);
		}
	}
}
