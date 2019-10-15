package webtour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Enterpassengerdetal {
	
	
	WebDriver driver;
	public Enterpassengerdetal(WebDriver driver)
	
	{
		this.driver = driver;
	}
	
	public void Enterpassengerdetal1(String firstnam, String lastname, String creditno) throws InterruptedException
	
	{
		        //enter passenger names 
				driver.findElement(By.name("passFirst0")).sendKeys(firstnam);
				driver.findElement(By.name("passLast0")).sendKeys(lastname);
				
				//enter credit card no
				
				driver.findElement(By.name("creditnumber")).sendKeys(creditno);
				
				//click on by tickets
				driver.findElement(By.name("buyFlights")).click();
				Thread.sleep(2000);
				
				//getting the order no of flight confirmation
				String Order_No = driver.findElement(By.xpath("//font[contains(text(),'Confirmation')]")).getText();
				System.out.println("Order No= "+Order_No);
				
				//Order_No.equalsIgnoreCase(arg0);
				driver.close();
		
	}
	

}
