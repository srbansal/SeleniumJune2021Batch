
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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class MultiDriver {
	static void DriverCall(WebDriver driver) throws IOException, InterruptedException {
		Thread.sleep(2000);
		String expectedTitle = "Google";
//		driver.get("https://www.google.com/");
		String baseURL = PropertyReader.getProperties("baseURL");

		System.out.println("baseURL = " + baseURL);

		driver.get(baseURL);
		System.out.println(driver.getTitle());
		String actualTitle = driver.getTitle();

		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Title Matched!");
		} else {
			System.out.println("Tital Not Matched!");
		}
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("btnK")).submit();
		
//		driver.findElement(By.name("q")).sendKeys("Selenium");
//		driver.findElement(By.name("q")).sendKeys(Keys.ESCAPE);
//		driver.findElement(By.name("btnK")).click();

		
		Thread.sleep(2000);
		driver.quit();
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);

		WebDriver driver;
		System.out.println("For ChromeBrowser type CH \nFor ChromeBrowser type FF\nFor EdgeBrowser type EG\nFor InternetExplorerBrowser type IE");
		String Browser = sc.nextLine();
		if (Browser.equals("CH")) {
			System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			DriverCall(driver);

		} else if (Browser.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "test/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			DriverCall(driver);

		} else if (Browser.equals("EG")) {
			System.setProperty("webdriver.edge.driver", "test/resources/msedgedriver.exe");
			driver = new EdgeDriver();
			DriverCall(driver);

		} else if (Browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "test/resources/IEDriverServer.exe");
			driver=new InternetExplorerDriver();  
			DriverCall(driver);

		}else {
			System.out.println("Invalid Input");
		}

		sc.close();

	}
}
