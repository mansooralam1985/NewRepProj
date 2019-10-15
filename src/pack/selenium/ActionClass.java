package pack.selenium;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;

public class ActionClass {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Actions act = new Actions(driver);
		
		//perform drag and drop
		//
//		System.out.println(System.getProperty("user.dir"));
//	//	D:\leanFT\Selenium Project\Drivers\chromedriver.exe
//			
	 driver=Driver.getDriver("firefox");
	 driver.manage().window().maximize();	 
	 driver.get("http://www.gmail.com/");
	 driver.quit();
		
	
		
		
		//String path = System.getProperty("user.dir");
		//System.out.println(path.replace('\\', '/'));
		
	
	}

}
