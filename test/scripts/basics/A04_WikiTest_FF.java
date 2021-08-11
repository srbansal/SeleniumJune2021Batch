package scripts.basics;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utilities.PropertyReader;

public class A04_WikiTest_FF {

	public static void main(String[] args) throws IOException, InterruptedException  {
		WebDriver driver;
		String baseUrl=null;
		String expectedTitle=null;
		String driverPath=null;
		
		baseUrl = PropertyReader.getProperty("urlWiki");
		expectedTitle = PropertyReader.getProperty("expectedTitleWiki");
		driverPath = PropertyReader.getProperty("geckoDriverPath");
		
		
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();	
		
		driver.get(baseUrl); 
		
//		---------------------------------------------
		
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(expectedTitle))
			System.out.println("Title matched: TC Passed");
		else
			System.out.println("Title not matched: TC failed");
		
		driver.findElement(By.id("js-link-box-en")).click();
		driver.findElement(By.id("searchInput")).sendKeys("Selenium");
		driver.findElement(By.id("searchButton")).click();
		
		if(driver.getTitle().contains("Selenium"))
			System.out.println("Title matched for SE");
		else
			System.out.println("Title matched did not match for SE");
		
		String heading = driver.findElement(By.id("firstHeading")).getText();
		if(heading.equals("Selenium1"))
			System.out.println("Heading matched");
		else
			System.out.println("Heading did not match");
		
		Thread.sleep(2000);
		driver.quit();	// close the browser
	}

}
