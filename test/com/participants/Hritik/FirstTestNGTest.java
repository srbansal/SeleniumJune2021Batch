package scripts.basics;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class FirstTestNGTest {
	WebDriver driver;
	
  @Test
  public void googleTest() {
	  driver.get("https://www.google.com/");
	  
	  if(driver.getTitle().equals("Google"))
		  System.out.println("Title Matched!");
	  else
		  System.out.println("Tital NOT Matched!");
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
