package com.restapi.dataUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class projectDataprovider {

	
	
	@DataProvider(parallel = true)
	public Object[] getdata(Method m)
	{
		String testname = m.getName();
	
		List<Map<String, String>> list = ExcelUtils.getData("data");
		List<Map<String, String>> iterationList = new ArrayList<Map<String,String>>();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).get("testcasename").equalsIgnoreCase(testname) &&  
					list.get(i).get("execute").equalsIgnoreCase("yes")) {
				
				iterationList.add(list.get(i));
			}
		
	
	}
		return iterationList.toArray();
}
}
