package com.participants.kaushal;

import org.openqa.selenium.chrome.ChromeDriver;

public class A01_selemiumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("Hello");
			ChromeDriver driver;
			System.setProperty("webdriver.chrome.driver","test/resources/chromedriver.exe");
			driver=new ChromeDriver();
			String s="https://www.google..com";
			driver.get(s);
			String actualTitle =driver.getTitle();
			String expectedUrl="Google";
			if(actualTitle.equals(expectedUrl)) {
				
			System.out.println("Title Matched :TC PASSED");	
			}else {
				
				System.out.println("Title Matched :TC FAILED");
			}
	}

}
