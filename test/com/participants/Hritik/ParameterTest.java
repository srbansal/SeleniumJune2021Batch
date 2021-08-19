package scripts.basics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	WebDriver driver;
	String baseURL = null;

	@Parameters({"suite-param"})
	@Test(description = "Search term on Google")
	public void f(String param) throws IOException {
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		baseURL = PropertyReader.getProperties("baseURL");
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys(param);
		driver.findElement(By.name("q")).click();
		System.out.println(driver.getTitle());
		driver.close();
	}
}
