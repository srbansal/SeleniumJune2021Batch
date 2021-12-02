package com.participants.sanket;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//This Selenium exception occurs happens when the web element is detached from the current DOM.

public class StaleElementReferenceExceptionDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");
		
		WebElement linkElement=driver.findElement(By.xpath("//*[@id='link1']"));
		linkElement.click();
		driver.navigate().back();
		try {
			linkElement.click();
		}
		catch(StaleElementReferenceException e)
		{System.out.println("StateElementReferenceException got handled");}
		driver.quit();


	}

}
