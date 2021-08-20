package com.participants.shriram;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	public static void main(String[] args) throws IOException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "Test/resources/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.yahoo.com/?.src=ym&pspid=1197806870&activity=header-signin&.lang=en-IN&.intl=in&.done=https%3A%2F%2Fin.mail.yahoo.com%2Fd");

		//waits are to wait for particular period
		
		//implicit wait will wait for particular timeout before thowing element not located exception

//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//By using the Explicit Wait command, the WebDriver is directed to wait until a certain
		//condition occurs before proceeding with executing the code.
//		WebDriverWait wait = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-username']")));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-signin']")));
		
		
		//Fluent Wait in Selenium marks the maximum amount of time for Selenium WebDriver to 
		//wait for a certain condition (web element) becomes visible.
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		WebElement email= driver.findElement(By.xpath("//input[@id='login-username']"));
		WebElement pass= driver.findElement(By.xpath("//input[@id='login-signin']"));
		email.sendKeys(PropertyReader.getProperty("username"));
		pass.click();
		driver.close();
		
	}

}
