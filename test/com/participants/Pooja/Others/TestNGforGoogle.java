package com.participants.Pooja.Others;

import org.testng.annotations.Test;

import utilities.PropertyReader;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestNGforGoogle {
	 WebDriver driver;
  @Test
  public void TestGoogle() throws IOException {
	  String baseUrl=PropertyReader.getProperty("url");
	  driver=new ChromeDriver();
	  driver.get(baseUrl);

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
  @BeforeMethod
  public void beforeMethod() throws IOException {
	 
	 String ChromeDriverPath=PropertyReader.getProperty("ChromeDriverPath");
	 System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
	
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
