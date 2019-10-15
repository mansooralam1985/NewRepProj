package com.pack.excelNew;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Result_04Oct {

	//Writing test Result in Excel Sheet
	
	public void updateResult(String excellocation,String sheetName,String testCaseName,String testStatus)
	
	{
	
	
	try {
		
		FileInputStream file  = new FileInputStream(new File(excellocation));
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
				
		int totalrow = sheet.getLastRowNum() +1;
		
		for (int i = 1; i < totalrow; i++){
			
			XSSFRow r = sheet.getRow(i);
			String ce = r.getCell(1).getStringCellValue();
			
			if (ce.contains(testCaseName)) {
				
			r.createCell(2).setCellValue(testStatus);
			file.close();
			System.out.println(testStatus);
			FileOutputStream outfile = new FileOutputStream(new File(excellocation));
			workbook.write(outfile);
			outfile.close();
			break;
			
			}} 
			
		} catch(Exception e) {
			e.printStackTrace();
			
			
			 
		}
	}
		
		public static void main(String[] args) throws IOException {
			
			String excellocation = "C:\\Users\\iDeliver1\\Desktop\\Book1_ERp.xlsx";
			String sheetname = "Sheet1";
			Excel_Result_04Oct excel = new Excel_Result_04Oct();
			//String[][] data = excel.getClass()
		   
			//System.out.println();
			
			 excel.updateResult(excellocation, sheetname , "Login Test", "pass");
			 
		}
		
}
		
	

