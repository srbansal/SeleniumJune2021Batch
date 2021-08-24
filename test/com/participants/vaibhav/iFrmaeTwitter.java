package com.persistent.vaibhav;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

public class iFrmaeTwitter {
	WebDriver driver;
	
	void screenshot() throws IOException {
		driver.get(PropertyReader.getProperties("baseURL"));
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		
		UUID uuid=UUID.randomUUID(); //Generates random UUID  
		String stamp = dtf.format(now);
		
		String IMGName = "IMG_"+stamp+"_"+uuid;
		FileUtils.copyFile(scrFile,new File("C:\\Users\\VSW\\Desktop\\Training\\java\\Basic Programs\\Selenium\\ScreenShots\\"+IMGName+".png"));
		driver.quit();
		
	}
	
	void frames_popups() {
		driver.get("http://www.cookbook.seleniumacademy.com/Frames.html");
		driver.manage().window().maximize();
	    
//      iframe, parent window, etc
        
      //The frame on the right side has a nested iframe containing 'Twitter Follow' Button
      //Activate the frame on right side using it's name attribute
      
      //Store the handle of current driver window
      String currentWindow = driver.getWindowHandle(); 
      
      driver.switchTo().frame("right");
      
      //Get the iframe element
      WebElement twitterframe = driver.findElement(By.tagName("iframe"));
      
      //Activate the iframe 
      driver.switchTo().frame(twitterframe);
      
      //Get and Click the follow button from iframe
      //a Popup Window will appear after click
      
      WebElement button = driver.findElement(By.id("follow-button"));
      button.click();
      
      
  
      
      //The Twitter Popup does not have name or title. 
      //Script will get handles of all open windows and 
      //desired window will be activated by checking it's Title
      Set<String> allWindows = driver.getWindowHandles();
      if(!allWindows.isEmpty()) {
          for (String windowId : allWindows)
          {
              /*
               * //If there are only two windows then following will work
               * if(!windowId.equals(currentWindow)) { driver.switchTo().window(windowId);
               * driver.close(); break; }
               */
               
              
              //But best is to use below as it will work even if another window
              // is open apart from twitter.
              driver.switchTo().window(windowId);
              if (driver.getTitle().equals("Unmesh Gundecha (@upgundecha) on Twitter")) {
                  assertTrue(true);
//                  Take required action
                  driver.close();
                  break;
              }
                  
          }
      }
       driver.switchTo().window(currentWindow);
       driver.switchTo().parentFrame();
       driver.switchTo().defaultContent();
	}


	@Test
	public void f() throws IOException {
		screenshot();
		//frames_popups();
//    
	}
	@BeforeMethod
	public void beforeMethod() throws IOException {
		System.setProperty(PropertyReader.getProperties("cKey"), PropertyReader.getProperties("cValue"));
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
