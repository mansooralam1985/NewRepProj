package com.pack.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	static Properties pObj;	
	public static String LoadFileData(String ORname,String Key){
		
		 FileInputStream objFile = null;
			pObj= new Properties();
		    String filepath = System.getProperty("user.dir")+"/src/objectRepository/"+ORname+".properties";	
		    try {
				objFile = new FileInputStream(filepath);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("File Not found");
			}
		    // load file 
		    try {
				pObj.load(objFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Unable to load file");
			}
		    return pObj.getProperty(Key);
	}
}
