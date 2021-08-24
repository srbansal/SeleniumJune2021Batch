package scipts.basics;

import org.testng.annotations.Test;

import com.fileHandle.PropertyReader;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;


public class A12_frames {
	
	String baseUrl=null;
	String expectedTitle= null;
	String browserType=null;
	WebDriver driver=null;
	
	public void GoogleTest() {
		 baseUrl=PropertyReader.getProperty("Googleurl");
		 expectedTitle= PropertyReader.getProperty("expectedTitleGoogle");
		
		driver.get("http://www.cookbook.seleniumacademy.com/Frames.html");
		driver.manage().window().maximize();
	       driver.switchTo().frame("left"); 
	    System.out.println("********We are switch to the left frame*******");
    	String left=driver.findElement(By.xpath("/html/body/p")).getText();   
    	System.out.println(left);
    	driver.switchTo().defaultContent();
    	driver.switchTo().frame("right"); 
	    System.out.println("********We are switch to the right frame*******");
    	String right=driver.findElement(By.tagName("p")).getText();    
    	System.out.println(right);
    	driver.switchTo().defaultContent();
    	driver.switchTo().frame(1); 
	    System.out.println("********We are switch to the  middel frame*******");
    	String index=driver.findElement(By.tagName("p")).getText();   
    	System.out.println(index);
    	driver.switchTo().defaultContent();
    	
     		
	}
	
	void usinglist() {
		driver.get("http://www.cookbook.seleniumacademy.com/Frames.html");
		driver.manage().window().maximize();
	    
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
               System.out.println("Middle frame");
                // Take necessary action here 
                break;
            } else
                driver.switchTo().defaultContent();
        }
        // Activate the Page, this will move context from frame back to the Page
        driver.switchTo().defaultContent();
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
  public void Test() {
	  //GoogleTest();
	  //usinglist();
	  frames_popups();
	  	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  	
	  	String browserType=PropertyReader.getProperty("browser");
		String DiverPath=PropertyReader.getProperty("chromeDriverPath");
		System.setProperty("webdriver.chrome.driver", DiverPath);
		driver=new ChromeDriver();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
