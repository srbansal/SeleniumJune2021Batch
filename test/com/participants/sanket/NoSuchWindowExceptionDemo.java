package com.participants.sanket;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//This Exception occurs if the window target to be switch does not exist.

public class NoSuchWindowExceptionDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");
		
		driver.findElement(By.xpath("//a[text()='Open a popup window']")).click();
		String windowId=driver.getWindowHandle();
		try {
			driver.switchTo().window("XYZ");
		}
		catch(NoSuchWindowException e)
		{
			System.out.println("NoSuchWindowException got handled");
		}
		
		Thread.sleep(2000);
		driver.quit();

	}

}
