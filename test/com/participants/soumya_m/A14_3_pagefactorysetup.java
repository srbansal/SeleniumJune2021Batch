package com.participants.soumya_m;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.selenium.A14_1_homepagefactory;
import com.selenium.A14_2_signuppagefactory;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class A14_3_pagefactorysetup {
	String driverPath = "chromedriver1.exe";
	WebDriver driver;
	A14_1_homepagefactory objBrowserStackHomePage;
	A14_2_signuppagefactory objBrowserStackSignUpPage;
	@BeforeTest
	public void setup() {
	System.setProperty("webdriver.chrome.driver", "chromedriver1.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.browserstack.com/");
	}

	@Test(priority = 1)
	public void navigate_to_homepage_click_on_getstarted() {
	objBrowserStackHomePage = new A14_1_homepagefactory(driver);
	objBrowserStackHomePage.veryHeader();
	objBrowserStackHomePage.clickOnGetStarted();
	}

	@Test(priority = 2)
	public void enter_userDetails() {
	objBrowserStackSignUpPage = new A14_2_signuppagefactory(driver);
	objBrowserStackSignUpPage.veryHeader();
	objBrowserStackSignUpPage.enterFullName("TestUser");
	objBrowserStackSignUpPage.enterBusinessEmail("TestUser@gmail.com");
	objBrowserStackSignUpPage.enterPasswrod("TestUserPassword");
	}
}
