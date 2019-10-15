package pack.selenium;

//import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GmailHardcoded {
	static WebDriver driver=null;
	
	
	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver","D:\\leanFT\\Selenium Project\\Drivers\\chromedriver.exe");
		//launch Firefox Driver
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	    WebDriverWait wait = new WebDriverWait(driver,60);
		//--------------------------
		//Navigate to Url :	
		driver.navigate().to("https://www.gmail.com");
				
		//enter user ID
		driver.findElement(By.id("identifierId")).sendKeys("mansoor@ideliver-inc.com");
		
		//click on next
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		Thread.sleep(2000);
		
		//enter user Password
		driver.findElement(By.name("password")).sendKeys("786450am");
		
		// click on Next for Sign In
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		Thread.sleep(10000);	
		
	   //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
		
		//boolean bool = driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).isDisplayed();
		
		//Assert.assertTrue(bool, "Compose not displayed");
		
		//compose mail
		driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();
		Thread.sleep(3000);
	  
		//Click on Subject line
		//driver.findElement(By.xpath("//div[@class='oL aDm']")).click();
		
		//click on Searchbox
		//driver.findElement(By.xpath("//input[@placeholder='Search mail']")).sendKeys("Nilesh");
		//Thread.sleep(2000);
		
		//enter to 
		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("mansoor@ideliver-inc.com");
		Thread.sleep(2000);
		
		//Enter Subject
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Selenium Testing");
		Thread.sleep(2000);
		
		//clicking on Message body
		driver.findElement(By.xpath("//div[contains(@aria-label,'Message') and @role='textbox']")).click();
		Thread.sleep(2000);
		
		//controlling home key into top of the body of mail
		driver.findElement(By.xpath("//div[contains(@aria-label,'Message') and @role='textbox']")).sendKeys(Keys.CONTROL,Keys.HOME);
		Thread.sleep(1000);
		
		//write some thing in mail body
		driver.findElement(By.xpath("//div[contains(@aria-label,'Message') and @role='textbox']")).sendKeys("Hi, Selenium");
		Thread.sleep(1000);

		// attaching file in mail attachment
		try {
			Runtime.getRuntime().exec("C:\\Users\\hp\\Desktop\\UploadFile.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Thread.sleep(9000);
		//clicking on send button
		//*[contains(text(),'Saved')]
		
		
	   
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Saved')]")));
	     	try {
	     		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Send')]")).isEnabled());
	        	WebElement ele=	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Send')]")));
	     		ele.click();
	     		//driver.findElement(By.xpath("//div[contains(text(),'Send')]")).click();
				System.out.println("Send  clicked");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
					
				System.out.println(" Send button not clicked");					
			}
	     	
/*				
		//Step :------Click on Close Draft if message not send ----------- 
//		driver.findElement(By.xpath("//img[@alt='Close']")).click();

//		//Step :------Click on Draft Link----------
		driver.findElement(By.xpath("//a[contains(text(),'Drafts')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@gh='tm']/descendant::div[@role='presentation']")).click();
		Thread.sleep(2000);

		//Step------------Discard Drafts----
		driver.findElement(By.xpath("//div[contains(text(),'Discard drafts')]")).click();
		Thread.sleep(2000);
*/
		//Step :------Click on user account button-------gb_ab gbii
		driver.findElement(By.xpath("//a[@class='gb_b gb_fb gb_R' and @role='button']")).click();

		//Step :------Click on "Sign out" button-------	
		driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
		System.out.println("Sign out Success");	
//		long startTime = 0;
//		final long endTime = System.nanoTime();	
//		System.out.println((endTime-startTime)/1000000000+" seconds");
		driver.quit();
		//Close Browser  
    	
	}
	

}
