package scripts.basics;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {
public static void main(String[] args) throws IOException {
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
	driver = new ChromeDriver();
	String baseURL = PropertyReader.getProperties("baseURL");
	driver.get(baseURL);
	ArrayList<WebElement>  LinkArray = new ArrayList<>( driver.findElements(By.tagName("a")));
	for(WebElement e: LinkArray) {
		System.out.println(e.getAttribute("href")); 
	}
	UUID uuid=UUID.randomUUID();
    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(src, new File("C:\\Users\\Persistent\\Pictures\\Screenshots"+uuid+".png"));

	driver.close();
}
}
