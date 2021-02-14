package com.restapi.extent;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	
	private static ExtentReports extent;
	
	
	public static void initextentreport()
	{
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
		extent.attachReporter(spark);
		spark.config().setDocumentTitle("API FRAMEWORK");
		spark.config().setTheme(Theme.STANDARD);
	}
	
	
	public static void createNode(String testname)
	{
		ExtentTest test = extent.createTest(testname);
		ExtentManager.setExtentTest(test);
		ExtentManager.getExtentTest();
	}
	
	public static void flushReporter()
	{
		extent.flush();
		
		try {
			Desktop.getDesktop().browse(new File("index.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
