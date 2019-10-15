package pack.selenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Rokwell {

	
public static void main(String[] args) {
		
		//launch Firefox Driver
				WebDriver driver = new FirefoxDriver();
				
				//Navigate to Url :	
				driver.navigate().to("https:\\www.gmail.com");
		
		
	}

}
