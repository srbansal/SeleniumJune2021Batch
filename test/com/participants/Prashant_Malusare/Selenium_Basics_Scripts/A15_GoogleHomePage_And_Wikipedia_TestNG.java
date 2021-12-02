package script.basis;
//  google page testsng
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class GoogleHomePage_And_Wikipedia_TestNG {
	WebDriver driver;
  @Test
  public void googleTest() {
	  driver.get("https://www.google.com/");
	  
	  if(driver.getTitle().equals("Google"))
	  {
		  System.out.println("Title matched ");
		  
	  }
	  else
	  {
		  System.out.println("Title  NOT matched ");
  
	  }
	  //driver.quit();
  }
  
  @Test
  public void wikipedia() {
	  driver.get("https://www.wikipedia.org/");
	  
	  if(driver.getTitle().equals("Wikipedia"))
	  {
		  System.out.println("Title wiki  matched ");
		  
	  }
	  else
	  {
		  System.out.println("Title wiki NOT matched ");
  
	  }
	 //driver.quit();
  }

  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
	  driver=new ChromeDriver();
	  
	  //googleTest();
	  
	 // Thread.sleep(5000);
	  
	  //wikipedia();
	  
	  
	  Thread.sleep(3000);
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
