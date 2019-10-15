package pack.selenium;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GmailReusableMethods implements InterfaceGmailProcess {

	
	WebDriver driver;
	Utility wait = new Utility();
	
	GmailReusableMethods(WebDriver driver)
	{
		this.driver=driver;
	}
		
	
	@Override
	@BeforeMethod
	public void fnLogin(String strEmail, String strPassword) {
		// TODO Auto-generated method stub
		//Navigate to Url :	
	
		//enter user ID
		driver.findElement(By.id("identifierId")).sendKeys(strEmail);
		
		//click on next
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		
		wait.waitImplicitly(driver,20);
		//enter user Password
		driver.findElement(By.name("password")).sendKeys(strPassword);
		
		//click on SignIn
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();	
	}

	// compose mail
	public void fnCompose() {
		// TODO Auto-generated method stub
		
		boolean str = driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).isDisplayed();
		Assert.assertTrue(str, "Compose not displayed");
		//Assert.assertEquals(str, true);
		
		//compose mail   
		driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
		wait.waitImplicitly(driver,20);	
		
	}
	
	//addTo
	@Test
	public void fnAddTo(String strTo)
	{
		//enter to 
		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys(strTo+";");	
		wait.waitImplicitly(driver,20);	
	}
	
	@Test
	public void fnAddCC(String strCC) {
		// TODO Auto-generated method stub
		if( driver.findElement(By.xpath("//span[contains(@aria-label,'Add cc') and @role='link']")).isDisplayed())
		{
		    driver.findElement(By.xpath("//span[contains(@aria-label,'Add cc') and @role='link']")).click();
		}
		else 
			{driver.findElement(By.xpath("//textarea[@name='cc']")).click();	
		
			}
		
		    driver.findElement(By.xpath("//textarea[@name='bcc']")).sendKeys(strCC+";");
			//Thread.sleep(10);
		
	}
	
	@Test
	public void fnAddBcc(String strBcc) {
	
	   if( driver.findElement(By.xpath("//span[contains(@aria-label,'Add Bcc') and @role='link']")).isDisplayed())
		{
		    driver.findElement(By.xpath("//span[contains(@aria-label,'Add Bcc') and @role='link']")).click();
		}
	   else 
	    {   
		   driver.findElement(By.xpath("//textarea[@name='bcc']")).click();
	    }
		//Thread.sleep(10);
		driver.findElement(By.xpath("//textarea[@name='bcc']")).sendKeys(strBcc+";");
		//Thread.sleep(10);
	}

	@Test
	public void fnAddSubject(String strSubject) {
		//Enter Subject
		
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys(strSubject);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	//@Override
	@Test//
	public void fnBodyContent(String strBodyContent) {
					
				//clicking on Message body
				driver.findElement(By.xpath("//div[contains(@aria-label,'Message') and @role='textbox']")).click();
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//controlling home key into top of the body of mail
				driver.findElement(By.xpath("//div[contains(@aria-label,'Message') and @role='textbox']")).click();
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//controlling home key
				driver.findElement(By.xpath("//div[contains(@aria-label,'Message') and @role='textbox']")).sendKeys(Keys.CONTROL,Keys.HOME);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//write some thing in mail body
				//write some thing in mail body
				driver.findElement(By.xpath("//div[contains(@aria-label,'Message') and @role='textbox']")).sendKeys("Hi, Selenium");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
	}
	
	@Override
	@Test
	public void fnSendMail() {
		driver.findElement(By.xpath("//div[contains(text(),'Send')]")).click();
	}

	// Logout
	@Override
	@AfterTest
	public void fnLogout() {
		// TODO Auto-generated method stub
		//Click on Logout
		driver.findElement(By.xpath("//a[@class='gb_b gb_fb gb_R' and @role='button']")).click();
		wait.waitImplicitly(driver,20);
		driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
		wait.waitImplicitly(driver,20);
		
	}

}
