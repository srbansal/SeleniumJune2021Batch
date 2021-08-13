package scripts.basics;

/*
Purpose of this script

specific:

Issue faced/ Resolved:


*/

import org.testng.annotations.Test;

import Utilities.PropertyReader;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class A07_MultipleTestNgTests_WikiTest_GoogleTestFF {
	WebDriver driver;
	String baseUrl=null;
	String expectedTitle=null;
	String driverPath=null;

	
  @Test
  public void wikiTest() throws InterruptedException, IOException {
	  
	  	baseUrl = PropertyReader.getProperty("urlWiki");
	  	driver.get(baseUrl);
		expectedTitle = PropertyReader.getProperty("expectedTitleWiki");
	  
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals(expectedTitle))
			System.out.println("Title matched: TC Passed");
		else
			System.out.println("Title not matched: TC failed");
		
		driver.findElement(By.id("js-link-box-en")).click();
		driver.findElement(By.id("searchInput")).sendKeys("Selenium");
		driver.findElement(By.id("searchButton")).click();
		
		if(driver.getTitle().contains("Selenium"))
			System.out.println("Title matched for SE");
		else
			System.out.println("Title matched did not match for SE");
		
		String heading = driver.findElement(By.id("firstHeading")).getText();
		assertEquals(heading, "Selenium");
		
		Thread.sleep(2000);
  }
  
  
  @Test
  public void googleTest() throws InterruptedException, IOException {
	  
	  	baseUrl = PropertyReader.getProperty("urlGoogle");
		driver.get(baseUrl);
		expectedTitle = PropertyReader.getProperty("expectedTitleGoogle");

	  
		String actualTitle = driver.getTitle();	// fetch the title of current page	
					
		assertEquals(actualTitle, expectedTitle);
				  
		Thread.sleep(2000);
  }
	

  @BeforeMethod
  public void beforeMethod() throws IOException {
		driverPath = PropertyReader.getProperty("geckoDriverPath");
				
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();	// launch a new browser instance
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();	// close the browser
  }

}
