package com.participants.sanket;

import org.testng.annotations.Test;

import utilities.PropertyFileReader;

import org.testng.annotations.BeforeClass;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;


import org.apache.log4j.Logger;


public class YahooDemo {
	
//	  initialize logger
	  static Logger log = Logger.getLogger(YahooDemo.class);

	  WebDriver driver;
	  String baseUrl=null;
	 
	  @Test
	  public void f() throws Exception{
		    Properties prop = new Properties();
			FileReader read = new FileReader("C:\\Users\\91758\\eclipse-workspace\\GroupAssignment\\test\\configuration\\application.properties");
	        prop.load(read);
//	        using logger info
	        log.info("Properties file is loaded"); 
	        
	        String getusername = prop.getProperty("username");
	        String getPassword = prop.getProperty("password");
	        String yahooName = prop.getProperty("yahoo");
			
			WebElement username = driver.findElement(By.name("username"));
			username.sendKeys(getusername);
			
			log.info("Username given  as "+getusername); 
			
			WebElement btnSubmit = driver.findElement(By.name("signin"));
			btnSubmit.click();
			log.info("Clicked on Signin button"); 
			
			Thread.sleep(2000);
			
			WebElement password = driver.findElement(By.id("login-passwd"));
			password.sendKeys(getPassword);
			log.info("Password Given"); 
			
			WebElement btnSubmitP = driver.findElement(By.name("verifyPassword"));
			btnSubmitP.click();
			log.info("Clicked on login button after giving password"); 

			Thread.sleep(2000);
			
			String checkName = driver.getTitle();
            
			if(checkName.contains(getusername) || checkName.contains(yahooName)){
				System.out.println("Logged In Succesfully");
				log.info("Log in Successful");
			}else {
				System.out.println("Not able Log In");
				log.warn("Not able to login, Something went wrong");
			}
		  
	  }
	  	  
	  @BeforeClass
	  public void beforeClass() throws Exception{
		  System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		  driver = new ChromeDriver();
		  log.info("Open Chrome Browser");
		  baseUrl = PropertyFileReader.getProperties("url");
		  driver.get(baseUrl);
		  log.info("Get The Url to Open");
	  }
	
	  @AfterClass
	  public void afterClass() {
		  log.warn("driver object is closing");
		  driver.close();
	  }
}

//log.warn
//log.critical
//log.error
//log.fatal
//log.trace