package ExceptionHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//This Exception occurs if the frame target to be switched to does not exist.

public class NoSuchFrameExceptionDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "test/resource/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");
		
		try {
			driver.switchTo().frame("XYZ");
		}
		catch(NoSuchFrameException e)
		{
			System.out.println("NoSuchFrameException got handled");
		}
		
		Thread.sleep(2000);
		driver.quit();

	}

}
