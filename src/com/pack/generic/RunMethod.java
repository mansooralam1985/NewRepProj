package com.pack.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import com.pack.generic.UtilityLib;





import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RunMethod {
	static String FolderName = "TestResult";
//	static WebDriver driver ;
	//static long screenno;
	static ExtentReports report;
	static ExtentTest logger;	
	static  String filepath=System.getProperty("user.dir")+"/" + FolderName+"/" +UtilityLib.Time_stamp() +".html";
	
	
	
	public static void main(String[] args){
		report = new ExtentReports(filepath,true);
		System.setProperty("webdriver.chrome.driver", "D:\\leanFT\\Selenium Project\\Drivers\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();  
		logger = report.startTest("TC_Login","This is for Gmail Login")	;
		driver.navigate().to("https://www.gmail.com");
		logger.log(LogStatus.FAIL, "Object Changed");
		//calling Take Screen Shot Method1
		UtilityLib.TakeScreenShot(driver);    // pass the object of web driver


		report.addSystemInfo("Browser", "firefox");
		report.addSystemInfo("plateform", "Windows");
		report.config().documentTitle("Automation Testing");
		report.config().reportName("Regression Test 1.1");	
		report.config().reportHeadline("Gmail Testing");
		report.endTest(logger);
		report.flush();
		
		System.out.println("captured done");
	  }

		
			
		
	}

