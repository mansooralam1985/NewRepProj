package webtour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Findflight {
	

	WebDriver driver;
	public  Findflight(WebDriver driver)
	
	{
		this.driver = driver;
	}
	
	       public void Findflight1(String flightp) throws InterruptedException 
	       {
	       //select prefered flight
			WebElement Airline = driver.findElement(By.name("airline")); 	
			Select SelectAirline = new Select(Airline);
			SelectAirline.selectByVisibleText(flightp); 
			
			//click on search flights
			driver.findElement(By.name("findFlights")).click();   //input[@name='findFlights']
			Thread.sleep(2000);
			
			//selecting flight 
			driver.findElement(By.xpath("//input[@value='Blue Skies Airlines$361$271$7:10']")).click();
			
			//clicking on reserve flights
			driver.findElement(By.name("reserveFlights")).click();
			Thread.sleep(2000);
	       }

}
