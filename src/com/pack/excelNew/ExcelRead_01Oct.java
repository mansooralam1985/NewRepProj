package com.pack.excelNew;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead_01Oct {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	File src = new File("D:\\SeleniumExcel_01Oct\\Book1.xlsx");
	
	FileInputStream fis = new FileInputStream(src);	
	
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	
	XSSFSheet Sheet1 = wb.getSheetAt(0);
	
	String data0 = Sheet1.getRow(0).getCell(0).getStringCellValue();         
	
	System.out.println("The Excel Data is : "+ data0);
	
    String data1 = Sheet1.getRow(0).getCell(1).getStringCellValue(); 
	
	System.out.println("The Excel Data is : "+ data1);
	
	wb.close();
	
	

	}

}
