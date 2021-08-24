package scripts.basics;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import java.util.*;

public class Activity2 {

	public static void main(String[] args) throws IOException, InterruptedException{
		List<WebElement> ar;
		WebDriver driver;
		String baseUrl="https://www.google.com/";
		
		System.setProperty("webdriver.chrome.driver", "test/resource/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(baseUrl);
		
		ar=driver.findElements(By.tagName("a"));
		for(WebElement i: ar)
		{System.out.println(i.getText()+" =========== "+i.getAttribute("href"));}
		
		Thread.sleep(2000);
		driver.quit();
		// TODO Auto-generated method stub

	}

}
