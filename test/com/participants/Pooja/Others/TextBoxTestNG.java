package com.participants.Pooja.Others;

import org.testng.annotations.Test;

import utilities.PropertyReader;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TextBoxTestNG {
	
	WebDriver driver;
	
	String username = null;
	String password = null;
	String ChromeDriverPath = null;
	 String baseUrl;
  @Test
  public void TestTextBox() throws InterruptedException {
	    driver.get("https://login.yahoo.com/");
		WebElement user_name= driver.findElement(By.id("login-username"));
		boolean status = user_name.isDisplayed();
		System.out.println("Displayed Staus is: "+status);//true

		status = user_name.isEnabled();
		System.out.println("Enabled Staus is: "+status);//true
		
		user_name.sendKeys(username);
		Thread.sleep(5000);
	   String typeofInput = user_name.getAttribute("type");
		System.out.println("Input Type: "+ typeofInput);//text
		
		user_name.clear();
		
		Thread.sleep(5000);

		user_name.sendKeys("ABCD123");
		Thread.sleep(2000);

		String val = user_name.getAttribute("value");
		System.out.println("Attribute value enter: " +val);//ABCD123
	  
  }
  @Test
  public void Testlink() throws InterruptedException {
		
		driver.get("https://www.google.com/");

		WebElement gmail = driver.findElement(By.linkText("Gmail"));

		Thread.sleep(1000);
		boolean status1 = gmail.isDisplayed();
		System.out.println("Displayed Staus is: "+status1);//true

		status1 = gmail.isEnabled();
		System.out.println("Enabled Staus is: "+status1);//true
		Thread.sleep(3000);
		String linkName = gmail.getText();
		String link=gmail.getAttribute("href");
    	System.out.println("Link Name: "+linkName);
    	System.out.println("Link: "+link);

        gmail.click();
	
  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  username = PropertyReader.getProperty("username");
		password=PropertyReader.getProperty("password");
		ChromeDriverPath=PropertyReader.getProperty("ChromeDriverPath");
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		  driver=new ChromeDriver();
		driver.manage().window().maximize();
			
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
