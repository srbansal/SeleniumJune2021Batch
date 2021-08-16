package com.participants.vaibhav;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	static String getProperties(String s) throws IOException {
		FileReader reader = new FileReader("test/resorces/my.properties");
		Properties p = new Properties();
		p.load(reader);
		return (p.getProperty(s));
	}
}
