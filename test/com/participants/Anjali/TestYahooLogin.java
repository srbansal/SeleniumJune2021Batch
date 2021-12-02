package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import pages.YahooHomepage;
import pages.YahooLogin;

public class TestYahooLogin {
	String driverPath="D:\\Program Files\\eclipse\\pagefactory\\src\\main\\resources\\geckodriver.exe";
	WebDriver driver;
	YahooLogin objLogin;
	YahooHomepage objHomepage;
	
  @Test(priority=0)
  public void test_Home_Page_Appear_Correct() {
	  objLogin=new YahooLogin(driver);
	//  String loginPageTitle=objLogin.getLoginTitle();
	 //assertTrue(loginPageTitle.toLowerCase().contains("Yahoo!"));
	  objLogin.loginToYahoo("anjali_namdeo@yahoo.com", "Akshay@123");
	  objHomepage=new YahooHomepage(driver);
	  Assert.assertTrue(objHomepage.getHomePageDashboardUserName().toLowerCase().contains(" Yahoo Mail"));
	 // System.out.println(objHomepage.getHomePageDashboardUserName());

	  
  }
  @BeforeMethod
  public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		 driver = new ChromeDriver();

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://login.yahoo.com/?.lang=en-IN&src=homepage&activity=ybar-signin&pspid=97684142&done=https%3A%2F%2Fin.yahoo.com%2F&add=1");
	        

  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.quit();
  }

}
