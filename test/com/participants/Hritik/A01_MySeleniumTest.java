package scripts.basics;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A01_MySeleniumTest {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello Selenium(SE)");

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		driver = new ChromeDriver();

		String expectedTitle = "Google";
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
		// Thread.sleep(2000);
//		System.out.println(driver.getTitle());
		driver.quit();
		// driver.close();
		// driver.get(baseURL);
		// System.out.println(driver.getTitle());

	}
}
