package pack.selenium;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopupHandle {

	public static WebDriver  driver;
	
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		driver=Driver.getDriver("firefox");
		driver.manage().window().maximize();
		
		driver.get("https://www.irctc.co.in");
		
		
		//Thread.sleep(40000);
	    //driver.findElement(By.xpath("//a[contains(text(),'Enable')]")).click();
		//getting the parent browser property
		//Set <String> ParentBrowser= driver.getWindowHandles();
		
		 int loopcount=0;
		//a[contains(text(),'Not Now')]
		while(loopcount<30)
		{
			try{
				
			
			Alert alt = driver.switchTo().alert();
			
			//accept or cancel popup
			//alt.dismiss();
			alt.accept();
			break;
			}
		
		catch(NoSuchElementException ex)
		{
		  loopcount = loopcount+1;
		 Thread.sleep(1000);	
		}
		
		}

	}		 
		
}	



	
