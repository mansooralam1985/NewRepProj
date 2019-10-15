package pack.selenium;

//import org.openqa.selenium.WebDriver;

public interface InterfaceGmailProcess {
	
	//login method
	public void fnLogin(String strEmail,String strPassword);
	
	//public void fnComposeMail(String strTo);
	//Compose Mail
	//public void fnComposeMail(String strTo,String strSubject,String strBodyContent);
	
	//Compose mail with Cc
	//public void fnComposeMail(String strTo,String strCC,String strSubject,String strBodyContent);
	
	//Compose mail with Bcc
	//public void fnComposeMail(String strTo,String strCC,String strBcc,String strSubject,String strBodyContent);
	
	//Click Send
	//public void fnSendMail1();
	
	//Logout
	public void fnLogout();

	void fnSendMail();
	
}
