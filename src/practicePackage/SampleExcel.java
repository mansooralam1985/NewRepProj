package practicePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;

public class SampleExcel {
	static int rownum;
	static int colnum;
	static String data;
	
	static String iArray[]={"TestName","Actual","Expected","Time","Date"};
	static String iNum[]={"1","2","3","4","5"};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		FileInputStream fis =null;
		fis = new FileInputStream("C:\\Users\\iDeliver1\\Desktop\\Book1_ERp.xlsx");
		
		//FileInputStream fis=new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=null;
		Row row=null;
	    
	    
	  //get sheet 
		
		try{
	  		 sh = wb.createSheet("SheetN");
	  		 row=sh.createRow(0);
		 }
		
		catch(Exception e){
			
		}
	  		
	  		
	        
	  		sh = wb.getSheet("SheetN");
	  		row=sh.getRow(sh.getLastRowNum());
	  		rownum = sh.getLastRowNum();
	  		sh.createRow(rownum+1);
	  		 
		  	//Enter the 1st column details	
		  		
		  		for(int i=0;i<=4;i++)
		  		{
		  			
		  	        //	row.createCell(i).setCellValue(iArray[i]);
		  	     	
		  			//create cell
		  			
		  			sh.getRow(sh.getLastRowNum()).createCell(i).setCellType(CellType.STRING);
		  			
		  			//enter data
		  	     	sh.getRow(sh.getLastRowNum()).getCell(i).setCellValue(iArray[i]);
		  	     	
	    	        //wb.createSheet("kumar").createRow(0).createCell(i).setCellValue(iArray[i]);
	  		    }
		  		
		  		
		  		
		  		
		  		System.out.println(row.getLastCellNum());
		  		
		  	//Enter data in all column	
		  		
		  		rownum = sh.getLastRowNum();
		  		
		  		
		  		for(int i=rownum;i<=rownum+4;i++){
		  			
		  			
			  		row=sh.createRow(sh.getLastRowNum()+1);
			  		
				  		for (int colm=0;colm<=4;colm++)
			  			{
				  			row.createCell(colm).setCellType(CellType.STRING);
				  			sh.getRow(sh.getLastRowNum()).getCell(colm).setCellValue(iNum[colm]);
				  			
			  				
			  				
			  			}
				  	//	row.createCell(i).setCellValue(iNum[i]);	 
			   		
		  		}
	  
		  		
		  	/*	for (int r=rownum;r<=4+rownum;r++){
		  			//create row
		  			//sh.createRow(r+1);
		  		
		  			//create cell
		  			
		  			for (int colm=0;colm<=4;colm++)
		  			{
		  				sh.createRow(r).createCell(colm).setCellType(CellType.STRING);
		  				sh.getRow(r).getCell(colm).setCellValue(iNum[colm]+"colm"+colm);
		  				
		  				
		  			}		  			
		  			
		  		}*/
		  		
		  		
		
	  		FileOutputStream fout = new FileOutputStream("D:/Practice123.xlsx");
			
			wb.write(fout);
				
			wb.close();
		
		
	}

}
