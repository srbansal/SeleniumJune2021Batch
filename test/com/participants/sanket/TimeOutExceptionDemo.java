package com.participants.sanket;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

//import jdk.internal.org.jline.utils.Log;
//import sun.awt.www.content.audio.wav;

//Thrown when there is not enough time for a command to be completed. For Example,
//the element searched wasn't found in the specified time.

public class TimeOutExceptionDemo {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");
		
		try{

		    driver.findElement(By.xpath("//*[@value='LogIn']")).click();

		}catch (TimeoutException toe) {

		//	Wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='register']")));

			driver.findElement(By.xpath("//*[@value='LogIn']")).click();

		}catch (Exception e) {


			throw(e);

		    }

		}

	}


