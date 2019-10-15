package com.WB.e2e;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Webfile11 {
	
 
public void Login() throws IOException 
{
File fsm = new File("C:\\Users\\iDeliver1\\Desktop\\webtour.properties.txt");
	
	FileInputStream fileInput = new FileInputStream(fsm);
	
	Properties prop = new Properties();
	
	//Load properties file
	
		
		prop.load(fileInput);
		prop.getProperty("id_username");


}
}
