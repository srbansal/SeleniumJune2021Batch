package com.participants.vijay;

import static scripts.PropertyReader.getProperty;
import static utilities.Driver.setup;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath {
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", getProperty("chromeDriverPath"));
		driver = new ChromeDriver();
		String baseUrl = getProperty("baseUrl");
		driver.get(baseUrl);
		
		//Standard xpath
		WebElement element = driver.findElement(By.xpath("//input[@id='searchInput']"));
		element.sendKeys("Standard Expath");
		Thread.sleep(2000);
		element.clear();
		
		//xpath contains
		element = driver.findElement(By.xpath("//input[contains(@id, 'arch')]"));
		element.sendKeys("Contains");
		Thread.sleep(2000);
		element.clear();
		
		//xpath starts with
		element = driver.findElement(By.xpath("//input[starts-with(@id, 'sear')]"));
		element.sendKeys("Starts With");
		Thread.sleep(2000);
		element.clear();
		
		//xpath text
		element = driver.findElement(By.xpath("//span[@text()='Read Wikipedia in your language ']"));
		element.sendKeys("Ends With");
		Thread.sleep(2000);
		element.clear();
		
		//Xpath And Condition
		element = driver.findElement(By.xpath("//input[@id='searchInput' and @name='search']"));
		element.sendKeys("Xpath And");
		Thread.sleep(2000);
		element.clear();
		
		//Xpath Or Condition 
		element = driver.findElement(By.xpath("//input[@id='searchInput' or @name='search']"));
		element.sendKeys("Xpath Or");
		Thread.sleep(2000);
		element.clear();
		
//		element = driver.findElement(By.xpath("//a[@href='https://en.wikipedia.org']"));
//		System.out.println(element.getText());
		
		//Following nodes of current node
		element = driver.findElement(By.xpath("//*[@type='search']//following::div"));
		System.out.println(element.getText());
		
		//Ancestor of current node (Parent, Grand Parent)
		element = driver.findElement(By.xpath("//*[@type='search']//ancestor::div"));
		System.out.println(element.getText());
		
		//Children of current node
		element = driver.findElement(By.xpath("//*[@id='searchLanguage']//child::option[2]"));
		System.out.println(element.getText());

		//Select all nodes before current node
		element = driver.findElement(By.xpath("//*[@id='searchLanguage']//preceding::div"));
		System.out.println(element.getText());

		//Following nodes of the current node (same level)
		element = driver.findElement(By.xpath("//*[@id='searchLanguage']//following-sibling::div"));
		System.out.println(element.getText());

		//Parent node of current node 
		element = driver.findElement(By.xpath("//*[@id='searchLanguage']//parent::div"));
		System.out.println(element.getText());
		
		//Descendants(children, grand children) of current node 
		element = driver.findElement(By.xpath("//*[@id='searchLanguage']//descendant::option[1]"));
		System.out.println(element.getText());
		
		driver.quit();
	}

}
