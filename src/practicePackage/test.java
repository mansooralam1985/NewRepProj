package practicePackage;

import com.pack.generic.ReadPropertyFile;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		System.out.println("hello");
   
		//How to call property file
		
		String Str = ReadPropertyFile.LoadFileData("GmailAttributes", "id_username");
        System.out.println(Str);
	}
	
	

}
