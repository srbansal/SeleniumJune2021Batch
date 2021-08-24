package com.participants.kaushal;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileReader1 {

	private static ChromeDriver chromeDriver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s="files/info";
       getProperty(s);
	}
	public static void getProperty(String url) {
		try {
			FileReader reader=new FileReader(url);
			Properties p=new Properties();
			p.load(reader);
			System.out.println(p.getProperty("url"));
			System.out.println(p.getProperty("browser"));
			System.out.println(p.getProperty("email"));
			System.out.println(p.getProperty("password"));
			ChromeDriver driver;
			System.setProperty("webdriver.chrome.driver","test/resources/chromedriver.exe");
			driver=new ChromeDriver();
		driver.get("https://login.yahoo.com/");
			
			WebElement element= driver.findElement(By.name("username"));
			 element.sendKeys("kaushaldigraskar@yahoo.com");
			 element.submit();
			 Thread.sleep(2000);
			 driver.findElement(By.className("password")).sendKeys("123@456persistent");
			 driver.findElement(By.id("login-signin")).click();
//			element.sendKeys(Keys.ESCAPE);
//			element.sendKeys(Keys.TAB);
			 
//			List actualTitle =((ArrayList) driver.findElements(By.tagName("div")));
		String expectedUrl="Selenium";
//		List<WebElement> allLinks = driver.findElements(By.tagName("div"));
//		System.out.println("Links count is: "+allLinks.size());
//		for(WebElement link : allLinks)
//		System.out.println(link.getText());
		
//			if(actualTitle.equals(expectedUrl)) {
//				
//			System.out.println("Title Matched :TC PASSED");	
//			}else {
//				
//				System.out.println("Title Matched :TC FAILED");
//				System.out.println("Title was :"+actualTitle);
//			}
//			for (int i = 0; i < actualTitle.size(); i++) {
//				System.out.println(actualTitle.get(i).toString());
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
