package com.participants.vaibhav;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaActivity {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader reader = new FileReader("test/resorces/my.properties");
		Properties p = new Properties();
		p.load(reader);
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "test/resorces/chromedriver.exe");
		driver = new ChromeDriver();
		
		
		String baseUrl = "https://www.wikipedia.org/";
		driver.get(baseUrl);
		
		driver.findElement(By.id("js-link-box-en")).click();
		driver.findElement(By.name("search")).sendKeys("selenium");
		driver.findElement(By.name("go")).click();
		String heading = driver.findElement(By.id("firstHeading")).getText();	
		
		if(heading.equals("Selenium")) {
			System.out.println("Heading Matched...");
		}else {
			System.out.println("Heading NOT Matched...");
		}
		driver.quit();
		

	}

}
