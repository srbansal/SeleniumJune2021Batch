package com.participants.vaibhav;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementBy {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		String baseUrl = "https://www.google.com";
		System.setProperty("webdriver.chrome.driver", "test/resorces/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Selenium");
		WebElement search = driver.findElement(By.name("btnK"));
		search.submit();
		
		Thread.sleep(3000);
		driver.quit();
		

	}

}
