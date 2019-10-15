// calling all method from in one place and run project for all scnario


package pack.selenium;
import com.pack.generic.UtilityLib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pack.generic.UtilityLib;

public class RunGmail{

	static	WebDriver  driver;
	
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		 
		 driver=Driver.getDriver("firefox");
		 driver.manage().window().maximize();	
		 		 
		 GmailReusableMethods runGmail=new GmailReusableMethods(driver);
		 
	//Launch URL 
		 driver.get("http://www.gmail.com/");
		 
	//login
		 runGmail.fnLogin("mansoor@ideliver-inc.com", "iDeliver22"); 
		 
	//compose mail 
		// runGmail.fnComposeMail("sourabh@ideliver-inc.com");	 
		 
		 Thread.sleep(5000);		 
		 	 
	//cc
		// runGmail.fnAddCC("sourabh@ideliver-inc.com");
		 Thread.sleep(5000);	
	//bcc	 
		// runGmail.fnAddBcc("sourabh@ideliver-inc.com" );
		 Thread.sleep(5000);	
	//logout 
		 runGmail.fnLogout();
		 
		 driver.quit();
		 
		 			
		
	}

}
