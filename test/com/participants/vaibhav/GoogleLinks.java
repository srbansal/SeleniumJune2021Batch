package com.participants.vaibhav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class GoogleLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "test/resorces/chromedriver.exe");
		driver = new ChromeDriver();
		
		
		String baseUrl = "https://www.google.com/";
		driver.get(baseUrl);
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("btnK")).submit();
		List<WebElement> links;
		links=driver.findElements(By.tagName("a"));

	        for(WebElement link:links)
	        {
	            System.out.println(link.getText()+"-->"+link.getAttribute("href"));
	        		        	
	        }
	}

}
