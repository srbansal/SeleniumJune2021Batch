package Automated;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class FailedTestUsingITestInterface {
	static WebDriver driver;
  @Test
  public static void captureScreenMethod() throws Exception{
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.softwaretestingmaterial.com");
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id='cse']")).sendKeys("testing something"); //incorrect Xpath	
		
	}
 

  @AfterMethod
  public void screenShot(ITestResult result){
			if(ITestResult.FAILURE==result.getStatus()){
				try{
					TakesScreenshot screenshot=(TakesScreenshot)driver;
					File src=screenshot.getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(src, new File("D:\\"+result.getName()+".png"));
					System.out.println("Successfully captured a screenshot");
				}catch (Exception e){
					System.out.println("Exception while taking screenshot "+e.getMessage());
				} 
		}
			driver.quit();

}
}
