package Utilities;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static Utilities.PropertyReader.getProperty;

public class Driver {
	public static WebDriver driverSetup(String browser) throws FileNotFoundException, IOException {
		WebDriver driver = null;
		if(browser.equals("CH")) {
			System.setProperty("webdriver.chrome.driver", getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
		}
		else if(browser.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", getProperty("firefoxDriverPath"));
			driver = new FirefoxDriver();
		}
		return driver;
	}
}
