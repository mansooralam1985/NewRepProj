package com.pack.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {

	Workbook wb;
	String ExcelFileName= "MakeMyTripData";
	String excelpath =System.getProperty("user.dir")+"/Excel Data/"+ExcelFileName+".xlsx";
	
	public String ReadExcelData(String sheetName,int rownum,int colnum) throws Exception{
		
		FileInputStream fis =null;
		
		try {
		fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if(excelpath.endsWith(".xlsx")){
//			//initialize with .xlsx workbook instance
//			wb = new XSSFWorkbook(fis);
//	}
//			else{
//			wb = new HSSFWorkbook(fis);	
//			
//		}
		
		Workbook wb = WorkbookFactory.create(fis);
		
		//get sheet
		Sheet sh = wb.getSheet(sheetName);
		
		//get row
		Row row =sh.getRow(rownum);

		//get cell with column
		Cell cell = row.getCell(colnum);
		
		//get value as a string
		DataFormatter df = new DataFormatter();
		
		String datvalue = df.formatCellValue(cell);
		
		return datvalue;
	
	}
	public  void SetExcelData(String sheetname, int rownum,int colnum,String data) throws IOException, EncryptedDocumentException, InvalidFormatException{
		
		FileInputStream fis =null;
		Workbook wb = null;
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			wb = WorkbookFactory.create(fis);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//get sheet 
		Sheet sh = wb.getSheet(sheetname);	
		
		//get row
		
		//Row row = sh.getRow(rownum);
		Row row=sh.createRow(rownum);
		//get cell
		//Cell cell = row.getCell(colnum);
		Cell cell = row.createCell(colnum);
		//set cell val as a string
		cell.setCellType(CellType.STRING);
		
		//set value in cell
		cell.setCellValue(data);			
		
		FileOutputStream font = new FileOutputStream(excelpath);
			
		wb.write(font);
			
		wb.close();
			
	}
		
	
	public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
		
		ExcelLibrary reddata = new ExcelLibrary();
		for(int k=1;k<=5;k++){
			String str = reddata.ReadExcelData("Sheet2", k, 0);
	    	System.out.println(str);
	    }
	    String iArray[]={"TestName","Actual","Expected","Time","Date"};
	    
	    ExcelLibrary writedata = new ExcelLibrary();
		

	    for(int i=0;i<=5;i++){
	    	String Sheet2 = null;
	    	writedata.SetExcelData(Sheet2, 5, i, iArray(i));
	    }
	    
	    
	   
	   // System.out.println( reddata.ReadExcelData("Sheet1", 20, 20));
	   
	    }
	private static String iArray(int i) {
		// TODO Auto-generated method stub
		return null;
	}
		
	
	
	
}