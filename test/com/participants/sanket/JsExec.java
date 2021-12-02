package com.participants.sanket;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JsExec {
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
	  WebDriver driver= new ChromeDriver();				
      JavascriptExecutor js = (JavascriptExecutor)driver;			
      driver.get("http://demo.guru99.com/V4/");			  	
      driver.manage().window().maximize();		
      driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);				
      long start_time = System.currentTimeMillis();				
      js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");				
      System.out.println("Passed time: " + (System.currentTimeMillis() - start_time));					            		
  }
}
