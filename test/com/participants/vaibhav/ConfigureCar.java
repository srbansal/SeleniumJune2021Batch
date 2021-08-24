package com.persistent.vaibhav;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class ConfigureCar {
	WebDriver driver;
	
  @Test
  public void ConfigCar() throws IOException, InterruptedException {
	  driver.get(PropertyReader.getProperties("baseURL"));
	  driver.findElement(By.xpath("//*[@title='Search']")).sendKeys("Selenium");
	  driver.findElement(By.xpath("//*[@value='Google Search']")).submit();
	  driver.findElement(By.cssSelector(("body"))).sendKeys(Keys.CONTROL+"t");
	  driver.navigate().to(PropertyReader.getProperties("amazon"));
	  System.out.println("Current URL is:-"+driver.getCurrentUrl());
	  Thread.sleep(2000);
	  driver.navigate().back();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() throws IOException {
	  System.setProperty(PropertyReader.getProperties("cKey"), PropertyReader.getProperties("cValue"));
	  driver = new ChromeDriver();
	  	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
