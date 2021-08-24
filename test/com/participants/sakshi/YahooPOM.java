package com.participants.sakshi;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YahooPOM {
	WebDriver driver;
	
	By username = By.id("login-username");
	By signin = By.id("login-signin");
	By password = By.id("login-passwd");
	
	public YahooPOM (WebDriver driver){

        this.driver = driver;
	}
	
	public void setUserName() throws Exception{

        driver.findElement(username).sendKeys(PropertyReader.getProperties("YahooMail"));

    }

	public void setPassword() throws Exception{

        driver.findElement(password).sendKeys(PropertyReader.getProperties("YahooPwd"));

    }
	
	public void signin(){

		driver.findElement(signin).submit();

    }
}
