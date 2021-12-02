package scripts.bascis;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.List;

public class A03_link {

	public static void main(String[] args) throws IOException,InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver =new ChromeDriver();
       String baseURL="https://www.google.com";
       System.setProperty("webdriver.chrome.driver","\\test\\resources\\chromedriver.exe");
       driver.get(baseURL);
       List<WebElement> Links=driver.findElements(By.tagName("a"));
       for(WebElement elements:Links)
       {
    	   System.out.println(elements.getAttribute("href"));
       }
       driver.quit();
	}

}
