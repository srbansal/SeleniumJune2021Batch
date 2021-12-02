package com.participants.sanket;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frame {
  WebDriver driver;
  @Test
  public void f() throws Exception{
//	  System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
//	  driver=new ChromeDriver();
//      driver.get("http://www.cookbook.seleniumacademy.com/Frames.html");
//      int sizeLeft = driver.findElements(By.id("left")).size();
//      int sizeRight = driver.findElements(By.name("right")).size();
//      System.out.println(sizeLeft+" "+sizeRight);
//      driver.switchTo().frame(1);
//      Thread.sleep(2000);
//	  driver.quit();
	  //1st way
//	  fail("Frame was expected but not found");
	 try { 
	    driver.switchTo().frame("frame-left"); //id attribute attribute of frame element
	    driver.switchTo().frame("left"); // id attribute or a name attribute of frame element
	 } catch (NoSuchFrameException e) {
          fail("Frame was expected but not found");
     }
	// Get an element from the frame on left side and verify it's contents
	WebElement leftmsg = driver.findElement(By.tagName("p"));
	assertEquals(leftmsg.getText(), "This is Left Frame");
	// Activate the Page, this will move context from frame back to the Page
	driver.switchTo().defaultContent();
	
	
	//2nd
	 // Activate the frame on right side using it's name attribute
    driver.switchTo().frame("right");
    // Get an element from the frame on right side and verify it's contents
    WebElement rightmsg = driver.findElement(By.tagName("p"));
    assertEquals(rightmsg.getText(), "This is Right Frame");
    // Activate the Page, this will move context from frame back to the Page
    driver.switchTo().defaultContent(); 
    
    
    //3rd
    // Activate the frame in middle using it's index. Index starts at 0
    driver.switchTo().frame(1);
    // index 
    // Get an element from the frame in the middle and verify it's contents 
    WebElement middlemsg = driver.findElement(By.tagName("p"));
    assertEquals("This Frame doesn't have id or name", middlemsg.getText());
    
    // Activate the Page, this will move context from frame back to the Page
    driver.switchTo().defaultContent();
    
    
    // loop example
    // Get all frames on the Page, created with <frame> tag
    List<WebElement> frames = driver.findElements(By.tagName("frame"));
    // In this example frame in the middle is activated by checking the contents
    // Activate frame and check if it has the desired content. If found perform the
    // operations
    // if not, then switch back to the Page and continue checking next frame
    for (WebElement frame : frames) {
        // switchTo().frame() also accepts frame elements apart from id, name or index
        driver.switchTo().frame(frame);
        if (driver.getPageSource().contains("This Frame doesn't have id or name")) {
            assertTrue(true);
            // Take necessary action here 
            break;
        } else
            driver.switchTo().defaultContent();
    }
    // Activate the Page, this will move context from frame back to the Page
    driver.switchTo().defaultContent();
    
    
	    //More on Frames
	//  iframe, parent window, etc
	    
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
	      for (String windowId : allWindows) {
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
  }
}