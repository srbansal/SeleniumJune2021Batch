package scripts.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTestTestNg {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		
		String baseUrl="https://www.google.com/";
		System.setProperty("webdriver.chrome.driver", "test/resource/chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.get(baseUrl);
		
		
		
		Thread.sleep(2000);
		driver.quit();

	}

}
