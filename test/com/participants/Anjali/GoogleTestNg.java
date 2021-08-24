package scripts.basics;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class GoogleTestNg {
	WebDriver driver;
	  @Test
	  public void GoogleTestTestNg() {
			String baseUrl="https://www.google.com/";
			driver.get(baseUrl);
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  System.setProperty("webdriver.chrome.driver", "test/resource/chromedriver.exe");
			driver=new ChromeDriver();
	  }

	  @AfterMethod
	  public void afterMethod() {
		  Thread.sleep(2000);
		  driver.quit();
	  }
}
