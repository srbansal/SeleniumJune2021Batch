package scipts.basics;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.fileHandle.PropertyReader;

public class A10_Locating_Techniques3 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String urlGoogle=PropertyReader.getProperty("Googleurl");
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
		
		
		String urlWiki = PropertyReader.getProperty("Wikiurl");
		Dimension size =driver.manage().window().getSize();
		driver.manage().window().maximize();
        driver.get(urlWiki);
        driver.get(urlGoogle);
                
      Thread.sleep(2000);
      driver.navigate().back();
      
      Thread.sleep(2000);
      driver.navigate().forward();
      
      Thread.sleep(2000);
      driver.navigate().refresh();
      
      Thread.sleep(2000);

      
      Thread.sleep(2000);
      driver.manage().window().setSize(size);
      String currenturl =driver.getCurrentUrl();
      String pagesource=driver.getPageSource();
		//2.ById
		System.out.println(currenturl+" "+pagesource.charAt(0));
	      driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");
	      
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(("body"))).sendKeys(Keys.CONTROL+"T");
			Thread.sleep(2000);
			
		
		
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
