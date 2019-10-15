package com.pack.generic;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.HSSFColor.BLACK;
import org.apache.poi.hssf.util.HSSFColor.GREEN;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataConfig {
	 FileInputStream fis;
	 FileOutputStream fos;
	// Workbook wb;
	 XSSFWorkbook wb;
	 HSSFWorkbook wb1;
	 XSSFSheet sheet;
	 XSSFRow row = null;
	 XSSFCell cell = null;
	 XSSFFont font = null;
     XSSFCellStyle style = null;
     String excelpath;
	
    public ExcelDataConfig(String excelpath) throws Exception {
    	this.excelpath= excelpath;
    	fis= new FileInputStream(excelpath);
    	wb= new XSSFWorkbook();
    	fis.close();
    }
     
	public String getdata(int sheetindex,int rownum,int colnum){
		
		// read in excel
		File src=new File(excelpath);	
		try {
			fis = new FileInputStream(src);	
			wb = new  XSSFWorkbook(fis);
		} catch (Exception e) {		
			System.out.println(e.getMessage());
		}		
		sheet = wb.getSheetAt(sheetindex);     
		String data = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		return data;	
	}
	
	public void setdata(int sheetindex, int rownum,int colnum,String strValue) throws Throwable{
		// Write in excel
				File src=new File(excelpath);	
				fis = new FileInputStream(src);	
				wb = new  XSSFWorkbook(fis);
				sheet = wb.getSheetAt(sheetindex);
				sheet.createRow(rownum); 
				sheet.getRow(rownum).createCell(colnum).setCellValue(strValue);
				fos = new FileOutputStream(src);
				wb.write(fos);
				wb.close();
				fos.close();
	}
	
	public void setcelldata(String sheetname, int rownum,String colname,String strValue) throws Throwable{
	
		fis = new FileInputStream(excelpath);
	    fos = null;
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet(sheetname);
        row = null;
	    cell = null;
	    font = wb.createFont();
	    style = wb.createCellStyle();
	 
	    int col_Num = -1;
        row = sheet.getRow(0);
        for(int i = 0; i < row.getLastCellNum(); i++)
        {
            if(row.getCell(i).getStringCellValue().trim().equals(colname))
            {
                col_Num = i;
            }
        }
        
        row = sheet.getRow(rownum);
        if(row == null)
            row = sheet.createRow(rownum);
            cell = row.getCell(col_Num);
        if(cell == null)
            cell = row.createCell(col_Num);
        if (strValue.equalsIgnoreCase("PASS"))
        font.setFontName("Comic Sans MS");
        font.setFontHeight(11.0);
        font.setBold(true);
        font.setColor(BLACK.index);
       
 
        style.setFont(font);
        style.setFillForegroundColor(HSSFColor.GREEN.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
       System.out.println( style.getFillBackgroundColorColor());
        
        cell.setCellStyle(style);
        cell.setCellValue(strValue);
 
        fos = new FileOutputStream(excelpath);
        wb.write(fos);
        fos.close();
	}

}
