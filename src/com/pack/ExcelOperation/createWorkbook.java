package com.pack.ExcelOperation;


import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class createWorkbook {
	Sheet sh;
	static Workbook wb;
	static String excelpath = "D:\\ExcelReport.xls";  //System.getProperty("user.dir")+"/Excel Data/"+ExcelFileName+".xlsx";
	
	public static void main(String[] args) throws Throwable {
	
		FileOutputStream fos = new FileOutputStream(excelpath);
		
		if(excelpath.endsWith(".xls"))  //To create a new WorkBook with xlx extension
		{
			wb = new HSSFWorkbook();
		}
		else
		{
			wb = new XSSFWorkbook();   //To create a new WorkBook with xlsx extension
		}
	
		//Sheet sheet = new Workbook();
		 wb.createSheet("Mansoor");
		 wb.createSheet("Rahul");
		 wb.createSheet("Ashish");
		 
		for (int i=0;i<10;i++)
		{
			wb.getSheet("mansoor").createRow(i);
			
			for(int j=0;j<10;j++){
				
				wb.getSheet("mansoor").getRow(i).createCell(j).setCellValue("iDeliver"+j);
				
		   }
		}
		 
		wb.write(fos);
		fos.close();	
		System.out.println("run complete");
		 
	}

}
