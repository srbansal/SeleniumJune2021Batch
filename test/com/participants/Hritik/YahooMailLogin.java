//visit yahoo mail login page -> perform login
//create demo acc-> use simple password -> use property files

package scripts.basics;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooMailLogin {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		String baseURL = PropertyReader.getProperties("YahooURL");
		driver.get(baseURL);

		driver.findElement(By.id("login-username")).sendKeys(PropertyReader.getProperties("YahooMail"));
		driver.findElement(By.id("login-signin")).submit();
		Thread.sleep(4000);
//		driver.findElement(By.id("login-passwd")).sendKeys(PropertyReader.getProperties("YahooPwd"));
		driver.findElement(By.id("login-passwd")).sendKeys(PropertyReader.getProperties("WrongPwd"));

		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(2000);

		try {

			if (!driver.findElement(By.id("ybarMailLink")).getText().isEmpty()) {
				System.out.println("Login success");
			}

			driver.close();
		} catch (Exception e) {
			System.out.println("Login Failed");
			driver.close();
		}
	}
}
