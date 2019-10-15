package com.pack.ExcelOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws Exception {
	
		try {
			File src=new File("D:\\leanFT\\Selenium Project\\Excel Data\\GmailData.xlsx");
			                   
			FileInputStream fis = new FileInputStream(src);
			
			XSSFWorkbook wb = new  XSSFWorkbook(fis);
			
			XSSFSheet Sheet1 = wb.getSheetAt(0);     // Sheet Index
			 
			Sheet1.getRow(0).createCell(2).setCellValue("Status");      
			
			Sheet1.getRow(3).createCell(2).setCellValue("Pass");  
		    
			Sheet1.getRow(4).createCell(2).setCellValue("Fail");  
			
			FileOutputStream fos = new FileOutputStream(src);
			wb.write(fos);
			
			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	    
		System.out.println("Run Successfull");
	}
	
}
