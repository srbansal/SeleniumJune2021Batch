package com.participants.Pooja.Others;

import java.util.List;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.PropertyReader;

public class SeleniumWebdriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		 String baseUrl = null;
		 String ChromeDriverPath = null;
		 try{
			baseUrl=PropertyReader.getProperty("url");
			 ChromeDriverPath=PropertyReader.getProperty("ChromeDriverPath");
		 }
		 catch(IOException e)
		 {
			 e.printStackTrace();
		 }
		 
		 System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
			driver=new ChromeDriver();
			driver.get(baseUrl);
			
		//WebElement elements = (WebElement) driver.findElements(By.tagName("a"));
		
		List <WebElement> links = driver.findElements(By.tagName("a"));
		
		   if(links.size() != 0) 
		   {
			   System.out.println(links.size() + " Elements found by TagName as a \n");
				
			   for(WebElement link : links) 
			   {
				   System.out.println(link.getText()+" "+link.getAttribute("href"));
			   }
		   }
			
	}

}
