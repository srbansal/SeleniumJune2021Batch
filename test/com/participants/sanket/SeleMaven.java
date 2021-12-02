package com.participants.sanket;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.PropertyFileReader;

public class SeleMaven {
	public static void main(String[] args) throws Exception{
		System.out.println("Hello");
		WebDriver driver;
//		String baseUrl = PropertyFileReader.getProperties("baseUrl");
//		String title = PropertyFileReader.getProperties("title");
//		driver.get("https://www.google.com");
		String expectedTitle = "Selenium - Wikipedia";
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		driver=new ChromeDriver();

		driver.get("https://www.wikipedia.org");
		
		WebElement element = driver.findElement(By.name("search"));
		element.sendKeys("Selenium");
		WebElement search = driver.findElement(By.className("pure-button") );
		search.click();
		String title = driver.getTitle();
		if(title.equals(expectedTitle)) {
			System.out.println("Tc Passed");
		}else {
			System.out.println("Tc Not Passed");
		}
//		search.submit();
//		WebElement search = driver.findElement(By.name("btnK"));
        
        
		Thread.sleep(2000);
		driver.quit();
	}
}