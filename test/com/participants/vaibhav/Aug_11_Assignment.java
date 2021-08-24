package com.participants.vaibhav;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Aug_11_Assignment {
	WebDriver driver;
	
	
  @Test
  public void google() throws InterruptedException {
	  String baseUrl = "https://www.google.com";
	  driver.get(baseUrl);
	  Thread.sleep(3000);
	  
	  //Wikipedia
	  
  }
  @Test
  public void wikiTest() {
	  
	  String baseUrl2 = "https://www.wikipedia.org/";
	  driver.get(baseUrl2);
	  
	  driver.findElement(By.id("js-link-box-en")).click();
      driver.findElement(By.name("search")).sendKeys("selenium");
	  driver.findElement(By.name("go")).click();
	  String heading = driver.findElement(By.id("firstHeading")).getText();	
		
	  
	  assertEquals(heading,"selenium");
//		if(heading.equals("Selenium")) {
//			System.out.println("Heading Matched...");
//		}else {
//			System.out.println("Heading NOT Matched...");
//		}
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "test/resorces/chromedriver.exe");
	  driver = new ChromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  
  }

}
