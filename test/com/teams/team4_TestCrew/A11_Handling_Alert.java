package com.teams.team4;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.fileHandle.PropertyReader;

public class A11_Handling_Alert {

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
		
		//url
		driver.get("http://demo.guru99.com/test/delete_customer.php");			
		
	      	
        driver.findElement(By.name("cusid")).sendKeys("53920");	//locating by id ann sending keys				
        driver.findElement(By.name("submit")).submit();					
              
        Alert alert = driver.switchTo().alert();// Switching to alert popup		
        		
            
        String alertMessage= driver.switchTo().alert().getText();	// getting text present in alert dailogue box	
        		
        
        System.out.println(alertMessage);	
        Thread.sleep(5000);
        		
        alert.accept();//Accepting alert message
		
        driver.close();
	}

}
