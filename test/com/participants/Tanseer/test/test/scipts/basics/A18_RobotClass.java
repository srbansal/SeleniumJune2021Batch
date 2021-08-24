package scipts.basics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fileHandle.PropertyReader;


public class A18_RobotClass {
	
	String baseUrl=null;
	String expectedTitle= null;
	String browserType=null;
	WebDriver driver=null;
	void test2() throws InterruptedException, AWTException {
		driver.get("http://spreadsheetpage.com/index.php/file/C35/P10/"); // sample url	
        driver.findElement(By.xpath(".//a[@href=contains(text(),'yearly-calendar.xls')]")).click();	
        Robot robot = new Robot();  // Robot class throws AWT Exception	
        Thread.sleep(2000); // Thread.sleep throws InterruptedException	
        robot.keyPress(KeyEvent.VK_DOWN);  // press arrow down key of keyboard to navigate and select Save radio button	
        
        Thread.sleep(2000);  // sleep has only been used to showcase each event separately	
        robot.keyPress(KeyEvent.VK_TAB);	
        Thread.sleep(2000);	
        robot.keyPress(KeyEvent.VK_TAB);	
        Thread.sleep(2000);	
        robot.keyPress(KeyEvent.VK_TAB);	
        Thread.sleep(2000);	
        robot.keyPress(KeyEvent.VK_ENTER);	
    // press enter key of keyboard to perform above selected action	
	}
	
	void test3() throws AWTException, InterruptedException {
		 driver.get("http://www.facebook.com");
	        
	        // Create object of Robot class
	        Robot robot = new Robot();
	        // press arrow down key of keyboard
	        robot.keyPress(KeyEvent.VK_DOWN); 
	        
	        // sleep has only been used to showcase each event separately
	        Thread.sleep(2000); 
	        robot.keyPress(KeyEvent.VK_TAB);//Tab functionality
	        Thread.sleep(2000);
	        robot.keyPress(KeyEvent.VK_TAB);//Tab Functionality
	        Thread.sleep(2000);
	        robot.keyPress(KeyEvent.VK_TAB);//Tab Functionality
	        Thread.sleep(2000);
	        
	        // Finding Element By ID
	        driver.findElement(By.id("email")).sendKeys("Selenium@gmail.com");
	        
	        // pressing shift
	        robot.keyPress(KeyEvent.VK_SHIFT);
	        // Enter password
	        driver.findElement(By.id("pass")).sendKeys("mukesh");
	      //Element is Found and this comment is just to confuse you all
	        //     robot.keyRelease(KeyEvent.VK_SHIFT);//Releasing SHIFT
	        // Pressing Enter
	        robot.keyPress(KeyEvent.VK_ENTER);
	        
	        // Release Enter
	        robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
  @Test
  public void Test() throws InterruptedException, IOException, AWTException {
	 
	  driver.get("https://www.amazon.in/"); // sample url
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.findElement(By.linkText("See all deals")).click();
      Robot robot = new Robot(); // Robot class throws AWT Exception
      Thread.sleep(2000); 
      robot.keyPress(KeyEvent.VK_DOWN); // press arrow down key of keyboard 
      Thread.sleep(2000); 
      robot.mouseMove(200, 200); //mouse method
      Thread.sleep(2000); 
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
