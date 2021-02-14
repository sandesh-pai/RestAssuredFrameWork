package com.restapi.FrameworkConstatnts;

public class FrameworkConstatnts {
	
	
	private static final String EXCELPATH = System.getProperty("user.dir") + 
			                                    "/src/main/java/com/restapi/testresources/testdata.xlsx";

	/**
	 * @return the eXCELPATH
	 */
	
	
	public static String getEXCELPATH() {
		return EXCELPATH;
	}

}
