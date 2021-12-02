package script.basis;

import org.testng.annotations.Test;

import Utilities.PropertyReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class A10_WebElements {
	WebDriver driver;
	
	String driverpath=null;
	String baseUrl=null;
	String expectedTitle=null;

  
  @Test
  public void YahooTest() throws InterruptedException, IOException
  {
	  baseUrl=PropertyReader.getProperty("urlyahoo");
	  
	  driver.get(baseUrl);
	  
	  driver.manage().window().maximize();

	  WebElement login = driver.findElement(By.id("login-signin"));

		
	  boolean status = login.isDisplayed();
	  System.out.println("Displayed Status is: "+status);//true
		

      status = login.isEnabled();
	  System.out.println("Enabled Status is: "+status);//true

	  String elementType= login.getAttribute("type");//submit
	  System.out.println(elementType);

	  login.click();
	  Thread.sleep(5000);
	  
	  
  }
  
	
	
	

  
  
  
  @BeforeClass
  public void beforeClass() throws IOException
  {
	  driverpath=PropertyReader.getProperty("chromeDriverPath");
	  System.setProperty("webdriver.chrome.driver", driverpath);
	  driver=new ChromeDriver();
	  
	  
	  
  }

  @AfterClass
  public void afterClass()
  {
	  
	 // driver.quit();
  }
  
  
  
  @BeforeMethod
  public void beforeMethod()
  {
	  
	  System.out.println("Before Method : ");
  }

  @AfterMethod
  public void afterMethod()
  {
	  System.out.println("After Method : ");

  }



}




/*	
@Test
public void GoogleTest() throws IOException, InterruptedException
{
	  baseUrl=PropertyReader.getProperty("urlGoogle");
	  driver.get(baseUrl);
	  expectedTitle=PropertyReader.getProperty("expectedTitleGoogle");
	  
	  
	  driver.findElement(By.name("q")).sendKeys("https://www.flipkart.com");
	  
	  Thread.sleep(2000);
	  driver.findElement(By.name("q")).submit();
}*/
