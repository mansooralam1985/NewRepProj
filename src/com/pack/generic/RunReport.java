package com.pack.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RunReport {
	WebDriver driver;
	
	//static String resultfilepath1 = System.getProperty("user.dir")+"/"+"TestResult"+"/" + UtilityLib.Time_stamp();   // can also write path like this
	
	static String resultfilepath = System.getProperty("user.dir")+"\\TestResult\\" + UtilityLib.Time_stamp();
	
	//static String filepath=resultfilepath +"/" +UtilityLib.Time_stamp();
	
	
	//String filepath=System.getProperty("user.dir")+"/" + FolderName+"/" +UtilityLib.Time_stamp();
	ExtentReports report;
	ExtentTest logger;	
	
@BeforeClass	
	public void step(){
		report = new ExtentReports(resultfilepath +"/" +UtilityLib.Time_stamp() + ".html",true); 
		report.addSystemInfo("Browser", "firefox");
		report.addSystemInfo("plateform", "Windows");
		report.config().documentTitle("Automation Testing");
		report.config().reportName("Gmail Testing");	
		report.config().reportHeadline("Regression Test 1.1");
		
	  }
	
@Test (priority=1)
	public void Login() throws InterruptedException{
		String strUrl= "https://mail.google.com/mail/";
		String strUserId = "mansoor@ideliver-inc.com";
		String strPassword = "iDeliver22";
		
		logger = report.startTest("TC_Login","This is forlLogin");
		System.setProperty("webdriver.ie.driver","D:\\leanFT\\Selenium Project\\Drivers\\IEDriverServer.exe");
		//launch Firefox Driver
		driver = new InternetExplorerDriver();
		//driver = new FirefoxDriver();
//		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.manage().window().maximize();
		//--------------------------
		//Navigate to Url 
		driver.navigate().to(strUrl);
		logger.log(LogStatus.PASS, "Enter Url", "Successflly Nevigated with URL: " + strUrl);	
		//logger.log(LogStatus.INFO, "Application",logger.addScreenCapture(UtilityLib.TakeScreenShot(driver)));	
	   
		//enter user ID
		driver.findElement(By.id("identifierId")).sendKeys(strUserId);
		logger.log(LogStatus.PASS, "Enter UserId", "UserId Entered: "+strUserId);
		logger.log(LogStatus.INFO, "UserId",logger.addScreenCapture(UtilityLib.ScreenShot(driver,resultfilepath)));
		
		//click on next
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		Thread.sleep(2000);
				
		//enter user Password
		driver.findElement(By.name("password")).sendKeys(strPassword);      
		logger.log(LogStatus.PASS, "Enter Password", "Password Entered: "+strPassword);	
		logger.log(LogStatus.INFO, "Password",logger.addScreenCapture(UtilityLib.ScreenShot(driver,resultfilepath)));
	

		//click on Next
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		Thread.sleep(5000);	
		logger.log(LogStatus.PASS, "Gmail Login", "Login Successfull");	
		logger.log(LogStatus.INFO, "Home Page Displayed",logger.addScreenCapture(UtilityLib.ScreenShot(driver,resultfilepath)));
		
		Thread.sleep(1000);
}	

//compose mail=============================================
@Test (priority=2)
	public void ComposeMail() throws InterruptedException{		
		String strTo = "sourabh@ideliver-inc.com";
		String strCc=  "sourabh@ideliver-inc.com";
		String strBcc= "sourabh@ideliver-inc.com";
		String strMessageBody = "Hello World";
		String strSubject = "Selenium Testing";
		
		
		logger = report.startTest("TC_Compose", "This is for Compose Mail");
		boolean flag = driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).isDisplayed();
		Assert.assertTrue(flag, "Compose Not displayed");
			if(flag)
			{
				
				WebDriverWait wait = new WebDriverWait(driver,60);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]"))).click();
				
			// driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
			logger.log(LogStatus.PASS, "Click on Compose", "Successfully Clicked");	
			logger.log(LogStatus.INFO, "Compose",logger.addScreenCapture(UtilityLib.ScreenShot(driver,resultfilepath)));
			}
			else
			{
			logger.log(LogStatus.FAIL, "Click on Compose", "Failed to Clicked");	
			logger.log(LogStatus.FAIL, "Compose",logger.addScreenCapture(UtilityLib.ScreenShot(driver,resultfilepath)));
			}
		Thread.sleep(4000);	
		
		//======================= To ================================================================================================================
		
		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys(strTo+";");
		Thread.sleep(1000);	
		driver.findElement(By.xpath("//textarea[@name='to']")).click();
		logger.log(LogStatus.PASS, "Enter To", "Successfully Entered: "+strTo);
		
		// ====================== Cc ==================================================================================================================
		
		if( driver.findElement(By.xpath("//span[contains (text(),'Cc') and @aria-label='Add Cc Recipients ‪(Ctrl-Shift-C)‬']")).isDisplayed())
			{
			 driver.findElement(By.xpath("//span[contains (text(),'Cc') and @aria-label='Add Cc Recipients ‪(Ctrl-Shift-C)‬']")).click(); 
			 driver.findElement(By.xpath("//textarea[@name='cc']")).sendKeys(strCc+";");
			 logger.log(LogStatus.PASS, "Enter Cc", "Successfully Entered: "+strCc);
			}
	     else 
		    {   
	    	 driver.findElement(By.xpath("//textarea[@name='cc']")).click();
	    	 driver.findElement(By.xpath("//textarea[@name='cc']")).sendKeys(strCc+";");
	    	 logger.log(LogStatus.PASS, "Enter Cc", "Successfully Entered: "+strCc);
		    }

		Thread.sleep(1000);
			
		//=====================  Bcc =========================================================================================================	
		
		if( driver.findElement(By.xpath("//span[contains (text(),'Bcc') and @aria-label='Add Bcc Recipients ‪(Ctrl-Shift-B)‬']")).isDisplayed())
		    {
			driver.findElement(By.xpath("//span[contains (text(),'Bcc') and @aria-label='Add Bcc Recipients ‪(Ctrl-Shift-B)‬']")).click(); 
			driver.findElement(By.xpath("//textarea[@name='bcc']")).sendKeys(strBcc+";");
			logger.log(LogStatus.PASS, "Enter Bcc", "Successfully Entered: "+strBcc);
			}
		else 
			{   
			driver.findElement(By.xpath("//textarea[@name='bcc']")).click();
			driver.findElement(By.xpath("//textarea[@name='bcc']")).sendKeys(strBcc+";");
			logger.log(LogStatus.PASS, "Enter Bcc", "Successfully Entered: "+strBcc);
			}
		Thread.sleep(1000);		
	
		// ======================= Subject Line =================================================================================================	
		
		driver.findElement(By.xpath("//input[@name='subjectbox']")).click();
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys(strSubject);	
		logger.log(LogStatus.PASS, "Enter Subject Line", "Successfully Entered Subject: "+strSubject);
		Thread.sleep(1000);
		
		//========================= Write Message Body ==========================================================================================
		
		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).click();
		driver.findElement(By.xpath("//div[contains(@aria-label,'Message') and @role='textbox']")).sendKeys(Keys.CONTROL,Keys.HOME);
		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys(strMessageBody);
		logger.log(LogStatus.PASS, "Enter Message Body", "Successfully Entered Message Body: "+strMessageBody);
		logger.log(LogStatus.INFO, "Email details",logger.addScreenCapture(UtilityLib.ScreenShot(driver,resultfilepath)));
		
		//==========================Click on Send Button ========================================================================================
		driver.findElement(By.xpath("//div[contains(text(),'Send')]")).click();
		logger.log(LogStatus.PASS, "Click on Send", "Successfully clicked on Send Button");
		logger.log(LogStatus.INFO, "Send Successfull",logger.addScreenCapture(UtilityLib.ScreenShot(driver,resultfilepath)));
		System.out.println("Message sent");
		driver.close();
		driver.quit();
		
		
}
		
//========================================================================================================================================
		
	
//for generate html report		
@AfterMethod
	public void TearDown(){
		report.endTest(logger);
		report.flush();
	   }

}
