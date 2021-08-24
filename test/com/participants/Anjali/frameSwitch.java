package scripts.basics;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frameSwitch {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		String baseUrl="http://www.cookbook.seleniumacademy.com/Frames.html";
		
		System.setProperty("webdriver.chrome.driver", "test/resource/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(baseUrl);
		
			        try {
			          driver.switchTo().frame("left");
			        } catch (NoSuchFrameException e) {
			            fail("Frame was expected but not found");
			        }			        WebElement leftmsg = driver.findElement(By.tagName("p"));
			        assertEquals(leftmsg.getText(), "This is Left Frame");
			        driver.switchTo().defaultContent();
			        
			        // Activate the frame in middle using it's index. Index starts at 0

			        	          driver.switchTo().frame(1); 
			        	          WebElement middlemsg = driver.findElement(By.tagName("p"));
			        	          assertEquals("This Frame doesn't have id or name", middlemsg.getText());
			        	          driver.switchTo().defaultContent(); 
			        	          // Activate the frame on right side using it's name attribute

			        	        	          driver.switchTo().frame("right");  
			        	        	          WebElement rightmsg = driver.findElement(By.tagName("p"));
			        	        	          assertEquals(rightmsg.getText(), "This is Right Frame");			        	        	          
			        	        	          driver.switchTo().defaultContent(); 			        	        	          
			        	        	          
		//////////////////////////////////////////////////////////////////////////////
			        	        	        	    // Get all frames on the Page, created with <frame> tag
			        	        	        	        List<WebElement> frames = driver.findElements(By.tagName("frame"));
			        	        	        	        // In this example frame in the middle is activated by checking the contents
			        	        	        	        // Activate frame and check if it has the desired content. If found perform the
			        	        	        	        // operations
			        	        	        	        // if not, then switch back to the Page and continue checking next frame
			        	        	        	        for (WebElement frame : frames) {
			        	        	        	            driver.switchTo().frame(frame);
			        	        	        	            if (driver.getPageSource().contains("This Frame doesn't have id or name")) {
			        	        	        	                assertTrue(true);
			        	        	        	                break;
			        	        	        	            } else
			        	        	        	                driver.switchTo().defaultContent();
			        	        	        	        }
			        	        	        	        // Activate the Page, this will move context from frame back to the Page
			        	        	        	        driver.switchTo().defaultContent();
/////////////////////////////////////////////////////////////////////////
//			        	        	        	        iframe, parent window, etc
			        	        	        	        
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
//			        	        	        	                    Take required action
			        	        	        	                    driver.close();
			        	        	        	                    break;
			        	        	        	                }
			        	        	        	                    
			        	        	        	            }
			        	        	        	        }
			        	        	        	        driver.switchTo().window(currentWindow);
			        	        	        	        driver.switchTo().parentFrame();
			        	        	        	        driver.switchTo().defaultContent();
			        	        	        	        
			        	        	        	        Thread.sleep(2000);
			        	        	        	        driver.quit();

	}

}
