package script.basis;

import org.testng.annotations.Test;

import Utilities.PropertyReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class A06_MultipleTestNGtest_wikitest_googletestFFClass_SameBrowserOpen {
	WebDriver driver;
	String baseUrl=null;
	String expectedTitle=null;
	String driverpath=null;


  @Test
  public void wikitestTest() throws InterruptedException, IOException {
	  baseUrl=PropertyReader.getProperty("urlwiki");
		driver.get(baseUrl);
		
		expectedTitle=PropertyReader.getProperty("expectedTitleWiki");
		
		String actualTitle=driver.getTitle();
		
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Title matched :  TC passed");
		}
		else
		{
			System.out.println("Title NOT matched :  TC failed");
		}
		
		driver.findElement(By.id("js-link-box-en")).click();
		driver.findElement(By.id("searchInput")).sendKeys("Selenium");
		driver.findElement(By.id("searchButton")).click();
		
		if(driver.getTitle().contains("Selenium"))
		{
			System.out.println("Title matched for SE");
		}
		else
		{
			System.out.println("Title did not matched");
		}
		
		// heading search
		String heading = driver.findElement(By.id("firstHeading")).getText();
		
		assertEquals(heading, "Selenium");   //(Actual,expected)
		
		Thread.sleep(2000);
  }

  
  
  
  @Test
  public void googleTestTest() throws InterruptedException, IOException {
	  
		baseUrl=PropertyReader.getProperty("urlGoogle");

		
		driver.get(baseUrl);
		
		expectedTitle=PropertyReader.getProperty("expectedTitleGoogle");
		
		
		String actualTitle=driver.getTitle();//fetch the title of current page
		
		assertEquals(actualTitle,expectedTitle);
		
		Thread.sleep(2000);
		
  }
  
  
  @BeforeClass
  public void beforeClass() throws IOException {
	  driverpath=PropertyReader.getProperty("geckoDriverPath");
	  
	  System.setProperty("webdriver.gecko.driver", driverpath);
	  
	  driver=new FirefoxDriver();
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

  
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before method ");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After method ");

  }

}


/*
 ---------------------------
 Execution process
 ----------
 
 Before class : 1   /// executed only one time
 Before method
 Test1
 After method
 
 
 Before method
 Test2
 After method
 
 
 After class : 1 /// executed only one time
 ---------------------------------------------------
 
 */



