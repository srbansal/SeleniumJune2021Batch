package scipts.basics;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.fileHandle.PropertyReader;

public class A10_Locating_Techniques {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String baseUrl=PropertyReader.getProperty("url");
		String expectedTitle= PropertyReader.getProperty("expectedTitle");
		String browserType=PropertyReader.getProperty("browser");
		WebDriver driver=null;
		
		if(browserType.equals("CH")) {
			String DiverPath=PropertyReader.getProperty("chromeDriverPath");
			System.setProperty("webdriver.chrome.driver", DiverPath);
			driver=new ChromeDriver();
		}
		else if(browserType.equals("FF")){
			String DiverPath=PropertyReader.getProperty("firefoxDriverPath");
			System.setProperty("webdriver.gecko.driver", DiverPath);
			driver=new FirefoxDriver();
		}
		
		driver.get("https://www.yahoo.com");
		
		//1.ByclassName
		driver.findElement(By.className("_yb_zl0iu")).click();
		//2.Byname
		driver.findElement(By.name("username")).sendKeys("abc@gmail.com");
		//3.Byid
		driver.findElement(By.id("login-username")).submit();
		
			
		//2.ById
		
//		if(expectedTitle.equals(actualTitle)) {
//			System.out.println("Title Matched:TC passed");
//		}
//		else {
//			System.out.println("Title NOT Matched:TC Failed");
//		}			
//		//Thread.sleep(2000);
//		
//		WebElement element = driver.findElement(By.id("searchInput"));
//		element.sendKeys("selenium");
//		element.sendKeys(Keys.TAB);
//		driver.findElement(By.name("search")).submit();
//		WebElement ele=driver.findElement(By.id("firstHeading"));
//		System.out.println(ele.getText());
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		driver.close();
	}

}
