/*
First thing to do in first 30 min today:
Create two existing Tests using TestNG.
1. Google Home page googleTest()
2. Wikipedia Test
wikiTest()
Both of them should be in a single TestNG class.
 */

package scripts.basics;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class GoogleWikiTestNG {
	WebDriver driver;

	@Test
	public void f() throws IOException, InterruptedException {
		//google
		System.out.println("-------------------------\n\n\nGoogle Test\n\n\n----------------------");
		String baseURL = PropertyReader.getProperties("baseURL");
		driver.get(baseURL);
		assertEquals(driver.getTitle(), "Google");
		ArrayList<WebElement> LinkArray = new ArrayList<>(driver.findElements(By.tagName("a")));
		for (WebElement e : LinkArray) {
			System.out.println(e.getAttribute("href"));
		}
		
		
		
		Thread.sleep(2000);
	}
	@Test
	public void f1() throws IOException, InterruptedException {
		//wiki
				System.out.println("-------------------------\n\n\nWiki Test\n\n\n----------------------");
				String baseURL = PropertyReader.getProperties("wiki");
				driver.get(baseURL);
				System.out.println("Title of current page :"+driver.getTitle());
				driver.findElement(By.id("js-link-box-en")).click();
				System.out.println("Title of current page :"+driver.getTitle());
				driver.findElement(By.name("search")).sendKeys("Selenium");
				driver.findElement(By.name("go")).submit();
				assertEquals(driver.getTitle(), "Selenium");
				System.out.println("Title of current page :"+driver.getTitle());
				Thread.sleep(2000);
	}

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
