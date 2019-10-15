package com.pack.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

public class UtilityReport {
	
	//WebDriver driver;
	String filepath;
	ExtentReports report;
	ExtentTest logger;		
		
public void step(){
	report = new ExtentReports(filepath,true);
	report.addSystemInfo("Browser", "firefox");
	report.addSystemInfo("plateform", "Windows");
	report.config().documentTitle("Automation Testing");
	report.config().reportName("Regression Test 1.1");	
	report.config().reportHeadline("Gmail Testing");	
  }


}
