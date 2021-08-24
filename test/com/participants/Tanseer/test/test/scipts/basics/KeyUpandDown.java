package scipts.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyUpandDown {
	public static void main(String[] args) {
		try {
			System.setProperty("webdriver.chrome.driver","test/resources/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			String url = "https://www.tutorialspoint.com/index.htm";
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	      
			// identify element
			WebElement l = driver.findElement(By.id("search-strings"));
			// Actions class
			Actions a = new Actions(driver);
			// moveToElement() and then click()
			a.moveToElement(l).click();
			//enter text with keyDown() SHIFT key ,keyUp() then build() ,perform()
			a.keyDown(Keys.SHIFT);
			a.sendKeys("hello key Up").keyUp(Keys.SHIFT).build().perform();//Sending values to the specific element
			Thread.sleep(200);//Thread for some time
			WebElement btn = driver.findElement(By.id("btnSearch"));//Finding element to perform double click action
			a.moveToElement(btn).build().perform(); //cursor hover			
			a.doubleClick(btn).perform();//Double click action to search
			driver.close();
	}catch(Exception e) {
		
	}
		}

}