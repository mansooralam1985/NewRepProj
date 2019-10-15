package makemytrip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.pack.generic.UtilityLib;

public class FunctionLibrary {
	static Properties pObj;
	static String ExcelFileName= "MakeMyTripData";
	static String excelpath =System.getProperty("user.dir")+"/Excel Data/"+ExcelFileName+".xlsx";
	
public static String LoadFileData(String ORname,String Key){
	 				
	 FileInputStream objFile = null;
		pObj= new Properties();
	    String filepath = System.getProperty("user.dir")+"/src/objectRepository/"+ORname+".properties";	
	    try {
			objFile = new FileInputStream(filepath);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("File Not found");
		}
	    // load file 
	    try {
			pObj.load(objFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Unable to load file");
		}
	    return pObj.getProperty(Key);
    }

public static String ReadExcelData(String sheetName,String colData) throws Exception{  
	
		FileInputStream fis =null;
		Workbook wb;
		try {
		fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		wb = WorkbookFactory.create(fis);
		
		//get sheet--------
		Sheet sh = wb.getSheet(sheetName);
	
		//get row------
		int LastRow = sh.getLastRowNum();
		Row row =sh.getRow(0);
	    int totalcolm = row.getLastCellNum();
	   	    
	    
	    //for(int i=0;i<=LastRow-1;i++){
	    	for(int j=0;j<=totalcolm-1;j++){
	    		
	    		Cell cell = row.getCell(j);
	    		String colname = cell.toString();
	    		if (colname.equals(colData)){
	    			Row row1 =sh.getRow(1);
	    			Cell cell1 = row1.getCell(j);
	    			DataFormatter df = new DataFormatter();
	    			
	    			return df.formatCellValue(cell1);
	    			
	    		}	
		
	       }
	   //} 	
	return null;
	}

public  void SetExcelData(String sheetname, int rownum,int colnum,String data) throws IOException{
	
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
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
		
		//set alue in cell
		cell.setCellValue(data);			
		
		FileOutputStream font = new FileOutputStream(excelpath);
			
		wb.write(font);
			
		wb.close();
			
	}

static long screenno;

public static String TakeScreenShot(WebDriver driver){
	// create TakeScreenshot object
	TakesScreenshot shot = (TakesScreenshot) driver;

	//take screenshot and store in a file object

	File sourceimage = shot.getScreenshotAs(OutputType.FILE);
	
	UtilityLib.Time_stamp();
	//create a flank file to store screenshot
	String tempfile=System.getProperty("user.dir")+"/TestResult/screenshot "+screenno+".png";
	
	File destinationimage = new File(tempfile);
	
	//copyfile (SourceImage,destinationimage);
	try {
		FileUtils.copyFile(sourceimage,destinationimage);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("From catch");
	}
	System.out.println("capture");
	//screenno++;
	return tempfile ;
}

public static int Date(){
	Date dt= new Date();
	screenno = dt.getTime();
	return (int) screenno;
	
}

public static void TakeScreenShotM2(WebDriver driver){
	
	EventFiringWebDriver edriver;
	
	edriver= new EventFiringWebDriver(driver);
	
	//File SourceImage;
	File SourceImage = edriver.getScreenshotAs(OutputType.FILE);
			
	UtilityLib.Time_stamp();
	//create a flank file to store screenshot
	
	File destinationimage = new File("C:\\Temp\\SeleniumScreenShot\\"+screenno+".png");
	
	//copyfile (SourceImage,destinationimage);
	
	try {
		FileUtils.copyFile(SourceImage,destinationimage);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("From catch");
	}
	System.out.println("capture");
	//screenno++;
}
	public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
		
		FunctionLibrary reddata = new FunctionLibrary();
		
		String str = reddata.ReadExcelData("Sheet1","MobNumber");//, 1, 0);
		
		System.out.println(str);
		
	
	}

}
