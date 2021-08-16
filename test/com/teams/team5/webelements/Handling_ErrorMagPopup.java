package com.teams.team5.webelements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Handling_ErrorMagPopup {
	WebDriver driver;
	
	

  @Test
  public void ErrorHandler() throws InterruptedException
  {
		driver.manage().window().maximize();

		driver.get("https://gcreddy.com/project/admin/login.php");
		
		
		//Return a text from a web page
		String text = driver.findElement(By.className("smallText")).getText();
		System.out.println(text);

		driver.findElement(By.id("tdb1")).click();
		Thread.sleep(1000);

		//Return an Error Message
		String errorMessage = driver.findElement(By.className("messageStackError")).getText();
		System.out.println(errorMessage);

		driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(1000);

		Alert popUp = driver.switchTo().alert();    //Changing driver focus from the Browser window to popup widow
		
		//Return the Error message from a PopUp window
		String message = popUp.getText();
		Thread.sleep(1000);
		System.out.println(message);
		popUp.accept();

		Thread.sleep(3000);
		driver.close();


  }
  
  
  
  @BeforeClass
  public void beforeClass() {
	  
	  
	  System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
	  
	  driver=new ChromeDriver();
	  
  }

  @AfterClass
  public void afterClass() {
	  
	  
	  driver.quit();
  }
  
}
