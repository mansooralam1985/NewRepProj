package pack.selenium;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class CrossBrowser {
	static  WebDriver driver;
	
	@Test
	//@Parameters("Chrome")

		
	public void DataRead() throws Throwable
	{  
   driver=Driver.getDriver("firefox");
   driver.manage().window().maximize();
	//System.setProperty("webdriver.geco.driver","D:\\leanFT\\Selenium Project\\Drivers\\geckodriver.exe");	
	//System.setProperty("webdriver.ie.driver","D:\\leanFT\\Selenium Project\\Drivers\\IEDriverServer.exe");
	//System.setProperty("webdriver.chrome.driver","D:\\leanFT\\Selenium Project\\Drivers\\chromedriver.exe");
	//launch Firefox Driver
	//driver = new FirefoxDriver();
	//driver = new InternetExplorerDriver();
	//driver = new ChromeDriver();
    //WebDriverWait wait = new WebDriverWait(driver,30);
   
	//------------------------------------------------------------------------------
	//Navigate to Url :	
	driver.navigate().to("https://www.rockwellautomation.com");
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".fa.fa-user")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
	Thread.sleep(2000);
	//driver.findElement(By.xpath("//input[name='userName' and type='text' ]")).sendKeys("monoj@ideliver-inc.com");
	
	driver.findElement(By.name("userName")).sendKeys("mansoor@ideliver-inc.com");
	Thread.sleep(2000);
	driver.findElement(By.name("password")).sendKeys("786450am");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@href='javascript:document.User.submit()' and contains(text(),'Sign In')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".fa.fa-user")).click();
	Thread.sleep(2000);
	List<WebElement> lst = driver.findElements(By.xpath(".//*[@id='account-site']/div[3]/a"));
	for(WebElement we: lst)
	{
	we.click(); 
	}
	driver.close();
	//driver.quit();	
	}
	
}
