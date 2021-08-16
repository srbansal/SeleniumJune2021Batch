
/*
 *-search for firefox browser driver
-Code for chrome & firefox using properties
 CH FF
 * */


package scripts.basics;

import java.util.Scanner;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WikiTest {
	
	
	
	static void DriverOps(WebDriver driver) throws IOException, InterruptedException {

		String baseURL = PropertyReader.getProperties("wiki");
		driver.get(baseURL);
		System.out.println("Title of current page :"+driver.getTitle());
		driver.findElement(By.id("js-link-box-en")).click();
		System.out.println("Title of current page :"+driver.getTitle());
		driver.findElement(By.name("search")).sendKeys("Selenium");
		driver.findElement(By.name("go")).submit();
		System.out.println("Title of current page :"+driver.getTitle());
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	
	static void driverSelector() throws IOException, InterruptedException{
		WebDriver driver;
		Scanner sc = new Scanner(System.in);

		
		System.out.println("For ChromeBrowser type CH \nFor ChromeBrowser type FF");
		String Browser = sc.nextLine();
		if (Browser.equals("CH")) {
			System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			DriverOps(driver);

		} else if (Browser.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "test/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			DriverOps(driver);

		} else {
			System.out.println("Invalid Input");
		}

		sc.close();
		
	}
	
	
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		driverSelector();
		
	}
}


