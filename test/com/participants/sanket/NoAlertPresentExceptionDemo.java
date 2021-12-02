package com.participants.sanket;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//This Exception occurs when you switch to no presented alert.

public class NoAlertPresentExceptionDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");
		//driver.findElement(By.xpath("//*[@id='alert1']")).click();
		try {
			driver.switchTo().alert();
		}
		catch(NoAlertPresentException e)
		{
			System.out.println("NoAlertPresentException got handled");
		}
		
		Thread.sleep(2000);
		driver.quit();

	}

}
