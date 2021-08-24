package com.participants.vaibhav;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class YahooLogin_with_TestNG {
	WebDriver driver;
	String baseUrl = null;
  @Test
  public void yahooLogin() throws IOException, InterruptedException {
	  	String baseUrl = PropertyReader.getProperties("yahoo");
		driver.get(baseUrl);
		driver.findElement(By.className("_yb_zl0iu")).click();
		driver.findElement(By.id("login-username")).sendKeys(PropertyReader.getProperties("email"));
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("password")).sendKeys(PropertyReader.getProperties("pass"));
		driver.findElement(By.id("login-signin")).click();
		
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
		System.setProperty(PropertyReader.getProperties("cKey"), PropertyReader.getProperties("cValue"));
		driver = new ChromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  try {
			if(!driver.findElement(By.id("ybarMailLink")).getText().isEmpty()) {
				System.out.println("Login success");
			}	
			driver.close();
		} catch (Exception e) {
			System.out.println("Login Failed");
			driver.close();
	
		}
  }
  

}
