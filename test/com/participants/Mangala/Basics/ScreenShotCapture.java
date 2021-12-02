package scripts.bascis;

import java.io.File;

import org.openqa.selenium.TakesScreenshot;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScreenShotCapture  {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		 WebDriver driver;
	       System.setProperty("webdriver.chrome.driver","test/resources/chromedriver.exe");
	       driver=new ChromeDriver();
	 
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
			    ArrayList<WebElement>  LinkArray = new ArrayList<>( driver.findElements(By.tagName("a")));
				for(WebElement e: LinkArray) {
					System.out.println(e.getAttribute("href")); 
				}
				UUID uuid=UUID.randomUUID();
			    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			    FileUtils.copyFile(src, new File("C:\\desktop\\Persistent training\\Pictures\\Screenshots"+uuid+".png"));

				
				
				driver.close();
	}

}
