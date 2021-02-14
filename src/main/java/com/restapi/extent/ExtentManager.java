package com.restapi.extent;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	
	
	
	private static ThreadLocal<ExtentTest> extest = new ThreadLocal<ExtentTest>();
	
	
	public static ExtentTest getExtentTest()
	{
		return extest.get();
	}
	
	public static void setExtentTest(ExtentTest test)
	{
		extest.set(test);
	}
	
	
	public static void unload()
	{
		extest.remove();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
