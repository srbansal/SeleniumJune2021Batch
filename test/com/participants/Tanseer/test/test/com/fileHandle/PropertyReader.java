package com.fileHandle;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class PropertyReader {
    public static String getProperty(String str) {
    	try {
		FileReader reader =new FileReader("file/info.properties");
		Properties p=new Properties();
		p.load(reader);
		return p.getProperty(str);
    	}
    	catch(Exception e) {
    		System.out.println(e);   	}
		return str;
   
    }	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
