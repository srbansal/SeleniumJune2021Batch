package scripts.basics;

import org.testng.annotations.Test;

import Utilities.PropertyReader;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class A08_MultipleTestNgTests_BeforeAfterClass {
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
		
		System.out.println("Test2");
		Thread.sleep(2000);
  }
  
  
  @Test
  public void googleTest() throws InterruptedException, IOException {
	  
	  	baseUrl = PropertyReader.getProperty("urlGoogle");
		driver.get(baseUrl);
		expectedTitle = PropertyReader.getProperty("expectedTitleGoogle");

	  
		String actualTitle = driver.getTitle();	
					
		assertEquals(actualTitle, expectedTitle);
		
		System.out.println("Test1");		  
		Thread.sleep(2000);
  }
	
	
  @BeforeClass
  public void beforeClass() throws IOException {
		driverPath = PropertyReader.getProperty("geckoDriverPath");
				
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		System.out.println("Before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Afer Class");
	  driver.quit();
  }

  @BeforeMethod
  public void beforeMethod() throws IOException {
	  System.out.println("Before Method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method");
  }

}
