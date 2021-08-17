//Action Class in Selenium is a built-in feature provided by the selenium for handling keyboard and mouse events.

package com.participants.shriram;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class ActionClass {
	WebDriver driver;
	String url = "https://www.google.com/";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "Test/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void actionClassMethod() throws InterruptedException {
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.name("q"))).build().perform(); //to move  cursor to particular element
		builder.keyDown(Keys.SHIFT).build().perform(); //to press shift and hold it
		driver.findElement(By.name("q")).sendKeys("selenium");
		builder.keyUp(Keys.SHIFT).build().perform(); // to release key
		builder.doubleClick(driver.findElement(By.name("q"))).build().perform(); //double click to select text
		
	}
	@Test
	public void seriesOfMultipleAction()
	{
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions builder = new Actions(driver);
		Action seriesOfAction=builder   //to perform series of operation
				.moveToElement(driver.findElement(By.name("q")))
				.keyDown(Keys.SHIFT)
				.sendKeys("selenium")
				.keyUp(Keys.SHIFT)
				.doubleClick(driver.findElement(By.name("q")))
				.build();
		seriesOfAction.perform();
	}
	
//	@Test
//	public void dragAndDrop()
//	{
//		driver.get("https://jqueryui.com/draggable/");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		driver.switchTo().frame(0);
//		
//		WebElement source = driver.findElement(By.id("draggable"));
//		WebElement dest = driver.findElement(By.id("droppable"));
//		Actions action = new Actions(driver);
//		action.dragAndDrop(source, dest).build().perform();
//	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
