package com.teams.team5.webelements;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.PropertyReader;

public class Handling_TextBoxAndLinks {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver;
		String username = "poojashitole@yahoo.com";
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		
		System.out.println("Handling Text Box \n");
		driver=new ChromeDriver();
		  driver.manage().window().maximize();

			 String baseUrl1 = "https://login.yahoo.com/";

		driver.get(baseUrl1);
			WebElement user_name= driver.findElement(By.id("login-username"));
			boolean status = user_name.isDisplayed();
			System.out.println("Displayed Staus is: "+status);//true

			status = user_name.isEnabled();
			System.out.println("Enabled Staus is: "+status);//true
			
			user_name.sendKeys(username);// Enter text to text field 
			Thread.sleep(5000);
		    String typeofInput = user_name.getAttribute("type");
			System.out.println("Input Type: "+ typeofInput);//text
			
			user_name.clear(); // clear Text box
			
			Thread.sleep(5000);

			user_name.sendKeys("ABCD123");
			Thread.sleep(2000);

			String val = user_name.getAttribute("value"); // get the value
			System.out.println("Attribute value enter: " +val);//ABCD123
			
			System.out.println("-------------------------------------------------------------");
			
			System.out.println("Handling Links\n");
			
			driver.navigate().to("https://www.google.com/"); 
			driver.manage().window().maximize();

			WebElement gmail = driver.findElement(By.linkText("Gmail"));

			Thread.sleep(1000);
			boolean status1 = gmail.isDisplayed();
			System.out.println("Displayed Staus is: "+status1);//true

			status1 = gmail.isEnabled();
			System.out.println("Enabled Staus is: "+status1);//true
			Thread.sleep(3000);
			String linkName = gmail.getText();
			String link=gmail.getAttribute("href");
	    	System.out.println("Link Name: "+linkName);
	    	System.out.println("Link: "+link);

	        gmail.click();
	        
	        
				

	}

}
