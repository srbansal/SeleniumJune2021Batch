package scripts.basics;
import java.io.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class Activity10Aug {

	public static void main(String[] args) throws IOException,InterruptedException {
		WebDriver driver;
		String baseUrl="https://www.wikipedia.org/";
		String exp="Selenium - Wikipedia";
		
		System.setProperty("webdriver.chrome.driver", "test/resource/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(baseUrl);

		driver.findElement(By.id("js-link-box-en")).click();
		driver.findElement(By.name("search")).sendKeys("Selenium");
		driver.findElement(By.name("go")).click();

		String act=driver.getTitle();
		System.out.println(act);
		if(act.equals(exp))
		{
			System.out.println("Passes");
		}
		else
		{
			System.out.println("failed");
		}
		Thread.sleep(2000);
		driver.quit();


	}

}
