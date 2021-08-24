package com.persistent.vaibhav;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Robot_KeyUpDown {
	WebDriver driver;
  @Test
  public void Robot_key() {
	  try {
			
			String url = "https://www.tutorialspoint.com/index.htm";
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	      
			// identify element
			WebElement l = driver.findElement(By.id("search-strings"));
			// Actions class
			Actions a = new Actions(driver);
			// moveToElement() and then click()
			a.moveToElement(l).click();
			//enter text with keyDown() SHIFT key ,keyUp() then build() ,perform()
			a.keyDown(Keys.SHIFT);
			a.sendKeys("hello key Up").keyUp(Keys.SHIFT).build().perform();//Sending values to the specific element
			Thread.sleep(200);//Thread for some time
			WebElement btn = driver.findElement(By.id("btnSearch"));//Finding element to perform double click action
			a.moveToElement(btn).build().perform(); //cursor hover			
			a.doubleClick(btn).perform();//Double click action to search
			driver.close();
			
	}catch(Exception e) {
		
	}
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  System.setProperty(PropertyReader.getProperties("cKey"), PropertyReader.getProperties("cValue"));
	  driver = new ChromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
