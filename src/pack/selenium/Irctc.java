package pack.selenium;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Irctc {

	public static WebDriver driver;
	private static java.util.Scanner sc;
	static Alert alt;
	static String TicketType = "I-ticket";
	public static void main(String[] args) throws Exception {
		
		// login to IRCTC
		driver = Driver.getDriver("CHROME");     
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in");
		Thread.sleep(2000);
		driver.findElement(By.id("usernameId")).sendKeys("S4sourabh");
		driver.findElement(By.name("j_password")).sendKeys("9973773309");
		 
		sc = new java.util.Scanner(System.in);
		System.out.println("Enter the captca : ");
		String vcapta = sc.next();
		
		driver.findElement(By.id("nlpAnswer")).sendKeys(vcapta);
		Thread.sleep(2000);
	    driver.findElement(By.id("loginbutton")).click();
	    Thread.sleep(5000);
	    System.out.println("Login Success");
	    
	    //Search Train
	    
	    driver.findElement(By.id("jpform:fromStation")).sendKeys("BILASPUR JN - BSP");
	    driver.findElement(By.id("jpform:toStation")).sendKeys("NEW DELHI - NDLS");
	    driver.findElement(By.id("jpform:journeyDateInputDate")).sendKeys("18-11-2017");
	    
	    // geting available option in weblist
	    WebElement ele = driver.findElement(By.xpath("//select[@id='jpform:ticketType']"));
	    Select cell = new Select(ele);
	     cell.selectByVisibleText(TicketType);
       // String Ticket = ele.getText();
	     
	   boolean bool = TicketType.equalsIgnoreCase("I-ticket");
	    if (bool == true)
	    {
	    	try
		    	{
				 driver.switchTo().alert(); 
				 Thread.sleep(1000);
				 alt.accept();
				 driver.findElement(By.id("jpform:jpsubmit")).click();
		    	}
			
			catch(NoSuchElementException ex)
				{
					ex.getMessage();
				}	
		}
		 else
		 {
		    driver.findElement(By.id("jpform:jpsubmit")).click();
	     }
	    System.out.println("Search Success");  
	    
    }
}
