package com.teams.team7_afk.robotclass;

import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

//handling keyboard and mouse events.

public class MouseEvents {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "Test/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void f() throws AWTException, InterruptedException {
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

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
