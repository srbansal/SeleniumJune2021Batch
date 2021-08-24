package scipts.basics;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A07_seleniumtest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String baseUrl="https://www.wikipedia.com";
		String expectedTitle= "Wikipedia";
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
		WebElement element=driver.findElement(By.id("js-link-box-en"));
		element.click();
		element=driver.findElement(By.name("search"));
		element.sendKeys("Selenium");
		driver.findElement(By.name("go")).submit();
		element=driver.findElement(By.id("firstHeading"));
		String actualHeading=element.getText();
		if(expectedHeading.equals(actualHeading)) {
			System.out.println("Heading Matched:TC passed");
		}
		else {
			System.out.println("Heading NOT Matched:TC Failed");
		}
		
		
		//Thread.sleep(2000);
		driver.close();
	}

}
