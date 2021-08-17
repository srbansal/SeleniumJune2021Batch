package com.teams.team5.WebElements;

import org.testng.annotations.Test;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Handling_ButtonAndImage {
	WebDriver driver;
	
  @Test
  public void buttonTest() throws InterruptedException {

		
		driver.get("https://login.yahoo.com/");

		
		WebElement login = driver.findElement(By.id("login-signin"));

		
		boolean status = login.isDisplayed();
		System.out.println("Displayed Status is: "+status);//true
		

		status = login.isEnabled();
		System.out.println("Enabled Status is: "+status);//true

		String elementType= login.getAttribute("type");//submit
		System.out.println(elementType);

		login.click();// to click button

		Thread.sleep(8000);

  }
  @Test
  public void imageTest() throws InterruptedException {
	 
	  	driver.get("https://www.google.com/");

		//Return the �Google Image� Title
		String title = driver.findElement(By.id("hplogo")).getAttribute("title");
		System.out.println(title);

		//Handling Image Link
		
		Thread.sleep(8000);

		driver.get("https://www.selenium.dev/");
		WebElement testBirds = driver.findElement(By.xpath("/html/body/div/main/div[3]/div[1]/a/img"));

		System.out.println(testBirds.isDisplayed());//true

		System.out.println(testBirds.isEnabled());//true

		testBirds.click();
		Thread.sleep(8000);
		

  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
  }
  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
