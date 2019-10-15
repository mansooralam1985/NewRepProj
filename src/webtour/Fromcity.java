package webtour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Fromcity {
	
	WebDriver driver;
	public  Fromcity(WebDriver driver)
	
	{
		this.driver = driver;
	}
	
	public void Fromcity1(String count,String fromport, String frommonth, String toport) throws InterruptedException
	
	{
		
		//Select total no of passenger
				WebElement element = driver.findElement(By.name("passCount")); //select[@name='passCount']
				Select SelPass = new Select(element);
				SelPass.selectByVisibleText(count);
				Thread.sleep(2000);
				
				// Select Source station from dropdown
				WebElement element_fromPort = driver.findElement(By.name("fromPort")); 	
				Select SelectFrom = new Select(element_fromPort);
				SelectFrom.selectByVisibleText(fromport);
				Thread.sleep(2000);
				
				// select month from dropdown		
				WebElement month = driver.findElement(By.name("fromMonth")); 	
				Select SelectMonth = new Select(month);
				SelectMonth.selectByVisibleText(frommonth);
				Thread.sleep(2000);
				
				//select date from dropdown
				WebElement Date = driver.findElement(By.name("fromDay")); 	
				Select SelectDate = new Select(Date);
				SelectDate.selectByVisibleText("20");
				Thread.sleep(2000); 
				
				//select destination place
				WebElement Arriving = driver.findElement(By.name("toPort")); 	
				Select SelectArrival = new Select(Arriving);
				SelectArrival.selectByVisibleText(toport); 
	}

}
