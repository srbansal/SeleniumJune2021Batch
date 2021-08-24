package scripts.bascis;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class KeyboardEventEx {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Test/resources/chromedriver.exe");
		// Open Chrome
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=en");
		WebDriver driver = new ChromeDriver(options);
				// Maximize the window
		driver.manage().window().maximize();

		// Open facebook
		driver.get("http://www.facebook.com");

		// Enter Username
		
		// Create object of Robot class
		Robot robot = new Robot();

		// Press Enter

		// Robot class throws AWT Exception
//          Thread.sleep(2000); // Thread.sleep throws InterruptedException	
		robot.keyPress(KeyEvent.VK_DOWN); // press arrow down key of keyboard to navigate and select Save radio button

		Thread.sleep(2000); // sleep has only been used to showcase each event separately
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		// Finding Element By ID
		driver.findElement(By.id("email")).sendKeys("demo@gmail.com");
		robot.keyPress(KeyEvent.VK_SHIFT);// pressing shift
		// Enter password
		driver.findElement(By.id("pass")).sendKeys("Unknown");
		 robot.keyRelease(KeyEvent.VK_SHIFT);//Releasing SHIFT

		robot.keyPress(KeyEvent.VK_ENTER);// Pressing Enter

		// Release Enter
		robot.keyRelease(KeyEvent.VK_ENTER);
		// press enter key of keyboard to perform above selected action{


	}

}
