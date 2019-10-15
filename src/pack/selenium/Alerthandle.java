package pack.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alerthandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

	WebDriver Driver = new FirefoxDriver();	
	
		
		Driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");
		
		Thread.sleep(3000);
		
		Driver.findElement(By.xpath("//button[contains(text(),'Generate Alert Box')]")).click();
		
		Thread.sleep(3000);
		
		Alert alert = Driver.switchTo().alert();  
		
		alert.accept();
		
		Driver.close();
	}

}
