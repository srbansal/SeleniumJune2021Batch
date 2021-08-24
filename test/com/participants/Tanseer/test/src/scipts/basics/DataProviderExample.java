package scipts.basics;

import org.testng.annotations.Test;

import com.fileHandle.PropertyReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class DataProviderExample {
	String baseUrl=null;
	String expectedTitle= null;
	String browserType=null;
	WebDriver driver=null;
  @Test(dataProvider = "userdata")
  public void f(String uname, String pwd) {
	  driver.get("https://www.facebook.com/");
	  System.out.println(uname+" "+pwd);
	  Reporter.log("executing test with user email "+uname+"and password "+pwd);
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys(uname);
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pwd);
	  driver.findElement(By.xpath("//button[@name='login']")).submit();

	  
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

  @DataProvider(name="userdata")
  public Object[][] sendUserdata() {
     Object[][] user={
      { "abc", "1236" },
       { "def", "4569" }
    };
    
    return(user);
  }
}
