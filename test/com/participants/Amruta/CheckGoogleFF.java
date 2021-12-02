package com.participants.Amruta;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckGoogleFF {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		
		WebDriver Driver;
		System.out.println("using firefox driver");
		System.out.println("hello Google)");

		String baseURL="https://www.google.com/";
		
		System.setProperty("webdriver.gecko.driver","test/resources/geckodriver.exe");
		Driver=new FirefoxDriver();
		
		Driver.get(baseURL);
		WebElement ele= Driver.findElement(By.name("q"));
		ele.sendKeys("google login");
		ele.sendKeys(Keys.ENTER);
		//ele.submit();
		
		

		
		//Thread.sleep(2000);
		
		//Driver.quit();
		
	}

}
