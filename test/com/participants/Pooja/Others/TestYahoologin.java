package com.participants.Pooja.Others;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.PropertyReader;

public class TestYahoologin {
	
	public static void Validationchrome(String baseUrl,String username,String password) throws InterruptedException {
	WebDriver driver;
	driver=new ChromeDriver();
	driver.get(baseUrl);

	driver.findElement(By.id("login-username")).sendKeys(username);
	driver.findElement(By.id("login-signin")).click();
	Thread.sleep(4000);
	driver.findElement(By.id("login-passwd")).sendKeys(password);
	driver.findElement(By.id("login-signin")).click();
	
	String profilename=driver.findElement(By.id("ybarAccountMenuOpener")).getText();
	
	if(username.startsWith(profilename))
	{
		System.out.println("Login successfully");
	}
	else
	{
		System.out.println("Login failed");
	}
	
	
}
	public static void ValidationFF(String baseUrl,String username,String password) throws InterruptedException {
		
		WebDriver driver;
		driver=new FirefoxDriver();
		
		driver.get(baseUrl);
		Thread.sleep(2000);
		driver.findElement(By.id("login-username")).sendKeys(username);
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("login-passwd")).sendKeys(password);
		driver.findElement(By.id("login-signin")).click();
		
		String profilename=driver.findElement(By.id("ybarAccountMenuOpener")).getText();
		
		if(username.startsWith(profilename))
		{
			System.out.println("Login successfully");
		}
		else
		{
			System.out.println("Login failed");
		}
		
		
	}
	public static void ValidationEgde(String baseUrl,String username,String password) throws InterruptedException {
		
		 
		 WebDriver driver = new EdgeDriver();
		
		driver.get(baseUrl);
		Thread.sleep(2000);
		driver.findElement(By.id("login-username")).sendKeys(username);
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("login-passwd")).sendKeys(password);
		driver.findElement(By.id("login-signin")).click();
		
		String profilename=driver.findElement(By.id("ybarAccountMenuOpener")).getText();
		
		if(username.startsWith(profilename))
		{
			System.out.println("Login successfully");
		}
		else
		{
			System.out.println("Login failed");
		}
		
		
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//WebDriver driver;
		Scanner sc=new Scanner(System.in);
		 String baseUrl = "https://login.yahoo.com/";
		 String ChromeDriverPath = null;
		 String username=null;
		 String password=null;
		 String FFDriverPath=null;
		String EdgeDriverPath=null;
		 try{
			 username = PropertyReader.getProperty("username");
			password=PropertyReader.getProperty("password");
			ChromeDriverPath=PropertyReader.getProperty("ChromeDriverPath");
			FFDriverPath=PropertyReader.getProperty("FFDriverPath");
			EdgeDriverPath=PropertyReader.getProperty("EdgeDriverPath");
		 }
		 catch(IOException e)
		 {
			 e.printStackTrace();
		 }
		 int ch2 = 0;
		 do {
		 System.out.println("Select Browser to test");
		 System.out.println("1.Chrome");
		 System.out.println("2.FireFox");
		 System.out.println("3.Microdoft Edge");
		 int ch=sc.nextInt();
		
		 switch(ch)
		 {
		 case 1:  System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		 					Validationchrome(baseUrl,username,password);
		 					break;
		 case 2: System.setProperty("webdriver.gecko.driver", FFDriverPath);
		 			ValidationFF(baseUrl,username,password);
					break; 
		 case 3: System.setProperty("webdriver.edge.driver", EdgeDriverPath);
		 			ValidationEgde(baseUrl,username,password);
			 	    break;
		 default: System.out.println("Invalid input");
		 }
		 System.out.println("Do you want to continue(y=1/n=0");
		 ch2=sc.nextInt();
		 }while(ch2==1);
		 
			
			
			
			
			
	}

}
