package com.participants.sanket;

import org.testng.annotations.Test;

import utilities.PropertyFileReader;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.annotations.AfterTest;

public class BeforeAfterTest {
	WebDriver driver;
	String baseUrl = null;
	String expectedTitle = null;
	String urlWiki = null;
	String urlGoogle = null;
	
  @Test(description="Google Home Pages")
  public void f() throws Exception{
     urlGoogle = PropertyFileReader.getProperties("urlgoogle");
      
      FirefoxOptions options = new FirefoxOptions();
	  ProfilesIni profile = new ProfilesIni();
	  FirefoxProfile myprofile = profile.getProfile("xyzProfile");
	  options.setProfile(myprofile);
	  driver = new FirefoxDriver(options);
      
	  driver.get(urlGoogle);
                 
	  Thread.sleep(2000);
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", "test/resources/geckodriver.exe");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
