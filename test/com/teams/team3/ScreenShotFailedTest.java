package Automated;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class FailedTest {
  	@Test
	public static void captureScreenMethod() throws Exception{
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
  try{
      driver.get("https://www.facebook.com/");
  driver.navigate().refresh();
  driver.findElement(By.xpath("//*[@id='cse']")).sendKeys("Failed test case"); // incorrect Xpath	
      }
  catch(Exception e){
      File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  FileUtils.copyFile(screenshotFile, new File("D:\\ScreenshotCheck.png"));
}
driver.close();
driver.quit();		
}

}
