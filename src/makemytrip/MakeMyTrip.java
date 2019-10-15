package makemytrip;

import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pack.selenium.PropertyFile;

import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

public class MakeMyTrip {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		//nevigate to make my trip -----------------------------------
		driver.navigate().to("https://www.makemytrip.com/bus-tickets");
		Thread.sleep(4000);
	
		//clicking on Bus link  ---------------------------------------
		//driver.findElement(By.xpath("//a[contains((text),'bus')]")).click();
		//Thread.sleep(2000);
		
		//enter source city name --------------------------------------   
		driver.findElement(By.id(PropertyFile.LoadFileData("MakeMyTripBus", "SourceCity"))).sendKeys(FunctionLibrary.ReadExcelData("Sheet1","SourceCity"));
		Thread.sleep(4000);
		
		//enter destination city --------------------------------------   
		driver.findElement(By.id(PropertyFile.LoadFileData("MakeMyTripBus", "DestinationCity"))).sendKeys(FunctionLibrary.ReadExcelData("Sheet1","DestinationCity"));
		Thread.sleep(5000);
		
		// pic date from date picker ----------------------------------  
		driver.findElement(By.id(PropertyFile.LoadFileData("MakeMyTripBus", "id_DatePicker"))).click();      

//		driver.findElement(By.linkText(PropertyFile.LoadFileData("MakeMyTripBus", "id_Date"))).click(); //click next monthid_NextMonth
	    driver.findElement(By.partialLinkText(PropertyFile.LoadFileData("MakeMyTripBus", "id_Date"))).click(); 
		Thread.sleep(1000);
		
		//click on search busses  --------------------------------------
		driver.findElement(By.xpath(PropertyFile.LoadFileData("MakeMyTripBus", "id_SearchButton"))).click(); 
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyFile.LoadFileData("MakeMyTripBus", "TravelTime"))));
		
		// select travel agency name -----------------------------------   
		driver.findElement(By.xpath(PropertyFile.LoadFileData("MakeMyTripBus", "TravelAggency"))).click(); 
		
		//select prefer travel time  and check travel time option is enable or disable -------------------------- 
		
		Boolean blnstatus = driver.findElement(By.xpath(PropertyFile.LoadFileData("MakeMyTripBus", "TravelTime"))).isEnabled();
		
		if(blnstatus=true ){
			driver.findElement(By.xpath(PropertyFile.LoadFileData("MakeMyTripBus", "TravelTime"))).click();
			System.out.println("clicked ");
		}
		
		//click on select button ------------------------------------------- 
		driver.findElement(By.id(PropertyFile.LoadFileData("MakeMyTripBus", "ClickSelect"))).click();
		System.out.println("Selected ");
		//Thread.sleep(10000);
		
		//seat selection --------------------------------------------------- 
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyFile.LoadFileData("MakeMyTripBus", "waitforSeatLoad"))));
		
		List<WebElement> busEmptySeatList=driver.findElements(By.xpath(PropertyFile.LoadFileData("MakeMyTripBus", "SeatSelection")));
		
		//Select any blank seat 
		if (busEmptySeatList.size()>0)
		{
			WebElement Seat=busEmptySeatList.get(busEmptySeatList.size()-1);
			
			Seat.click();
		}
		
		//click on book button after seat secection ---------------------------- 
        driver.findElement(By.id(PropertyFile.LoadFileData("MakeMyTripBus", "bookASeat"))).click();
      
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyFile.LoadFileData("MakeMyTripBus", "ContinueAsGuest"))));
        
        //Enter passenger first name --------------------------------------------
        driver.findElement(By.id(PropertyFile.LoadFileData("MakeMyTripBus", "PassengerFirstName"))).sendKeys(FunctionLibrary.ReadExcelData("Sheet1","FirstName"));
        //Enter passenger's last name -------------------------------------------
        driver.findElement(By.id(PropertyFile.LoadFileData("MakeMyTripBus", "PassengerLastName"))).sendKeys(FunctionLibrary.ReadExcelData("Sheet1","LastName"));
        //select Gender ---------------------------------------------------------
        driver.findElement(By.id(PropertyFile.LoadFileData("MakeMyTripBus", "SelectMale"))).click();
        
        //set age ---------------------------------------------------------------
        driver.findElement(By.id(PropertyFile.LoadFileData("MakeMyTripBus", "Age"))).sendKeys(FunctionLibrary.ReadExcelData("Sheet1","Age"));
        
        //enter Email as contact details ----------------------------------------
        driver.findElement(By.id(PropertyFile.LoadFileData("MakeMyTripBus", "UserId"))).sendKeys(FunctionLibrary.ReadExcelData("Sheet1","EmailId"));
        
        // enter contact no -----------------------------------------------------
        
        driver.findElement(By.id(PropertyFile.LoadFileData("MakeMyTripBus", "MobileNo"))).sendKeys(FunctionLibrary.ReadExcelData("Sheet1","MobNumber"));
        
        //click on continue as guest---------------------------------------------/
        driver.findElement(By.xpath(PropertyFile.LoadFileData("MakeMyTripBus", "LoginAsGuest"))).click();
        
        //verify ammount----------------------------------------------------------//span[@id="top_rail_totalAmount"]
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='top_rail_totalAmount']")));      
        // String Price = driver.findElement(By.xpath("//span[@id='top_rail_totalAmount']")).getText();
        System.out.println("Price");
        driver.close();
	}

}
