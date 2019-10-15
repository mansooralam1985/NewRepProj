package pack.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {

	public static WebDriver  driver;
	
	public static WebDriver getDriver(String strBrowser)
	{
			
		String path = System.getProperty("user.dir")+"\\Drivers/";	
		path=path.replace('\\', '/');
		
		
		switch(strBrowser.toLowerCase())
		{
			
		case "firefox":
			driver=new FirefoxDriver();
			break;
			
		case "chrome":	
			System.setProperty("webdriver.chrome.driver", path+"chromedriver.exe");
			driver=new ChromeDriver();	
			break;
			
		case "ie":	
		
		System.setProperty("webdriver.ie.driver", path+"IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		break;
		
		default:
		     driver=null;
		}
		
		
		return driver;
		
		
	}
	
}
