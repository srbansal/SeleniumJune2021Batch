package scripts.DDT_POM_Assignment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class POM_YahooDemo {
	WebDriver driver;
    System.setProperty("webdriver.chrome.driver","test/resources/chromedriver.exe");
    driver=new ChromeDriver();
	  
	private static WebElement element=null;
	public static WebElement findTextBox(WebDriver driver) throws InterruptedException
	{
		element=driver.findElement(By.id("login-username"));
		return element;
		
	}
	public static WebElement button_signin(WebDriver driver)
	{
		element=driver.findElement(By.id("login-signin"));
		return element;
	}
	public static WebElement FindPasswordBox(WebDriver driver)
	{
		element=driver.findElement(By.id("login-passwd"));
		return element;
		
	}
	public static WebElement findSignInButton(WebDriver driver)
	{
		element=driver.findElement(By.name("verifyPassword"));
		return element;
	}
}