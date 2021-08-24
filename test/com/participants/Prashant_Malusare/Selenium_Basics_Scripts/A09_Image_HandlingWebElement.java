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

public class A11_Image_HandlingWebElement {
	WebDriver driver;
	
	String driverpath=null;
	String baseUrl=null;
	String expectedTitle=null;
  @Test
  public void GoogleTest() throws IOException, InterruptedException {
	  baseUrl=PropertyReader.getProperty("urlGoogle");
	  driver.get(baseUrl);
	  expectedTitle=PropertyReader.getProperty("expectedTitleGoogle");
	  driver.manage().window().maximize();

	  
	  
	  //Return the ‘Google Image’ Title
	  String title = driver.findElement(By.id("hplogo")).getAttribute("title");
	  System.out.println(title);
		
	  //Handling Image Link
	  /*• Check Displayed Status
		• Check Enabled Status
		• Click*/

	  driver.get("https://www.selenium.dev/");
	  WebElement testBirds = driver.findElement(By.xpath("/html/body/div/main/div[3]/div[1]/a/img"));
	
	  System.out.println(testBirds.isDisplayed());//true

	  System.out.println(testBirds.isEnabled());//true

	  testBirds.click();
	  Thread.sleep(3000);

  }
  
  
  

	




	
  
  
  
  
  
  @BeforeClass
  public void beforeClass() throws IOException 
  {
	  driverpath=PropertyReader.getProperty("chromeDriverPath");
	  System.setProperty("webdriver.chrome.driver", driverpath);
	  driver=new ChromeDriver();
	  
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method : ");

  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method : ");

  }



}
