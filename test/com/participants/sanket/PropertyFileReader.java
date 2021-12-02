package com.participants.sanket;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	public static String getProperties(String key) throws IOException{
		FileReader read = new FileReader("files/test.properties");
        Properties prop = new Properties();
        prop.load(read);
        return prop.getProperty(key);
	}
}
