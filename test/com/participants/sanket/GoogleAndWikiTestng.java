package com.participants.sanket;

import org.testng.annotations.Test;

import utilities.PropertyFileReader;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class GoogleAndWikiTestng {
	WebDriver driver;
	String baseUrl = null;
	String expectedTitle = null;

//	  @Test
//	  public void f() throws Exception{
//		  wikiTest();
//		  GoogleTest();
//	  }
	  @Test
	  public void wikiTest() throws Exception{
		  baseUrl = PropertyFileReader.getProperties("urlWiki");
		  expectedTitle = PropertyFileReader.getProperties("expectedTitleWiki");
		  driver = new ChromeDriver();
		  driver.get(baseUrl);
		  String actual = driver.getTitle();
		  
		 if(actual.equals(expectedTitle))
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
			
			Thread.sleep(2000);
	  }
	  
	  @Test
	  public void GoogleTest() throws Exception{
		  baseUrl = PropertyFileReader.getProperties("urlGoogle");
		  expectedTitle = PropertyFileReader.getProperties("expectedTitleGoogle");
		  driver = new ChromeDriver();
		  driver.get(baseUrl);
		  String actual = driver.getTitle();
		  if(actual.equals(expectedTitle)) {
			  System.out.println("TC Passed");
		  }else {
			  System.out.println("TC Not Passed");
		  }
			Thread.sleep(2000);

	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
	     System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
	  }
	
	  @AfterMethod
	  public void afterMethod() {
		  driver.close();
	  }
}