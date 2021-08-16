package com.participants.vaibhav;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileHandling {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader reader = new FileReader("file/info.properties");
		Properties p = new Properties();
		p.load(reader);
		
		WebDriver driver;
		System.setProperty(p.getProperty("cKey"), p.getProperty("cValue"));
		driver = new ChromeDriver();
		
		driver.get(p.getProperty("baseURL"));
		
	}

}
