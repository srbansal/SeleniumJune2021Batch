package scipts.basics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fileHandle.PropertyReader;


public class A20_TestLogin {
	
	String baseUrl=null;
	String expectedTitle= null;
	String browserType=null;
	WebDriver driver=null;
	A20_POM_Login objLogin;
	A20_POM_HomePage objHomePage;
	
	
	
  @Test(priority=0)
  public void test_Home_Page_Appear_Correct() throws InterruptedException, IOException, AWTException {
	 
	//Create Login Page object

	    objLogin = new A20_POM_Login(driver);

	    //Verify login page title

	    String loginPageTitle = objLogin.getLoginTitle();

	    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

	    //login to application

	    objLogin.loginToGuru99("mgr123", "mgr!23");

	    // go the next page

	    objHomePage = new A20_POM_HomePage(driver);

	    //Verify home page

	    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
  }
  @BeforeMethod
  public void beforeMethod() {
	  	
	  	String browserType=PropertyReader.getProperty("browser");
		String DiverPath=PropertyReader.getProperty("chromeDriverPath");
		System.setProperty("webdriver.chrome.driver", DiverPath);
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://demo.guru99.com/V4/");
	  
  }
  /**

  * This test case will login in http://demo.guru99.com/V4/

  * Verify login page title as guru99 bank

  * Login to application

  * Verify the home page using Dashboard message

  */


  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
