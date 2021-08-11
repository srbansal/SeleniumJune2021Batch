package scripts.basics;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.PropertyReader;

public class A02_MyFirstSeleniumTest_ProperyFile {

	public static void main(String[] args) throws IOException, InterruptedException  {
//		System.out.println("Hello Selenium (SE)");		
		WebDriver driver;
		String baseUrl=null;
		String expectedTitle=null;
		String chromeDriverPath=null;
		
		baseUrl = PropertyReader.getProperty("url");
		expectedTitle = PropertyReader.getProperty("expectedTitle");
		chromeDriverPath = PropertyReader.getProperty("chromeDriverPath");
		
		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();	// Create a new instance of ChromeDriver (Browser) and launch the browser
		
		driver.get(baseUrl); // visit the url/ page
		
		String actualTitle = driver.getTitle();	// fetch the title of current page	
		
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Title Matched: TC Passed");
		}
		else
		{
			System.out.println("Title NOT Matched: TC Failed");
		}
//		---------------------------------------------
		
		 WebElement element = driver.findElement(By.name("q"));
		 element.sendKeys("Selenium");
//		 element.sendKeys(Keys.ESCAPE);
		 element.sendKeys(Keys.TAB);
		 
//		 driver.findElement(By.name("btnK")).click();
		 driver.findElement(By.name("btnK")).submit();
		 

		 
		 
		 
//		String
//		WebElement
		
		
		Thread.sleep(2000);
		driver.quit();	// close the browser
	}

}
