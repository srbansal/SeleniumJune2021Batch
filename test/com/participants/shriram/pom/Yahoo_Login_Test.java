package pom;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import mavenselenium.PropertyReader;



public class Yahoo_Login_Test {
	private static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {
		Yahoo_Login();

	}
	public static void Yahoo_Login() throws InterruptedException, IOException
	{
		WebDriverManager.chromeDriverSetUp();
		driver=new ChromeDriver();
		driver.get("https://login.yahoo.com/");
		driver.manage().window().maximize();
		
		YahooLogin.findTextBox(driver).sendKeys(PropertyReader.getProperty("username"));
		YahooLogin.button_signin(driver).click();
		Thread.sleep(2000);
		YahooLogin.FindPasswordBox(driver).sendKeys(PropertyReader.getProperty("password"));
		YahooLogin.findSignInButton(driver).click();
		
		driver.quit();
	}

}
