package scripts.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A01_MyFirstSeleniumTest {

	public static void main(String[] args) throws InterruptedException {
//		System.out.println("Hello Selenium (SE)");		
		WebDriver driver;
		String baseUrl = "https://www.google.com/";
		String expectedTitle = "Google";
		
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
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
		
		Thread.sleep(2000);
		driver.close(); // only current tab gets closed
//		driver.get(baseUrl);	// not allowed after close/ quit
//		driver.quit();	// close the browser
		System.out.println(driver.getTitle()); // not allowed after close/ quit
	}

}
