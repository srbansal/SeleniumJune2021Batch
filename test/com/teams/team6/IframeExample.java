package com.teams.team6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class IframeExample {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "G:\\Persistent Systems 28-06-2021\\Training\\Java Basics -27-7\\Projects\\SeleniumWebDriver\\test\\resources\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://docs.oracle.com/javase/7/docs/api/");
		driver.manage().window().maximize();
		
		//Interacting with the element inside iframe
		
		//FIRST FRAME
		driver.switchTo().frame("packageListFrame");//name of the frame
		driver.findElement(By.linkText("java.applet")).click();
		Thread.sleep(3000);
		/*driver.switchTo().defaultContent();
	
		Thread.sleep(3000);
		//2ND FRAME
		driver.switchTo().frame("packgeFrame");
		driver.findElement(By.linkText("AppletContext")).click();
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		
		//3rd FRAME
		driver.switchTo().frame("classFrame");
		driver.findElement(By.linkText("Tree")).click();
		
		Thread.sleep(6000);*/
		driver.quit();
		
		
	}

}
