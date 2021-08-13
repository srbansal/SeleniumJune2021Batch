package scripts.basics;

import org.testng.annotations.Test;

import Utilities.PropertyReader;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

//import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class A09_BrowserCommands {
	WebDriver driver;
	String urlWiki=null;
	String urlGoogle=null;
	String driverPath=null;

	
  @Test
  public void wikiTest() throws InterruptedException, IOException {
	  
	  	urlWiki = PropertyReader.getProperty("urlWiki");
	  	urlGoogle = PropertyReader.getProperty("urlGoogle");
	  	
	  	driver.get(urlWiki);
	  	driver.get(urlGoogle);
	  			
		Thread.sleep(2000);
		driver.navigate().back();
		
		Thread.sleep(2000);
		driver.navigate().forward();
		
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		Thread.sleep(2000);
		driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");
		
		Thread.sleep(2000);
		
//		Restore: Dimension size = ...getSize()		Maximize()		setSize()
		Dimension size = driver.manage().window().getSize();
		Thread.sleep(2000);
				
//		Maximize
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.manage().window().setSize(size);
		
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
//		driver.manage().window().setSize(new org.openqa.selenium.Dimension(600, 600));
		
//		DeleteAllCookies
//		driver.manage().deleteAllCookies();
		
//		get and print current url
		String currentUrl = driver.getCurrentUrl();
//		getPageSource
		String pageContents = driver.getPageSource();
		
		System.out.println(currentUrl + " - " + pageContents.charAt(0));
		
		
//		More ways to refresh the page
		Thread.sleep(2000);
		driver.navigate().to(driver.getCurrentUrl());
		
//		driver.findElement(By.id("username")).sendKeys(Keys.F5);
		driver.findElement(By.name("abs")).sendKeys(Keys.F5);
		
		
//		driver.execute_script("window.open('');")
		
//		Open a new tab and launch a different site in new tab
//		close only the newly opened tab
		driver.findElement(By.cssSelector(("body"))).sendKeys(Keys.CONTROL+"t");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(("body"))).sendKeys(Keys.CONTROL,Keys.F4);		
		
		
		
		
			
		
		
		
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
