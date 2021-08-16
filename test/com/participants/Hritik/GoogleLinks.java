package scripts.basics;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleLinks {
public static void main(String[] args) throws IOException {
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
	driver = new ChromeDriver();
	String baseURL = PropertyReader.getProperties("baseURL");
	driver.get(baseURL);
	ArrayList<WebElement>  LinkArray = new ArrayList<>( driver.findElements(By.tagName("a")));
	for(WebElement e: LinkArray) {
		System.out.println(e.getAttribute("href")); 
	}
	driver.close();
}
}
