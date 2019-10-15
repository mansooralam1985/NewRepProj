package pack.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Utility {
	
	public void waitImplicitly(WebDriver driver,int intTimeinSeconds)
	{
		driver.manage().timeouts().implicitlyWait(intTimeinSeconds, TimeUnit.SECONDS);
	}
	
	
}
