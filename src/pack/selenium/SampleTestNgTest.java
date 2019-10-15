package pack.selenium;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleTestNgTest {
	
	@org.testng.annotations.BeforeTest
	public void launchBrowser()
	{
	
	WebDriver driver = new FirefoxDriver();
	driver.navigate().to("http://newtours.demoaut.com/");
	System.out.println("Launch Passed");
	}
	
	
	@Test(priority=2)
	public void methodTest1()
	{
		System.out.println("Test1"); 
	}
	@Test(priority=4)    //to set the priority of test while running
	public void methodTest2()
	{
		System.out.println("Test2");
	}
	@Test
	public void methodTest3()
	{
		System.out.println("Test3");
	}
	@Test
	public void methodTest4()
	{
		System.out.println("Test4");
	}
	
	 @org.testng.annotations.BeforeTest
	   public void BeforeTest()
	   {
		   System.out.println("BeforeTest");
	   }

	
   @AfterTest
   public void AfterTest()
   {
	   System.out.println("AfterTest");
   }
	
}
