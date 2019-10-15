package pack.selenium;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class WebTour {
	

	public static void main(String[] args) throws InterruptedException{
		//launch Firefox Driver
		WebDriver Driver = new FirefoxDriver();
		
		//Nevigate to Url :	
		Driver.navigate().to("http://newtours.demoaut.com/");
		
		
		//Verification in Login page
		
		String pagetile = "ARUBA" ;
		
		boolean flag = false;
		
		if (Driver.getTitle().equalsIgnoreCase(pagetile)) {
			
			
			flag = true;
			System.out.println("Yes... Page title matched");
			
			}
				
		 
		//synchronization-page sync
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//enter username
		Driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("jhon");
		
		//enter user password
		Driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mercury");
		
		//click on login
		Driver.findElement(By.xpath("//input[@name='login']")).click();
		Thread.sleep(2000);
		
		//Select total no of passenger
		WebElement element = Driver.findElement(By.name("passCount")); //select[@name='passCount']
		Select SelPass = new Select(element);
		SelPass.selectByVisibleText("2");
		Thread.sleep(2000);
		
		// Select Source station from dropdown
		WebElement element_fromPort = Driver.findElement(By.name("fromPort")); 	
		Select SelectFrom = new Select(element_fromPort);
		SelectFrom.selectByVisibleText("London");
		Thread.sleep(2000);
		
		// select month from dropdown		
		WebElement month = Driver.findElement(By.name("fromMonth")); 	
		Select SelectMonth = new Select(month);
		SelectMonth.selectByVisibleText("April");
		Thread.sleep(2000);
		
		//select date from dropdown
		WebElement Date = Driver.findElement(By.name("fromDay")); 	
		Select SelectDate = new Select(Date);
		SelectDate.selectByVisibleText("20");
		Thread.sleep(2000); 
		
		//select destination place
		WebElement Arriving = Driver.findElement(By.name("toPort")); 	
		Select SelectArrival = new Select(Arriving);
		SelectArrival.selectByVisibleText("Paris"); 
		
		//select prefered flight
		WebElement Airline = Driver.findElement(By.name("airline")); 	
		Select SelectAirline = new Select(Airline);
		SelectAirline.selectByVisibleText("Unified Airlines"); 
		
		//click on search flights
		Driver.findElement(By.name("findFlights")).click();   //input[@name='findFlights']
		Thread.sleep(2000);
		
		//selecting flight 
		Driver.findElement(By.xpath("//input[@value='Blue Skies Airlines$361$271$7:10']")).click();
		
		//clicking on reserve flights
		Driver.findElement(By.name("reserveFlights")).click();
		Thread.sleep(2000);
		
		//enter passenger names 
		Driver.findElement(By.name("passFirst0")).sendKeys("Mansoor");
		Driver.findElement(By.name("passLast0")).sendKeys("Alam");
		
		//enter credit card no
		Driver.findElement(By.name("creditnumber")).sendKeys("11111111111");
		
		//click on by tickets
		Driver.findElement(By.name("buyFlights")).click();
		Thread.sleep(2000);
		
		//getting the order no of flight confermation
		String Order_No = Driver.findElement(By.xpath("//font[contains(text(),'Confirmation')]")).getText();
		System.out.println("Order No= "+Order_No);
		
		//Order_No.equalsIgnoreCase(arg0);
		Driver.close();
		
				
		
   }
}