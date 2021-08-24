package com.participants.sanket;

import org.testng.annotations.Test;
import utilities.PropertyFileReader;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.annotations.AfterClass;

public class Browser {
	WebDriver driver;
	String baseUrl = null;
	String expectedTitle = null;
	String urlWiki = null;
	String urlGoogle = null;
  @Test
  public void f() throws IOException, InterruptedException{

      urlGoogle = PropertyFileReader.getProperties("urlgoogle");
      
      FirefoxOptions options = new FirefoxOptions();
	  ProfilesIni profile = new ProfilesIni();
	  FirefoxProfile myprofile = profile.getProfile("xyzProfile");
	  options.setProfile(myprofile);
	  WebDriver driver = new FirefoxDriver(options);
      
	  driver.get(urlGoogle);
                 
	  Thread.sleep(2000);
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", "test/resources/geckodriver.exe");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
