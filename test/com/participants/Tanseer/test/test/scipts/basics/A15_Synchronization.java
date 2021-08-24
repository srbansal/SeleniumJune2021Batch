package scipts.basics;
import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.TakesScreenshot;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fileHandle.PropertyReader;

public class A15_Synchronization {
	
	static WebDriver driver=null;
	static void  explicitwait() {
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
	static void  implicitwait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		
		System.out.println("Title of current page :" + driver.getTitle());

		driver.findElement(By.id("js-link-box-en")).click();

		System.out.println("Title of current page :" + driver.getTitle());
		driver.findElement(By.name("search")).sendKeys("Selenium");

		driver.findElement(By.name("go")).submit();
		assertEquals(driver.getTitle(), "Selenium - Wikipedia");
		System.out.println("Title of current page :" + driver.getTitle());
	}
	static void  fluentwait() {
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
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String baseUrl=PropertyReader.getProperty("url");
		String expectedTitle= PropertyReader.getProperty("expectedTitle");
		String browserType=PropertyReader.getProperty("browser");
		
		if(browserType.equals("CH")) {
			String DiverPath=PropertyReader.getProperty("chromeDriverPath");
			System.setProperty("webdriver.chrome.driver", DiverPath);
			driver=new ChromeDriver();
		}
		else if(browserType.equals("FF")){
			String DiverPath=PropertyReader.getProperty("firefoxDriverPath");
			System.setProperty("webdriver.gecko.driver", DiverPath);
			driver=new FirefoxDriver();
		}
		//explicitwait();
		//implicitwait();
		driver.get("https://www.wikipedia.com");
		explicitwait();
		driver.close();
		
	}

}
