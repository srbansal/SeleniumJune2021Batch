package com.participants.Pooja.Others;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.PropertyReader;

public class Node1CH {
	 DesiredCapabilities dr=null;
	 String username=null;
	 String password=null;
	 String yahoo=null;
	 RemoteWebDriver driver;
	 
    @Test
    public void chrometest() throws IOException, InterruptedException{
    	
    			//create DesiredCapabilities object
    			DesiredCapabilities  capabilities=DesiredCapabilities.chrome();
    	         //set browser name
    			capabilities.setBrowserName("chrome");
    	         //set platform as windows
    			capabilities.setPlatform(Platform.WINDOWS);
    	         
     //using the RemoteWebDriver object
    RemoteWebDriver driver=new RemoteWebDriver(new    URL("http://192.168.43.77:4444/wd/hub"), capabilities);
    driver.manage().window().maximize();
        driver.get(yahoo);
        Thread.sleep(2000);
        	
		driver.findElement(By.id("login-username")).clear();
		driver.findElement(By.id("login-username")).sendKeys(username);
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(5000);	
		driver.findElement(By.id("login-passwd")).clear();
		driver.findElement(By.id("login-passwd")).sendKeys(password);
		driver.findElement(By.id("login-signin")).click();
                 driver.close();
}
  
    
    
    @BeforeClass
    public void beforeclass() throws IOException {
    	   
         username = PropertyReader.getProperty("username");
		 password = PropertyReader.getProperty("password");
		 yahoo= PropertyReader.getProperty("yahoo");

    }
    
    
    
}