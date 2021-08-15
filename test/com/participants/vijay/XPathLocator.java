package com.participants.vijay;

import static scripts.PropertyReader.getProperty;
import static utilities.Driver.setup;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XPathLocator {
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		WebDriver driver = setup("FF");
		String baseUrl = "http://cookbook.seleniumacademy.com/Config.html";
		driver.get(baseUrl);
		
		WebElement element = driver.findElement(By.xpath("//select[@name='make']//child::option[2]"));
		element.click();
		Thread.sleep(2000); 
		
		element = driver.findElement(By.xpath("//input[@name='fuel_type' and @value='Diesel']"));
		element.click();
		Thread.sleep(2000);
		
		List<WebElement> elements = driver.findElements(By.xpath("//select[@name='make']//following::input[@value='Petrol']"));
		for(WebElement el: elements) {
			System.out.print(el.getAttribute("value"));
		}
		

		driver.quit();
	}
}
