package com.participants.sanket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLess {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	  System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
	  ChromeOptions options = new ChromeOptions();
	  options.setHeadless(true);
	  WebDriver driver = new ChromeDriver(options);
	  driver.get("https://www.google.com");
	  System.out.println(driver.getTitle());
	  Thread.sleep(2000);
	  driver.close();
	}

}
