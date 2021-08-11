package Utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
 * Challenge
In selenium project, create a new class PropertyReader
include a static method to get value of a property e.g. getProperty()

PropertyReader.getProperty(baseUrl)
etc...

Use these properties in the Selenium Script

*/
public class PropertyReader {

	public static String getProperty(String key) throws IOException
	{
		FileReader reader = new FileReader("files/info.properties");
		Properties p = new Properties();
		p.load(reader);
		
		return p.getProperty(key);
	}
	
	public static void main(String[] args) throws IOException {
//		FileReader reader = new FileReader("files/info.properties");
//		
//		Properties p = new Properties();
//		p.load(reader);
//		
//		System.out.println(p.getProperty("url"));
//		System.out.println(p.getProperty("browser"));
//		System.out.println(p.getProperty("email"));
//		System.out.println(p.getProperty("password"));
		
	}

}
