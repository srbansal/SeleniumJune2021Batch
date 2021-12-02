package com.participants.Pooja.Others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider01 {
	WebDriver driver;
  @Test(dataProvider="userdata")
  public void f( String username,String password) throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
	
	driver.get("https://login.yahoo.com/");
	Reporter.log("Executing text with "+username+" password "+password);
	driver.findElement(By.id("login-username")).sendKeys(username);
	driver.findElement(By.id("login-signin")).click();
	Thread.sleep(5000);
	driver.findElement(By.id("login-passwd")).sendKeys(password);
	driver.findElement(By.id("login-signin")).click();
	System.out.println(driver.getTitle());
  }
  
  @DataProvider(name="userdata")
  public Object[][] SendUserData(){
	  Object[][] User= {
			  {"wrong username","wrongpass"	  }
  };
	  return(User);
  
}
}
