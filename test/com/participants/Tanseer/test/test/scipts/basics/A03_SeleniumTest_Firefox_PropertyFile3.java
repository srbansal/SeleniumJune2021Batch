package scipts.basics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fileHandle.PropertyReader;

public class A03_SeleniumTest_Firefox_PropertyFile3 {

	public static void main(String[] args) {
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
		else if(browserType.equals("ME")) {
			String DiverPath=PropertyReader.getProperty("edgeDriverPath");
			System.setProperty("webdriver.msedge.driver", DiverPath);
			driver=new EdgeDriver();
		}
		
		driver.get(baseUrl);
		String actualTitle=driver.getTitle();
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Title Matched:TC passed");
		}
		else {
			System.out.println("Title NOT Matched:TC Failed");
		}
		//Thread.sleep(2000);
		WebElement element=driver.findElement(By.className("_yb_145i1"));
		element.click();
		element=driver.findElement(By.name("username"));
		String email=PropertyReader.getProperty("email");
		element.sendKeys(email);
		driver.findElement(By.id("login-signin")).submit();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String password=PropertyReader.getProperty("password");
		element=driver.findElement(By.id("login-passwd"));
		element.sendKeys(password);
		element.submit();
		
		driver.close();
	}

}
