package com.participants.soumya_m;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.selenium.A13_1_pomhomepage;
import com.selenium.A13_2_pomsignuppage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class A13_3_pomsetup {
	String driverPath = "chromedriver1.exe";
	WebDriver driver;
	A13_1_pomhomepage objBrowserStackHomePage;
	A13_2_pomsignuppage objBrowserStackSignUpPage;
  @Test
	  public void navigate_to_homepage_click_on_getstarted() {
		  objBrowserStackHomePage = new A13_1_pomhomepage(driver);
		  objBrowserStackHomePage.veryHeader();
		  objBrowserStackHomePage.clickOnGetStarted();
		  }

  
  @BeforeMethod
  public void setup() {
	  System.setProperty("webdriver.chrome.driver", "chromedriver1.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://www.browserstack.com/");
  }

  @Test(priority = 2)
  public void enter_userDetails() {
objBrowserStackSignUpPage = new A13_2_pomsignuppage(driver);
   objBrowserStackSignUpPage.veryHeader();
 objBrowserStackSignUpPage.enterFullName("TestUser");
 objBrowserStackSignUpPage.enterBusinessEmail("TestUser@gmail.com");
 objBrowserStackSignUpPage.enterPasswrod("TestUserPassword");
  
  }

}
