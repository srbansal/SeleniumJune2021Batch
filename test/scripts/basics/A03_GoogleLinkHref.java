package scripts.basics;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.PropertyReader;

public class A03_GoogleLinkHref {

	public static void main(String[] args) throws IOException, InterruptedException  {
		WebDriver driver;
		String baseUrl=null;
		String expectedTitle=null;
		String chromeDriverPath=null;
		
		baseUrl = PropertyReader.getProperty("url");
		expectedTitle = PropertyReader.getProperty("expectedTitle");
		chromeDriverPath = PropertyReader.getProperty("chromeDriverPath");
		
		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();	
		
		driver.get(baseUrl); 
		
//		---------------------------------------------
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(WebElement link: links)
		{
			System.out.println(link.getText() + " - " + link.getAttribute("href"));
		}
		System.out.println("No of links found: " + links.size());
		
		Thread.sleep(2000);
		driver.quit();	// close the browser
	}

}
