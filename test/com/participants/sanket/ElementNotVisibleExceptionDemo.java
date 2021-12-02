package com.participants.sanket;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//This type of Selenium exception occurs when an existing element in DOM has a feature set as hidden.

public class ElementNotVisibleExceptionDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");
		try {
			driver.findElement(By.xpath("//*[@id='hbutton']")).click();
		}
		catch(ElementNotVisibleException e)
		{
			System.out.println("ElementNotVisibleException got handled");
		}
		
		Thread.sleep(5000);
		driver.quit();
	}
}
