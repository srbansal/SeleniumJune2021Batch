package com.participants.vaibhav;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooLogin {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		System.setProperty(PropertyReader.getProperties("cKey"), PropertyReader.getProperties("cValue"));
		driver = new ChromeDriver();
		
		
		String baseUrl = "https://in.yahoo.com/";
		driver.get(baseUrl);
		driver.findElement(By.className("_yb_zl0iu")).click();
		driver.findElement(By.id("login-username")).sendKeys(PropertyReader.getProperties("email"));
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("password")).sendKeys(PropertyReader.getProperties("pass"));
		driver.findElement(By.id("login-signin")).click();
		try {
			if(!driver.findElement(By.id("ybarMailLink")).getText().isEmpty()) {
				System.out.println("Login success");
			}	
			driver.close();
		} catch (Exception e) {
			System.out.println("Login Failed");
			driver.close();
	
		}

	}

}
