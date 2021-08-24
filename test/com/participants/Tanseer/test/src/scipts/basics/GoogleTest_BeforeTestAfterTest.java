package scipts.basics;

import org.testng.annotations.Test;

import com.fileHandle.PropertyReader;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class GoogleTest_BeforeTestAfterTest {

	String baseUrl=null;
	String expectedTitle= null;
	String browserType=null;
	WebDriver driver=null;
  @Test(description="Google HomePage")
  public void f() {
	  baseUrl=PropertyReader.getProperty("Googleurl");
		 expectedTitle= PropertyReader.getProperty("expectedTitleGoogle");
		
		driver.get(baseUrl);
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Title Matched:TC passed");
		}
		else {
			System.out.println("Title NOT Matched:TC Failed");
		}
		assertEquals(expectedTitle,actualTitle);
  }
  @BeforeTest
  public void beforeTest() {
	  String browserType=PropertyReader.getProperty("browser");
		String DiverPath=PropertyReader.getProperty("chromeDriverPath");
		System.setProperty("webdriver.chrome.driver", DiverPath);
		driver=new ChromeDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
