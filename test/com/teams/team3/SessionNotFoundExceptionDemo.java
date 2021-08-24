package ExceptionHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//The WebDriver is acting after you quit the browser.

public class SessionNotFoundExceptionDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "test/resource/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");
		
		driver.quit();
		driver.findElement(By.linkText("Selenium143")).click();

	}

}
