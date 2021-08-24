package com.persistent.vaibhav;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Aug_12 {
	private WebDriver driver;

	@Test
  public void amazonTagName() throws IOException {
	  System.out.println("Inside Function");
	  driver.manage().window().maximize();
	  driver.get(PropertyReader.getProperties("amazon"));
	  List <WebElement> links = driver.findElements(By.tagName("a"));
	  
	  for(WebElement link:links) {
		  System.out.println(link.getText()+"-->"+link.getAttribute("href"));
	  }
	  
  }

	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("before class");
		System.setProperty(PropertyReader.getProperties("cKey"), PropertyReader.getProperties("cValue"));
		driver = new ChromeDriver();

	}

	@AfterClass
	public void afterClass() {
		System.out.println("after class");
	}

}
