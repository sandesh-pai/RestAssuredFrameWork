package com.restapi.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.restapi.dataUtils.ExcelUtils;

public class MethodInterceptors implements IMethodInterceptor{

	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context)
	{

	
	 List<Map<String, String>> list = ExcelUtils.getData("runner");
	 List<IMethodInstance> result = new ArrayList<IMethodInstance>();
	 
	 for (int i = 0; i < list.size(); i++) {
		 for (int j = 0; j < methods.size(); j++) {
			 if (methods.get(j).getMethod().getMethodName().equalsIgnoreCase(list.get(i).get("testcasename"))) {
				 if (list.get(i).get("execute").equalsIgnoreCase("yes")) {
					 result.add(methods.get(j));
					
				}
				
			}
			
		}
		
	}
	 
	 
	 
		return result;
	}

	
	
}
