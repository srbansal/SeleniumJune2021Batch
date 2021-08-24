package com.participants.sanket;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//This Exception occurs if an element could not be found.

public class NoSuchElementExceptionDemo {

	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://in.yahoo.com/");
		
		try {
			driver.findElement(By.xpath("//*[@id='xyz']")).click();
		}
		catch(NoSuchElementException e) {
			System.out.println("Handled NoSuchElementException");
			
		}
		Thread.sleep(2000);
		driver.quit();

	}

}
