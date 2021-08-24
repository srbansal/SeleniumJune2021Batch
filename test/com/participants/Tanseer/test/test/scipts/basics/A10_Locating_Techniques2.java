package scipts.basics;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.fileHandle.PropertyReader;

public class A10_Locating_Techniques2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//PropertyReader r=new PropertyReader();
		//String s=r.getProperty("Googleurl");
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
		
		driver.get(s);
		
		  List<WebElement> links= driver.findElements(By.tagName("a"));
	        
	        int i= links.size();
	        System.out.println(i);
	        
	        for(int j=0; j<i; j++)
	        {
	            
	            System.out.println(links.get(j).getText());
	        }
	        driver.findElement(By.className("download-link mzp-c-button mzp-t-product mzp-t-xl")).click();    
	        
	        driver.close();
		
			
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
