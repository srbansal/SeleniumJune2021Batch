package scipts.basics;

import org.testng.annotations.Test;

import com.fileHandle.PropertyReader;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;


public class TestNGClass {
	
	String baseUrl=null;
	String expectedTitle= null;
	String browserType=null;
	WebDriver driver=null;
	
	public void GoogleTest() {
		 baseUrl=PropertyReader.getProperty("Googleurl");
		 expectedTitle= PropertyReader.getProperty("expectedTitleGoogle");
		
		driver.get(baseUrl);
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Title Matched:TC passed");
		}
		else {
			System.out.println("Title NOT Matched:TC Failed");
		}
		assertEquals(expectedTitle,actualTitle);
		
	}
	
	public void WikipediaTest() {
		
			baseUrl=PropertyReader.getProperty("Wikiurl");
		    expectedTitle= PropertyReader.getProperty("expectedTitleWiki");
			driver.get(baseUrl);
			String actualTitle=driver.getTitle();
			String expectedHeading=PropertyReader.getProperty("expectedHeading");
			if(expectedTitle.equals(actualTitle)) {
				System.out.println("Title Matched:TC passed");
			}
			else {
				System.out.println("Title NOT Matched:TC Failed");
			}
			assertEquals(expectedTitle,actualTitle);
			
			driver.findElement(By.id("searchInput")).sendKeys("selenium");;
			driver.findElement(By.name("search")).submit();
			String heading=driver.findElement(By.id("firstHeading")).getText();
			if(expectedHeading.equals(heading)) {
				System.out.println("Heading Matched:TC passed");
			}
			else {
				System.out.println("Heading NOT Matched:TC Failed");
			}
			
			assertEquals(expectedHeading,heading);
		
	}
  @Test
  public void Test() {
	  GoogleTest();
	  //WikipediaTest();	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  	
	  	String browserType=PropertyReader.getProperty("browser");
		String DiverPath=PropertyReader.getProperty("chromeDriverPath");
		System.setProperty("webdriver.chrome.driver", DiverPath);
		driver=new ChromeDriver();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
