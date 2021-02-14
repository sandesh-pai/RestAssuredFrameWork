package com.restapi.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.restapi.dataUtils.projectDataprovider;

public class Annotationtransformer implements IAnnotationTransformer{

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		annotation.setDataProviderClass(projectDataprovider.class);
		annotation.setDataProvider("getdata");
		
	}

}
