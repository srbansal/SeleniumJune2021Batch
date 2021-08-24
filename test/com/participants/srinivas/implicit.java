import org.testng.annotations.Test;

public class implicit {
  @Test
  public void f() {
	  package scripts.basics;

	  import org.testng.annotations.Test;
	  import org.testng.annotations.BeforeClass;

	  import static org.testng.Assert.assertEquals;

	  import java.io.IOException;
	  import java.util.concurrent.TimeUnit;

	  import org.openqa.selenium.By;
	  import org.openqa.selenium.WebDriver;
	  import org.openqa.selenium.chrome.ChromeDriver;
	  import org.testng.annotations.AfterClass;

	  public class Implicit {
	  	WebDriver driver;

	  	@Test
	  	public void f() throws IOException {

	  		// Implicit Wait
	  		/*
	  		 * The Implicit Wait in Selenium is used to tell the web driver to wait for a
	  		 * certain amount of time before it throws a "No Such Element Exception". The
	  		 * default setting is 0. Once we set the time, the web driver will wait for the
	  		 * element for that time before throwing an exception.
	  		 * 
	  		 * Selenium Web Driver has borrowed the idea of implicit waits from Watir.
	  		 * 
	  		 * In the below example we have declared an implicit wait with the time frame of
	  		 * 10 seconds. It means that if the element is not located on the web page
	  		 * within that time frame, it will throw an exception.
	  		 */
	  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	  		String baseURL = PropertyReader.getProperties("wiki");
	  		driver.get(baseURL);
	  		System.out.println("Title of current page :" + driver.getTitle());

	  		driver.findElement(By.id("js-link-box-en")).click();

	  		System.out.println("Title of current page :" + driver.getTitle());
	  		driver.findElement(By.name("search")).sendKeys("Selenium");

	  		driver.findElement(By.name("go")).submit();
	  		assertEquals(driver.getTitle(), "Selenium - Wikipedia");
	  		System.out.println("Title of current page :" + driver.getTitle());

	  	}

	  	@BeforeClass
	  	public void beforeClass() {
	  		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");

	  		driver = new ChromeDriver();

	  	}

	  	@AfterClass
	  	public void afterClass() {
	  		driver.close();
	  	}

	  }

  }
}
