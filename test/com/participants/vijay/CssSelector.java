package com.participants.vijay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static scripts.PropertyReader.getProperty;
import static utilities.Driver.setup;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CssSelector {
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", getProperty("chromeDriverPath"));
		driver = new ChromeDriver();
		String baseUrl = "https://www.wikipedia.org/";
		driver.get(baseUrl);
		
		//Tag and Id 
		WebElement element = driver.findElement(By.cssSelector("input#searchInput "));
		element.sendKeys("By Tag and Id");
		Thread.sleep(2000);
		element.clear();
		
		
		//Tag and class 
		element = driver.findElement(By.cssSelector(".link-box"));
		System.out.print(element.getText());
		Thread.sleep(2000);
		
		//Tag and Attribute 
		element = driver.findElement(By.cssSelector("input[name='search']"));
		element.sendKeys("Tag and attribute");
		Thread.sleep(2000);
		element.clear();
		
		//Multiple Attributes
		element = driver.findElement(By.cssSelector("input[id='searchInput'][name='search']"));
		element.sendKeys("Multiple Attributes");
		Thread.sleep(2000);
		element.clear();
		
//		WebElement element = driver.findElement(By.cssSelector("div[class*='langlist']:not([class*='hlist'])"));
//		System.out.print(element.getTagName());

		//Child Attribute
		element = driver.findElement(By.cssSelector("div.hide-arrow select"));
		System.out.println(element.getText());
		Thread.sleep(2000);
		
		//Starting attribute with
		element = driver.findElement(By.cssSelector("input[name^='sea']"));
		element.sendKeys("Starts With");
		Thread.sleep(2000);
		element.clear();
		
		//Ending attribute with
		element = driver.findElement(By.cssSelector("input[name$='rch']"));
		element.sendKeys("Ends With");
		Thread.sleep(2000);
		element.clear();

		//Attribute contains
		element = driver.findElement(By.cssSelector("input[name*='ar']"));
		element.sendKeys("Contains");
		Thread.sleep(2000);
		element.clear();
		
		driver.quit();
		
	}

}
