package com.persistent.vaibhav;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

	public class JScriptExecutor {
		public static void main(String[] args) throws IOException, InterruptedException {
			WebDriver driver;
			System.setProperty(PropertyReader.getProperties("cKey"),PropertyReader.getProperties("cValue"));
			driver = new ChromeDriver();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String baseURL = PropertyReader.getProperties("baseURL");
			driver.get(baseURL);

			if (driver instanceof JavascriptExecutor) { 
				js.executeScript("arguments[0].click();",
				driver.findElement(By.name("btnI")));
				Thread.sleep(2000);
	            js.executeScript("window.scrollBy(0,700)");
	            Thread.sleep(2000);
	            js.executeScript("alert('hello world');");
	            Thread.sleep(2000);
			}
			
		}
	}
