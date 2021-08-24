package com.participants.sakshi;

import java.io.FileReader;
import java.util.Properties;

public class PropertyReader {
	static String getProperties(String s) throws Exception {
		FileReader reader = new FileReader("file/info.properties");
		Properties p = new Properties();
		p.load(reader);
		return(p.getProperty(s));
	}
}