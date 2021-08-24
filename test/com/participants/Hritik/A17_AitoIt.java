package scripts.basics;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class A17_AitoIt {

	String baseUrl = null;
	String expectedTitle = null;
	String browserType = null;
	WebDriver driver = null;

	@Test
	public void Test() throws InterruptedException, IOException {

		driver.get("http://demo.guru99.com/test/autoit.html");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();

		// Vertical scroll down by 600 pixels
		js.executeScript("window.scrollBy(0,600)");

		// Switching frame

		// Activate the iframe
		driver.switchTo().frame(driver.findElement(By.id("JotFormIFrame-72320244964454")));
		Thread.sleep(2000);
		driver.findElement(By.id("input_3")).sendKeys("abc");
		driver.findElement(By.id("input_4")).sendKeys("abc.def@gmail.com");

		driver.findElement(By.id("input_6")).sendKeys("AutoIT in Selenium");
		Thread.sleep(1000);

		// below line execute the AutoIT script .

		Thread.sleep(1000);
		driver.findElement(By.id("label_5")).click();
		// below line execute the AutoIT script .
		Runtime.getRuntime().exec("C:\\Users\\Persistent\\Desktop\\FileUpload.exe");
		Thread.sleep(5000);
		driver.findElement(By.id("input_2")).click();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();

	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
