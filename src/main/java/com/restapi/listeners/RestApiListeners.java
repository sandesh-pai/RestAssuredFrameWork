package com.restapi.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.restapi.annotation.FrameworkAnnotation;
import com.restapi.extent.ExtentLogger;
import com.restapi.extent.ExtentManager;
import com.restapi.extent.ExtentReport;

public class RestApiListeners implements ITestListener{

	public void onTestStart(ITestResult result) {
	    ExtentReport.createNode(result.getMethod().getMethodName());
	    ExtentManager.getExtentTest().info(" Test has started");
		ExtentLogger.addauthor(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
	}

	public void onTestSuccess(ITestResult result) {
		
		 ExtentManager.getExtentTest().pass(result.getMethod().getMethodName() + " is passed successfully");
		
	}

	public void onTestFailure(ITestResult result) {
		 ExtentManager.getExtentTest().fail(result.getMethod().getMethodName() + " is failed");
		 ExtentManager.getExtentTest().fail(result.getThrowable());
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
