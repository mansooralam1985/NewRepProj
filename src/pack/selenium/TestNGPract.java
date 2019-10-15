package pack.selenium;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class TestNGPract {
	
	public WebDriver driver = new FirefoxDriver();
	
  @Test
  public void LoginApp() {
	//Nevigate to Url :	
	driver.navigate().to("http://newtours.demoaut.com/");  
	
	//verification on page
	 
	
	//synchronization-page sync
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 
	//enter username
	driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("jhon");
			
	//enter user password
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mercury");
		
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	//click on login
	driver.findElement(By.xpath("//input[@name='login']")).click();
  
  }
	@Test(priority=0)
	public void Passenger() throws InterruptedException{

		//Select total no of passenger
		WebElement element = driver.findElement(By.name("passCount")); //select[@name='passCount']
		Select SelPass = new Select(element);
		SelPass.selectByVisibleText("2");
		Thread.sleep(2000);
		
		// Select Source station from dropdown
		WebElement element_fromPort = driver.findElement(By.name("fromPort")); 	
		Select SelectFrom = new Select(element_fromPort);
		SelectFrom.selectByVisibleText("London");
		Thread.sleep(2000);
		
		// select month from dropdown		
		WebElement month = driver.findElement(By.name("fromMonth")); 	
		Select SelectMonth = new Select(month);
		SelectMonth.selectByVisibleText("April");
		Thread.sleep(2000);
		
		//select date from dropdown
		WebElement Date = driver.findElement(By.name("fromDay")); 	
		Select SelectDate = new Select(Date);
		SelectDate.selectByVisibleText("20");
		Thread.sleep(2000); 
		
		//select destination place
		WebElement Arriving = driver.findElement(By.name("toPort")); 	
		Select SelectArrival = new Select(Arriving);
		SelectArrival.selectByVisibleText("Paris"); 
	}
		@Test(priority=1)
		public void Flight() throws InterruptedException{
		
			//select prefered flight
			WebElement Airline = driver.findElement(By.name("airline")); 	
			Select SelectAirline = new Select(Airline);
			SelectAirline.selectByVisibleText("Unified Airlines"); 
			
			//click on search flights
			driver.findElement(By.name("findFlights")).click();   //input[@name='findFlights']
			Thread.sleep(2000);
			
			//selecting flight 
			driver.findElement(By.xpath("//input[@value='Blue Skies Airlines$361$271$7:10']")).click();
			
			//clicking on reserve flights
			driver.findElement(By.name("reserveFlights")).click();	
			
			driver.close();
			
		}
		
		
	}


