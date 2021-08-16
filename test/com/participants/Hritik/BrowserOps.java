package scripts.basics;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.testng.annotations.AfterClass;

public class BrowserOps {
	WebDriver driver;
	@Test
  public void Operations() throws InterruptedException {
		
        
        driver.get("https://www.wikipedia.org/");
        driver.get("https://www.google.com/");
                
      Thread.sleep(2000);
      driver.navigate().back();
      
      Thread.sleep(2000);
      driver.navigate().forward();
      
      Thread.sleep(2000);
      driver.navigate().refresh();
      
      Thread.sleep(2000);
      driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");
      
      Thread.sleep(2000);
      driver.manage().window().maximize();
      Thread.sleep(2000);
      driver.manage().deleteAllCookies();
      Thread.sleep(2000);
      System.out.println(driver.getCurrentUrl()); 
      Thread.sleep(2000);
      Dimension size = driver.manage().window().getSize();
      driver.manage().window().setSize(size);
      
      driver.navigate().to(driver.getCurrentUrl());
      driver.
  }
  @BeforeClass
  public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		driver = new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
