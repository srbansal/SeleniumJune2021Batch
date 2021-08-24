package scripts.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class MainModule {
	static WebDriver driver=null;
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","test/resources/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://login.yahoo.com/");
		
		Login_Action.execute(driver);
		driver.quit();
	}

}
