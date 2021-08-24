package scripts.basics;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
//run by right clicking xml
public class GoogleTest_BeforeAfterTest {
	WebDriver driver;
	String baseURL = null;
  @Test(description = "Google home page links")
  public void f() throws IOException {
	  
	  baseURL = PropertyReader.getProperties("baseURL");
	  driver.get(baseURL);
		ArrayList<WebElement>  LinkArray = new ArrayList<>( driver.findElements(By.tagName("a")));
		for(WebElement e: LinkArray) {
			System.out.println(e.getAttribute("href"));
  }
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		
		
  }
  

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
