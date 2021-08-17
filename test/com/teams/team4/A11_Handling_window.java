package com.teams.team4;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.fileHandle.PropertyReader;

public class A11_Handling_window {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//String urlGoogle=PropertyReader.getProperty("Googleurl");
		//String expectedTitle= PropertyReader.getProperty("expectedTitle");
		String browserType=PropertyReader.getProperty("browser");
		WebDriver driver=null;
		
		if(browserType.equals("CH")) {
			String DiverPath=PropertyReader.getProperty("chromeDriverPath");
			System.setProperty("webdriver.chrome.driver", DiverPath);
			driver=new ChromeDriver();
		}
		else if(browserType.equals("FF")){
			String DiverPath=PropertyReader.getProperty("firefoxDriverPath");
			System.setProperty("webdriver.gecko.driver", DiverPath);
			driver=new FirefoxDriver();
		}
		
		
		driver.get("https://html.com/input-type-file/");			
        driver.manage().window().maximize();		
        Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@id='fileupload']")).sendKeys("C:\\Users\\DELL\\Desktop\\tan\\photo.pdf");
       Thread.sleep(10000);
        		driver.close();
	}

}
