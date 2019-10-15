package pack.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class PropertyFile {

	
	static Properties pObj;	
	
	
	//GmailAttributes
public static String LoadFileData(String ORname,String Key){
					
	 FileInputStream objFile = null;
		pObj= new Properties();
	    String filepath = System.getProperty("user.dir")+"/src/objectRepository/"+ORname+".properties";	
	    try {
			objFile = new FileInputStream(filepath);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File Not found");
		}
	    // load file 
	    try {
			pObj.load(objFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Unable to load file");
		}
	    return pObj.getProperty(Key);
}
		
public static void main(String[] args) throws InterruptedException {
	
	
	    //launch Firefox Driver
	    WebDriver driver = new FirefoxDriver();
		//WebDriverWait wait = new WebDriverWait(driver,30);
		
		//Navigate to Url :	
		driver.navigate().to("https://www.gmail.com");
		//enter user ID id_username

		driver.findElement(By.id(PropertyFile.LoadFileData("GmailAttributes", "id_Email"))).sendKeys(PropertyFile.LoadFileData("GmailAttributes", "id_username"));
				
		//click on next
		driver.findElement(By.id(PropertyFile.LoadFileData("GmailAttributes", "id_Next").trim())).click();
		Thread.sleep(2000);
				
		//enter user Password
	    driver.findElement(By.id(PropertyFile.LoadFileData("GmailAttributes", "id_Password"))).sendKeys("iDeliver22");
				
		//click on SignIn
		driver.findElement(By.id(PropertyFile.LoadFileData("GmailAttributes", "id_SignIn"))).click();
		Thread.sleep(3000);	
		
		//click on compose
		driver.findElement(By.xpath(PropertyFile.LoadFileData("GmailAttributes","xpath_Compose"))).click();
		Thread.sleep(3000);
		System.out.println("clicked");
		
		//enter Send To
		driver.findElement(By.xpath(PropertyFile.LoadFileData("GmailAttributes","xpath_To"))).sendKeys("sourabh@ideliver-inc.com;");
		Thread.sleep(1000);
		
		//enter Cc
		driver.findElement(By.xpath(PropertyFile.LoadFileData("GmailAttributes","xpath_CCLink"))).click();
     	Thread.sleep(1000);
     	driver.findElement(By.xpath(PropertyFile.LoadFileData("GmailAttributes","xpath_Cc"))).sendKeys("sourabh@ideliver-inc.com;");
     	//Thread.sleep(10);
     	
     	//Add Bcc
     	driver.findElement(By.xpath(PropertyFile.LoadFileData("GmailAttributes","xpath_BccLink"))).click();
     	//Thread.sleep(10);
     	driver.findElement(By.xpath(PropertyFile.LoadFileData("GmailAttributes","xpath_Bcc"))).sendKeys("sourabh@ideliver-inc.com;");
     	//Thread.sleep(10);
     	
		//Enter Subject
		driver.findElement(By.xpath(PropertyFile.LoadFileData("GmailAttributes","xpath_Subject"))).sendKeys("Selenium Testing");
		Thread.sleep(1000);
		
		//clicking on Message body
		driver.findElement(By.xpath(PropertyFile.LoadFileData("GmailAttributes","xpath_Message"))).click();
		Thread.sleep(1000);
				
		//controlling home key into top of the body of mail
		driver.findElement(By.xpath(PropertyFile.LoadFileData("GmailAttributes","xpath_Message"))).sendKeys(Keys.CONTROL,Keys.HOME);
		Thread.sleep(1000);
				
		//write some thing in mail body
		driver.findElement(By.xpath(PropertyFile.LoadFileData("GmailAttributes","xpath_Message"))).sendKeys("Hi, Selenium");
		Thread.sleep(1000);		
		
		driver.findElement(By.xpath(PropertyFile.LoadFileData("GmailAttributes","xpath_attachment"))).click();
		Thread.sleep(2000);	
		
		try {
			Runtime.getRuntime().exec(PropertyFile.LoadFileData("GmailAttributes","attachment"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(10000);
		//send
		driver.findElement(By.xpath(PropertyFile.LoadFileData("GmailAttributes","xpath_Send"))).click();
		Thread.sleep(2000);
		
		//Click on Logout
		driver.findElement(By.xpath(PropertyFile.LoadFileData("GmailAttributes","id_logout"))).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath(PropertyFile.LoadFileData("GmailAttributes","id_Signout"))).click();
		
		//Close Browser  
		driver.close();
		
		
	}

}
