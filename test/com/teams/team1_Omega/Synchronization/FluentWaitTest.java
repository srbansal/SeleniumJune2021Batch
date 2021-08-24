package scripts.basics;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FluentWaitTest {

	WebDriver driver;

	@SuppressWarnings("deprecation")
	@Test
	public void f() throws IOException {

		String baseURL = PropertyReader.getProperties("wiki");
		driver.get(baseURL);
		System.out.println("Title of current page :" + driver.getTitle());

		// Fluent Wait
		/*
		 * The Fluent Wait in Selenium is used to define maximum time for the web driver
		 * to wait for a condition, as well as the frequency with which we want to check
		 * the condition before throwing an "ElementNotVisibleException" exception. It
		 * checks for the web element at regular intervals until the object is found or
		 * timeout happens.
		 * 
		 * Frequency: Setting up a repeat cycle with the time frame to verify/check the
		 * condition at the regular interval of time
		 * 
		 * Let's consider a scenario where an element is loaded at different intervals
		 * of time. The element might load within 10 seconds, 20 seconds or even more
		 * then that if we declare an explicit wait of 20 seconds. It will wait till the
		 * specified time before throwing an exception. In such scenarios, the fluent
		 * wait is the ideal wait to use as this will try to find the element at
		 * different frequency until it finds it or the final timer runs out.
		 */

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(5000, TimeUnit.SECONDS);
		wait.pollingEvery(250, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.elementToBeClickable(By.id("js-link-box-en")));

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
