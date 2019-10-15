package pack.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class checkBoxSelection {
 
	public static void main(String[] args) {
													 
	//System.setProperty("webdriver.chrome.driver", "D:\\leanFT\\Selenium Project\\Drivers\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "D:\\MM1\\Chrome\\Application\\chrome.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.smartwebby.com/PHP/Phptips2.asp");
		
		List<WebElement> lst = driver.findElements(By.xpath("//input[@type='checkbox']"));
	
	   int vNoOfCheckBox = lst.size();
		System.out.println(vNoOfCheckBox);
		try{
			 
		for(int i=0;i<lst.size();i++)
		{
			WebElement el = lst.get(i);
			String  name =el.getAttribute("value");
						
			Boolean blnStatus = el.isSelected();
			
			if(blnStatus==false){
				el.click();     // it will select unselected checkbox
			}
			else
			{
				el.click();     // it will Un-select selected checkbox
			}
			
		}
		}     
		catch(Exception e){
			e.getMessage();
		}
		
		driver.close();
	
	}

}
