package com.participants.sanket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//visit google home page -> find by tag with findelements ->
//store in list -> print all in console
public class GoogleAnchor {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
         WebDriver driver;
         System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
 		 driver=new ChromeDriver();
 		 driver.get("https://www.google.com");
 		 
 		 WebElement element = driver.findElement(By.name("q"));
 		 element.sendKeys("selenium");
 		 
 		 WebElement btnSubmit = driver.findElement(By.name("btnK"));
 		 btnSubmit.submit();
 		 
 		 WebElement getSingleAnchor = driver.findElement(By.tagName("a"));
 		 System.out.println(getSingleAnchor.getText());
 		 
 		 List<WebElement> getAllAnchor = driver.findElements(By.tagName("a"));
 		 for(WebElement elements : getAllAnchor) {
 			System.out.println(elements.getAttribute("href")+" "+elements.getText());
 		 }
		 
 		 Thread.sleep(2000);
 		 driver.quit();
	}

}
