package com.persistent.vaibhav;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class RobotClass {
	WebDriver driver;
  @Test
  public void Mouse_Event() throws InterruptedException, AWTException {
	  driver.get("https://www.amazon.in/"); // sample url
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("See all deals")).click();
		Robot robot = new Robot(); // Robot class throws AWT Exception
		Thread.sleep(2000); 
		robot.keyPress(KeyEvent.VK_DOWN); // press arrow down key of keyboard 
		Thread.sleep(2000); 
		robot.mouseMove(200, 200);
		Thread.sleep(2000);
		robot.mouseMove(200, 200);
		Thread.sleep(2000);
	  
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
