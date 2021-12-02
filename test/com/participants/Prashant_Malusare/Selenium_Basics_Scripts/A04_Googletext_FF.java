package script.basis;

import org.testng.annotations.Test;

import Utilities.PropertyReader;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class A04_Googletext_FF {
	
	WebDriver driver;
	String baseUrl=null;
	String expectedTitle=null;
	String driverPath=null;
  @Test
  public void f() throws InterruptedException {
	  
	  driver.get(baseUrl);
	  
	  String actualTitle=driver.getTitle();
	  
	  assertEquals(actualTitle,expectedTitle);
	  
	  
	 /* if(actualTitle.equals(expectedTitle))
	  {
		  System.out.println("Title matched: TC Passed");
	  }
	  else
	  {
		  System.out.println("Title matched: TC Passed");

	  }
	  */
	 Thread.sleep(3000);
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  baseUrl=PropertyReader.getProperty("urlGoogle");
	  expectedTitle=PropertyReader.getProperty("expectedTitleGoogle");
	  driverPath=PropertyReader.getProperty("geckoDriverPath");
	  
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  driver=new FirefoxDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
