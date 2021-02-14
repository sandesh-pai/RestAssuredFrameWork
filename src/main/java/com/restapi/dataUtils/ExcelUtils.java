package com.restapi.dataUtils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import com.restapi.FrameworkConstatnts.FrameworkConstatnts;

public class ExcelUtils {
	
	
	
	private static Map<String, String>map;
	private static FileInputStream file;
	private static XSSFWorkbook book;
	private static XSSFSheet sheet;
	private static List<Map<String, String>> list ;
	
	
	public  static List<Map<String, String>> getData(String sheetname)
	{
		try {
			file = new FileInputStream(FrameworkConstatnts.getEXCELPATH());
			book = new XSSFWorkbook(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetname);
		int lastrow = sheet.getLastRowNum();
		short lastcolumn = sheet.getRow(0).getLastCellNum();
		list = new ArrayList();
		for (int i = 0; i < lastrow; i++) {
		  map = new HashMap();
			for (int j = 0; j < lastcolumn; j++) {
				
				DataFormatter format = new DataFormatter();
				
				String key = format.formatCellValue(sheet.getRow(0).getCell(j));		
				String value = format.formatCellValue(sheet.getRow(i+1).getCell(j));
				map.put(key, value);
			    
			}
			
			list.add(map);
		}
		
		return list;
	}
	

}
