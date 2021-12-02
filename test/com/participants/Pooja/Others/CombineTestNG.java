package com.participants.Pooja.Others;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.PropertyReader;

public class CombineTestNG {
	WebDriver driver;
	String urlwiki="https://www.wikipedia.org/";
	String baseUrl="https://google.com";
	String expectedTitle=null;

  @Test
  public void TestGoogle() {
	  driver.get(baseUrl);
	String actualTitle=driver.getTitle();
	assertEquals(actualTitle, expectedTitle);
  }
  
  @Test
  public void Testwiki() {
	  
	  driver.get(urlwiki);
	  driver.findElement(By.id("js-link-box-en")).click();
	  driver.findElement(By.name("search")).sendKeys("Selenium");
	  driver.findElement(By.name("go")).click();
	  
	  if(driver.getTitle().contains("Selenium"))
	  {
		  System.out.println("Title matched");
	  }
	  else
		  System.out.println("Title not matched");
	  
	 String heading=driver.findElement(By.id("firstHeading")).getText();

	 
	 
	 assertEquals(heading,"Selenium");
	 
	 
	 
	 
	 
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  String ChromeDriverPath=PropertyReader.getProperty("ChromeDriverPath");
	  System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
	  expectedTitle=PropertyReader.getProperty("expectedtitlegoogle");
		  driver=new ChromeDriver();

  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(4000);
	  driver.quit();
  }

}
