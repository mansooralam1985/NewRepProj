package com.WB.e2e;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class WEBFile {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

	File fsm = new File("C:\\Users\\iDeliver1\\Desktop\\Script.txt");
	
	FileInputStream fileInput = new FileInputStream(fsm);
	
	Properties prop = new Properties();
	
	//Load properties file
	
	try {
		
		prop.load(fileInput);
		//prop.getProperty();
	}  catch (IOException e) {
		e.printStackTrace();
	
	}

	}
	
	
	
	
}