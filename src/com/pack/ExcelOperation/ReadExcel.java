package com.pack.ExcelOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws Exception {
		File src = new File("D:\\leanFT\\Selenium Project\\Excel Data\\GmailData.xlsx");
		
		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
//      HSSFWorkbook wb = new  HSSFWorkbook(fis);     // use for xls file only
		
		XSSFSheet Sheet1 = wb.getSheetAt(0);     // Sheet Index
		 
		String data0 = Sheet1.getRow(0).getCell(0).getStringCellValue();         
		
		System.out.println("The Excel Data is : "+ data0);
		
        String data1 = Sheet1.getRow(0).getCell(1).getStringCellValue(); 
		
		System.out.println("The Excel Data is : "+ data1);
		
		wb.close();
	}
	
	
}


