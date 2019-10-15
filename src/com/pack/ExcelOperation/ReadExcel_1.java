package com.pack.ExcelOperation;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel_1 {

	public static void main(String[] args) throws Exception {
	
		try {
			File src=new File("D:\\SeleniumExcel_01Oct\\Book1.xlsx");
			                   
			FileInputStream fis = new FileInputStream(src);
			
			XSSFWorkbook wb = new  XSSFWorkbook(fis);
			
			XSSFSheet Sheet1 = wb.getSheet("Sheet1");
			
			int rowcount = Sheet1.getLastRowNum();
             XSSFRow row = Sheet1.getRow(rowcount);
             short colcount = row.getLastCellNum();
           
			System.out.println("Total row is : " + (rowcount+1));
			System.out.println("Total column is : " + (colcount));
			for(int i=0;i<=rowcount;i++)
			{
				for(int j=0;j<=colcount;j++)
				{
					String celldata= Sheet1.getRow(i).getCell(j).getStringCellValue();	
					System.out.println("cell data is "+celldata );
					
					
				}
				
			}
			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	    
		
	}
	
}
