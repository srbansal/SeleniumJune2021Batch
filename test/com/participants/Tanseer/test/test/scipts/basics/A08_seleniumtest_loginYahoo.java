package scipts.basics;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fileHandle.PropertyReader;

public class A08_seleniumtest_loginYahoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String baseUrl="https://www.yahoo.com";
		String expectedTitle= "Yahoo India";
		String expectedHeading="Selenium";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(baseUrl);
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Title Matched:TC passed");
		}
		else {
			System.out.println("Title NOT Matched:TC Failed");
		}
		WebElement element=driver.findElement(By.className("_yb_145i1"));
		element.click();
		element=driver.findElement(By.name("username"));
		String email=PropertyReader.getProperty("email");
		element.sendKeys(email);
		driver.findElement(By.id("login-signin")).submit();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String password=PropertyReader.getProperty("password");
		element=driver.findElement(By.id("login-passwd"));
		element.sendKeys(password);
		element.submit();
		
		
		
		//Thread.sleep(2000);
		driver.close();
	}

}
