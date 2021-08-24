package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.YahooLogin;

public class Yahoo_Login_Test {
	private static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		Yahoo_Login();

	}
	public static void Yahoo_Login() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://login.yahoo.com/");
		driver.manage().window().maximize();
		
		YahooLogin.findTextBox(driver).sendKeys("pratibha2399@yahoo.com");
		YahooLogin.button_signin(driver).click();
		Thread.sleep(2000);
		YahooLogin.FindPasswordBox(driver).sendKeys("Password@2399");
		YahooLogin.findSignInButton(driver).click();
		
		driver.quit();
	}

}
