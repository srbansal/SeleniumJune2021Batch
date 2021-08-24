package script.basis;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.PropertyReader;

public class A02_MyFirstSeleniumTest_PropertyFile {


	public static void main(String[] args) throws InterruptedException
	{
		//System.out.println("Hello Selenium(SE)");
		WebDriver driver;
		
		String baseUrl=null;
		String expectedTitle = null;
		String chromeDriverPath = null;
		try {
			baseUrl = PropertyReader.getProperty("url");
			expectedTitle = PropertyReader.getProperty("expectedTitle");
			chromeDriverPath = PropertyReader.getProperty("chromeDriverPath");
			} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver=new ChromeDriver();
		driver.get(baseUrl);   // visit the url/pages
		
		String actualTitle=driver.getTitle();
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Title Matched: TC Passed");
		}
		else
		{
			System.out.println("Title NOT Matched: TC Failed");
		}
		
		Thread.sleep(2000);
		driver.quit();
		
		System.out.println(driver.getTitle());
	}
	
	
}
