package script.basis;

import org.testng.annotations.Test;

import Utilities.PropertyReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class A09_BrowserCommands {
	WebDriver driver;
	String urlwiki;
	String urlGoogle;
	
	String driverPath;
	
	
  @Test
  public void wikiTest() throws IOException, InterruptedException {
	  
	  
	  urlwiki=PropertyReader.getProperty("urlwiki");
	  urlGoogle=PropertyReader.getProperty("urlGoogle");
	  
	  driver.get(urlwiki);
	  driver.get(urlGoogle);
	  
	  Thread.sleep(2000);
	 /* driver.navigate().back();
	  
	  Thread.sleep(2000);
	  driver.navigate().forward();
	  
	  Thread.sleep(2000);*/
	  driver.navigate().refresh();
	  
	  
	  Thread.sleep(2000);
	  driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");
	  
	  
	  //
	  
	  Dimension size=driver.manage().window().getSize();
	  
	  Thread.sleep(2000);
	  
	  //Maximize
	  
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
	  
	  
	  driver.manage().window().setSize(size);
	  //Delete cookies
	  
	  driver.manage().deleteAllCookies();
	  
	  
	  //get and print current url
	  
	  String currentUrl= driver.getCurrentUrl();
	  //getpage source
	  
	  
	  String pageContents=driver.getPageSource();
	  
	  
	  System.out.println(currentUrl +"-"+pageContents.charAt(0));
	  
	  
	  
	  Thread.sleep(2000);
	  
	  driver.navigate().to(driver.getCurrentUrl());
	  
	  driver.findElement(By.name("abs")).sendKeys(Keys.F5);
	  
	  driver.findElement(By.cssSelector(("body"))).sendKeys(Keys.CONTROL+"t");
	  Thread.sleep(2000);
	  
	  driver.findElement(By.cssSelector(("body"))).sendKeys(Keys.CONTROL,Keys.F4);
	  
	  
	  

	  
	  
	  
	  

	  
	//  driver.manage().window().
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After method");

  }

  @BeforeClass
  public void beforeClass() throws IOException {
	  driverPath=PropertyReader.getProperty("chromeDriverPath");
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  driver=new ChromeDriver();
	
  }

  @AfterClass
  public void afterClass() {
	 // driver.quit();
  }

}
