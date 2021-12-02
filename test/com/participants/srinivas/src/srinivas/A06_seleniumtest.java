package scipts.basics;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A06_seleniumtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String baseUrl="https://www.google.com";
		String expectedTitle= "Google";
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(baseUrl);
		String actualTitle=driver.getTitle();
		List<WebElement> links=driver.findElements(By.tagName("a"));
		int count=0;
		for(WebElement elements:links) {
				System.out.println(elements.getText()+" "+elements.getAttribute("href")+" Visible on screen");			
				count++;
		}
		System.out.println("Total sites:"+count);
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Title Matched:TC passed");
		}
		else {
			System.out.println("Title NOT Matched:TC Failed");
		}
		//Thread.sleep(2000);
		driver.close();
	}

}
