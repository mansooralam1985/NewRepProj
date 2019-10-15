package JenkinsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class JenkinsDemo {
	static WebDriver driver=null;
	@Test
	public void testJenkins() throws InterruptedException{
		System.out.println("Welcome to jenkins");
		System.out.println("Test Started");
			
			//launch Firefox Driver
			driver = new FirefoxDriver();
		    WebDriverWait wait = new WebDriverWait(driver,30);
			//--------------------------
			//Navigate to Url :	
			driver.navigate().to("https://www.google.com");
				
			System.out.println(" Successfull");
	}

}
