package com.pack.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilityLib {
	
//	static WebDriver driver ;
	static long screenno;
	public static String ScreenShot(WebDriver driver,String resultfilepath){
		// create TakeScreenshot object
		TakesScreenshot shot = (TakesScreenshot) driver;
	
		//take screenshot and store in a file object
	
		File sourceimage = shot.getScreenshotAs(OutputType.FILE);
		
		//create a flank file to store screenshot
		String tempfile= resultfilepath +"/" +"screenshot "+UtilityLib.Time_stamp()+".png";
		
		File destinationimage = new File(tempfile);
		
		//copyfile (SourceImage,destinationimage);
		try {
			FileUtils.copyFile(sourceimage,destinationimage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("From catch");
		}
		//System.out.println("capture");
		//screenno++;
		return tempfile ;
	}
	
	public static String TakeScreenShot(WebDriver driver){
		// create TakeScreenshot object
		TakesScreenshot shot = (TakesScreenshot) driver;
	
		//take screenshot and store in a file object
	
		File sourceimage = shot.getScreenshotAs(OutputType.FILE);
		
		//create a flank file to store screenshot
		String tempfile=System.getProperty("user.dir")+"/TestResult/"+"screenshot "+UtilityLib.Time_stamp()+".png";
		
		File destinationimage = new File(tempfile);
		
		//copyfile (SourceImage,destinationimage);
		try {
			FileUtils.copyFile(sourceimage,destinationimage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("From catch");
		}
		//System.out.println("capture");
		//screenno++;
		return tempfile ;
	}

	//================================================================================================
	public static String Time_stamp()
	{
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	String time = dateFormat.format(now);
	return time;
	}
	
	//===============================================================================================
	public static  void TakeScreenShotM2(WebDriver driver){
		
		EventFiringWebDriver edriver;
		
		edriver= new EventFiringWebDriver(driver);
		
		//File SourceImage;
		File SourceImage = edriver.getScreenshotAs(OutputType.FILE);
						
		//create a flank file to store screenshot
		
		File destinationimage = new File("C:\\Temp\\SeleniumScreenShot\\"+UtilityLib.Time_stamp()+".png");
		
		//copyfile (SourceImage,destinationimage);
		
		try {
			FileUtils.copyFile(SourceImage,destinationimage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("From catch");
		}
		System.out.println("capture");
		
	}
	
	
//	public static void main(String[] args){
//		
//		for(int i=1;i<3;i++)
//		{
//		driver = new FirefoxDriver();
//		driver.navigate().to("https://www.gmail.com");
//		UtilityLib scs = new UtilityLib();
//		scs.TakeScreenShot();
//		System.out.println("captured done");
//		driver.close();
//		}		
//	}
	
	
}
