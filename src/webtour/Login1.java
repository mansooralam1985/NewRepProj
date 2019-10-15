package webtour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login1 {

	WebDriver driver;
	public Login1(WebDriver driver)
	
	{
		this.driver = driver;
	}
	
	public void Login(String Username,String Password) throws InterruptedException  
	
	{
		//enter username
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(Username);
				
	    //enter user password
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
				
		//click on login
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Thread.sleep(2000);
	}
	
}
