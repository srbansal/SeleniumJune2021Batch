package scripts.bascis;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class A02_Wikipedia {

	public static void main(String[] args) throws IOException,InterruptedException
	{
		// TODO Auto-generated method stub
		
		  System.setProperty("webdriver.chrome.driver","test/resources/chromedriver.exe");
		  WebDriver driver =new ChromeDriver();
		   driver.get("https://www.wikipedia.org");
	       WebElement link;
	       link=driver.findElement(By.linkText("English"));
	       link.click();
	       Thread.sleep(3000);
	       WebElement serachbox;
	       serachbox=driver.findElement(By.id("searchInput"));
	       serachbox.sendKeys("Selenium");
	       Thread.sleep(3000);
	       
	       
	       driver.quit();

	}

}
