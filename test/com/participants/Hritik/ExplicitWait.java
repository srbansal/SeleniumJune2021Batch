package scripts.basics;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExplicitWait {

	WebDriver driver;

	@Test
	public void f() throws IOException {

		String baseURL = PropertyReader.getProperties("wiki");
		driver.get(baseURL);
		System.out.println("Title of current page :" + driver.getTitle());

		// Explicit Wait
		/*
		 * The Explicit Wait in Selenium is used to tell the Web Driver to wait for
		 * certain conditions (Expected Conditions) or maximum time exceeded before
		 * throwing "ElementNotVisibleException" exception. It is an intelligent kind of
		 * wait, but it can be applied only for specified elements. It gives better
		 * options than implicit wait as it waits for dynamically loaded Ajax elements.
		 * 
		 * There are 18 ExpectedConditions
		 */

		WebElement firstResult = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.id("js-link-box-en")));

		System.out.println(firstResult.getText());

		driver.findElement(By.id("js-link-box-en")).click();
		System.out.println("Title of current page :" + driver.getTitle());
		driver.findElement(By.name("search")).sendKeys("Selenium");
		driver.findElement(By.name("go")).submit();
		assertEquals(driver.getTitle(), "Selenium - Wikipedia");
		System.out.println("Title of current page :" + driver.getTitle());

	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");

		driver = new ChromeDriver();

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
