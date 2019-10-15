package pack.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Xml {
	String strUrl;
	WebDriver driver = new FirefoxDriver();  
	GmailReusableMethods runGmail=new GmailReusableMethods(driver);
	
	
	@Test
	@Parameters ({"strUrl","strEmail","strPassword"})
	public void LaunchBrowser(String strUrl,String strEmail, String strPassword )
	{     
	driver.navigate().to(strUrl);	
	System.out.println("BrowserLaunched By Url : "+strUrl);
	runGmail.fnLogin(strEmail, strPassword);
	System.out.println("Login Success : "+strUrl+" , "+strEmail + " , "+strPassword);

	}
	

	@Parameters({"strTo","strCC","strSubject","strBodyContent"})
	@Test//(description="compose mail",dependsOnGroups"")
	//compose mail
	public void ComposeMail(String strTo,String strSubject,String strBodyContent){
		
		//runGmail.fnComposeMail( strTo, strSubject, strBodyContent);
		
		
	}
	
	@AfterClass
	public void Logout(){
		
		runGmail.fnLogout();	
		System.out.println("Logout Passed");
		
	}
	
	
	
}




//WebDriver driver = new FirefoxDriver();      
//driver.navigate().to("https://www.gmail.com");