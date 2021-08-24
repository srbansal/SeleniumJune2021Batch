package com.persistent.vaibhav;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Node1CH {
	 DesiredCapabilities dr=null;
	 String username=null;
	 String password=null;
	 String yahoo=null;
	 RemoteWebDriver driver;
	 
    @Test
    public void chrometest() throws IOException, InterruptedException{
    	
    			//create DesiredCapabilities object
    			DesiredCapabilities  capability=DesiredCapabilities.chrome();
    	         //set browser name
    			capability.setBrowserName("chrome");
    	         //set platform as windows
    			capability.setPlatform(Platform.WINDOWS);
    	         
     //using the RemoteWebDriver object
    RemoteWebDriver driver=new RemoteWebDriver(new    URL("http://192.168.43.192:4444/wd/hub"), capability);
    driver.manage().window().maximize();
        driver.navigate().to(yahoo);
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
    	   
         username = "username";
		 password = "password";
		 yahoo= "https://login.yahoo.com/";

    }
    
    
    
}