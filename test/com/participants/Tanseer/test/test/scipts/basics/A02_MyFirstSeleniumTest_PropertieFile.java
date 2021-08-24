package scipts.basics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fileHandle.PropertyReader;

public class A02_MyFirstSeleniumTest_PropertieFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String baseUrl=PropertyReader.getProperty("url");
		String expectedTitle= PropertyReader.getProperty("expectedTitle");
		String chromeDivePath=PropertyReader.getProperty("chromeDriverPath");
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", chromeDivePath);
		driver=new ChromeDriver();
		driver.get(baseUrl);
		String actualTitle=driver.getTitle();
		
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
