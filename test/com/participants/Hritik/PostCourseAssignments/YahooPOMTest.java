package scripts.PostCourseAssignments;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class YahooPOMTest {
	WebDriver driver;
	YahooPOM YP;
  @Test
  public void f() throws IOException {
	  	YP = new YahooPOM(driver);
	  	YP.setUserName();
	  	YP.signin();
	  	YP.setPassword();
	  	YP.signin();
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\Persistent\\eclipse-workspace\\Selenium\\test\\resources\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://login.yahoo.com");
  }
}
