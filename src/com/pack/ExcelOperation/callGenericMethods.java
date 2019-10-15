package com.pack.ExcelOperation;

import com.pack.generic.ExcelDataConfig;

public class callGenericMethods {

	public static void main(String[] args) throws Throwable {
		
		ExcelDataConfig excel = new ExcelDataConfig("C:\\Users\\iDeliver1\\Desktop\\Book1_ERp.xlsx");
  
		//excel.setdata(0, 1, 1, "Hello World");
		
		excel.setcelldata("Sheet1", 4, "Status", "iDeliver1");
		
		System.out.println(excel.getdata(0, 4, 2));
		
		System.out.println("run completed ");
	}

}
