[1:02 PM, 8/16/2021] Sanket Sinha CS: package scripts;

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
 #Set level
log4j.rootCategory=debug, console, file  
  
# Appender which writes to console  
log4j.appender.console=org.apache.log4j.ConsoleAppender  
log4j.appender.console.layout=org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern=%d{MM-dd-yyyy HH:mm:ss} %F %-5p [%t] %c{2} %L - %m%n
  
# Appender which writes to a file  
log4j.appender.file=org.apache.log4j.RollingFileAppender
log4j.appender.file.File=application.log
  
# Defining maximum size of a log file
log4j.appender.file.MaxFileSize=10mb 
log4j.appender.file.MaxBackupIndex=10
log4j.appender.file.layout=org.apache.log4j.PatternLayout  
log4j.appender.file.layout.ConversionPattern=%d{ISO8601} %5p [%t] %c{1}:%L - %m%n
log4j.appender.file.Append=false