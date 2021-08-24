package scipts.basics;
import java.io.File;

import org.openqa.selenium.TakesScreenshot;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.fileHandle.PropertyReader;

public class A14_Screenshot {

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
		File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    String filename=formatter.format(date); 
	    // 19/08/2021 1221
	    filename=filename.replace(":", "");
	    filename=filename.replace("/", "");
	    filename=filename.replace(" ", "");
	    System.out.println(filename);
	    FileUtils.copyFile(scrfile, new File("D:\\"+filename+".png"));
		
		
		driver.close();
	}

}
