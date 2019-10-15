package mainscript;

import java.io.File;

import org.eclipse.jetty.server.Response.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

 

import webtour.Enterpassengerdetal;
import webtour.Findflight;
import webtour.Fromcity;
import webtour.LaunchApplication;
import webtour.Login1;

//import com.beust.jcommander.Parameters;

public class script {
	
	WebDriver driver = new FirefoxDriver();
	
 @Test(priority=0)
 @Parameters("URL")
 public void LaunchApplicationModule(String URL)
	{
	 
	 LaunchApplication launch = new LaunchApplication(driver);
	 launch.LaunchApplication1(URL);
	}
	
  @Test(priority=1)
  @Parameters({"Username","Password"})
  public void LoginModule(String Username, String Password) throws Throwable
  {
	 Login1 login1 = new Login1(driver);
	 login1.Login(Username, Password);
	
  }
  
  @Test(priority=2)
  @Parameters({"count","fromport","frommonth","toport"})
  public void FromcityModule(String count, String fromport, String frommonth, String toport) throws Throwable
  {
	
	Fromcity from = new Fromcity(driver);
	from.Fromcity1(count, fromport, frommonth, toport);
	  
  }
  
  @Test(priority=3)
  @Parameters("flightp")
  public void FindflightModule(String flightp) throws Throwable
  
  {
	
	  Findflight flight = new Findflight(driver);
	  flight.Findflight1(flightp);
  }
  
  @Test(priority=4)
  @Parameters({"firstnam","lastname","creditno"})
  public void EnterpassengerdetalModule(String firstnam, String lastname, String creditno ) throws Throwable
  
  {
	  Enterpassengerdetal passenger = new Enterpassengerdetal(driver);
	  passenger.Enterpassengerdetal1(firstnam, lastname, creditno);		
  }
  
	}

