package com.pack.excelNew;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class screenshooot {
  @Test
  
  public void ScreenshotGoogl() 
  
  {
	 WebDriver driver = new FirefoxDriver();
	 
	 driver.manage().window().maximize();
	 
	 driver.get("https://www.google.com");
	 
	 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 
	 
	  
  }
}
