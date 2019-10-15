package webtour;

import org.openqa.selenium.WebDriver;

public class LaunchApplication {
	
	WebDriver driver;
	public LaunchApplication(WebDriver driver)
	
	{
		this.driver = driver;
	}
	
	public void LaunchApplication1(String URL)
	
	{
		
		driver.navigate().to(URL);
		 
	}
	
	
}
