package scripts.basics;

import org.testng.annotations.Test;

import Utilities.PropertyReader;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class A05_WikiTest_FFTestNg {
	WebDriver driver;
	String baseUrl=null;
	String expectedTitle=null;
	String driverPath=null;
  @Test
  public void wikiTest() throws InterruptedException {
	  
	  driver.get(baseUrl);
	  
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
		
//		if(heading.equals("Selenium1"))
//			System.out.println("Heading matched");
//		else
//			System.out.println("Heading did not match");
		
//		assert.assertEquals(heading, "Selenium1");
		
//		assertEquals(heading, "Selenium1");
//		assertEquals(heading, "Selenium");
		
		
		Thread.sleep(2000);
  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
		baseUrl = PropertyReader.getProperty("urlWiki");
		expectedTitle = PropertyReader.getProperty("expectedTitleWiki");
		driverPath = PropertyReader.getProperty("geckoDriverPath");
		
		
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();	
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();	// close the browser
  }

}
