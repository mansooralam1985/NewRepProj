package dataprovider_11oct;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class DataproviderExcel {
	
	String xlFilepath = "C:\\Users\\iDeliver1\\Desktop\\Book1_ERp.xlsx";
	String SheetName = "Credentials";
	ExcelApiTest eat = null;
	
	
	
  public void fillUserForm(String userName, String passWord, String dateCreated, String noofAttempts, String Result) 
  
  {
	  
	 System.out.println("userName: "+ userName); 
	 System.out.println("passWord: "+ passWord);
	 System.out.println("dateCreated: "+ dateCreated);
	 System.out.println("noofAttempts: "+ noofAttempts);
	 System.out.println("Result: "+ Result);
	 
  }
  
  
  @DataProvider(name="userData")
  public Object[][] userFormData()
		  
		  {
	        Object[][] data = testData(xlFilepath, SheetName);
		  }
  
  public Object[][] testData(String xlFilepath, String SheetName)
  
  {
	  
	  
  }
  
}
