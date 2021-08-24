package com.participants.sakshi;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class YahooPOMTest {
	WebDriver driver;
	YahooPOM YP;

	@Test
	public void f() throws Exception {
		YP = new YahooPOM(driver);
		YP.setUserName();
		YP.signin();
		YP.setPassword();
		YP.signin();
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://login.yahoo.com");
	}

}
