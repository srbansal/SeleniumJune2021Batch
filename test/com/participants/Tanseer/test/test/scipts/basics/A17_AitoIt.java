package scipts.basics;

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


public class A17_AitoIt {
	
	String baseUrl=null;
	String expectedTitle= null;
	String browserType=null;
	WebDriver driver=null;
	
		
  @Test
  public void Test() throws InterruptedException, IOException {
	 
	  driver.get("http://demo.guru99.com/test/autoit.html");	
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  driver.manage().window().maximize();		
     
      //Vertical scroll down by 600  pixels		
      js.executeScript("window.scrollBy(0,600)");
      
      //Switching frame		
      WebElement form_frame = driver.findElement(By.tagName("iframe"));
      //Activate the iframe 
      driver.switchTo().frame(form_frame);
      
      driver.findElement(By.id("input_3")).sendKeys("abc");                                 					
      driver.findElement(By.id("input_4")).sendKeys("abc.def@gmail.com");
      Thread.sleep(1000);
      driver.findElement(By.id("label_5")).click();			
      // below line execute the AutoIT script .
       Runtime.getRuntime().exec("F:\\autoit\\FileUpload.exe");	
       Thread.sleep(15000);
      driver.findElement(By.id("input_6")).sendKeys("AutoIT in Selenium");	
      Thread.sleep(1000);
      driver.findElement(By.id("input_2")).click();
      Thread.sleep(1000);
      driver.switchTo().defaultContent();
	    driver.close();
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
