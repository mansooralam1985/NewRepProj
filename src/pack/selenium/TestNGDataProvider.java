package pack.selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGDataProvider {
	
	WebDriver driver;             //initialise the driver
	GmailReusableMethods obj ;			// initialise object of another class
	
	
	@Parameters({"BrowserName"})
	@BeforeSuite
	public void LaunchBrowserTest(String BrowserName)
	{
		this.driver=Driver.getDriver(BrowserName);
		this.obj = new GmailReusableMethods(driver);
		System.out.println(BrowserName);
	}
	
	@Parameters({"strUrl"})
	@BeforeTest
	public void Url(String strUrl)
	{
		driver.navigate().to(strUrl);
		System.out.println(strUrl);
	}
	
	@Parameters({"username","password"})
	@BeforeClass
	public void Login(String username,String Password)
	{
		obj.fnLogin(username, Password);
	}
	
	@Test(dataProvider ="providerName")
	public void TestMethod1(String strTo,String strCC, String strBcc,String strSubject,String strBodyContent) throws InterruptedException
	{
		
		obj.fnCompose();
		System.out.println("Clicked on Composed");
		obj.fnAddTo(strTo);
		System.out.println("compose to : "+strTo);
		Thread.sleep(2000);
		//obj.fnAddCC(strCC);
		//System.out.println("Cc : "+strCC);
		//obj.fnAddBcc(strBcc);
		//System.out.println("Bcc : "+strBcc);
		obj.fnAddSubject(strSubject);
		System.out.println("Subject Line : "+strSubject);
		obj.fnBodyContent(strBodyContent);
		System.out.println("Mail Body : "+strBodyContent);
		obj.fnSendMail();
		System.out.println("send success full");
		obj.fnLogout();
		System.out.println("Logout successfull");
		driver.close();
	}
	
	@DataProvider(name="providerName")
	public Object[][] getData()
	{
		Object[][] data = new Object[1][5];
		
		// 1st row
		data[0][0] = "mansoor@ideliver-inc.com";
		data[0][1] = "dilip@ideliver-inc.com";
		data[0][2] = "sourabhc@ideliver-inc.com";
		data[0][3] = "Selenium";
		data[0][4] = "selenium TestNG ";
				
//		// 2nd row
//		data[1][0] = "sourabh@ideliver-inc.com";
//		data[1][1] = "vikas@ideliver-inc.com";
//		data[1][2] = "sourabhc@ideliver-inc.com";
//		data[1][3] = "Selenium";
//		data[1][4] = "selenium TestNG ";
		
		return data;
		
	}
	
	
}
