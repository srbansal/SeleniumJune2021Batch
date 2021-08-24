package com.participants.Pooja.Others;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class BeforeTest_AfterTest {
	WebDriver driver;
	String url="https://www.google.co.in/";
  
	@BeforeTest
	  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		driver=new ChromeDriver();
			System.out.println("Setup");
	  }	
	
	
@Test(description="search term on google")
  public void GoogleSearch() {
	  driver.get(url);
	  System.out.println(driver.getTitle());
  }
  

  @AfterTest
  public void afterTest() {
	  driver.quit();
	  System.out.println("AfterTest");
  }

}
