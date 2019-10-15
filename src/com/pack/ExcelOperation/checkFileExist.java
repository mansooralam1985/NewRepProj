package com.pack.ExcelOperation;

import java.io.File;

public class checkFileExist {
	
	public static void main(String[] args) throws Throwable {
	 File f = null;
     boolean bool = false;
	
	f = new File("D:\\selenium.txt");
	bool = f.exists();
	System.out.println("file exist "+ bool);
	
	if (bool == false){
		bool = f.createNewFile();
		System.out.println("file created  "+ bool);
	}
	
	/*if(bool == true){
		bool = f.delete();
		System.out.println("file deleted  "+ bool);

	}*/
	
	bool = f.exists();
	System.out.println("file exist "+ bool);

	}	
}
