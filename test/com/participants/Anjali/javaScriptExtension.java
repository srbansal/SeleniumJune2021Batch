package scripts.basics;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class javaScriptExtension {

	@Test

	public void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "test/resource/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	driver.manage().window().maximize();
	
		driver.get("http://www.moneyboat.co.in/");

	//driver.get("https://www.browserstack.com/users/sign_in");
	js.executeAsyncScript("window.scrollBy(0,600)");
	//js.executeScript("document.getElementById('user_email_login').value='Anjali@xyz.com';");
	//js.executeScript("document.getElementById('user_password').value='password';");
	//js.executeScript("document.getElementById('user_submit').click();");
	//js.executeScript("alert('enter correct login credentials to continue');");
	Thread.sleep(2000);
	driver.quit();
	}	

}
