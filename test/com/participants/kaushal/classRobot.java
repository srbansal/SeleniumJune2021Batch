//Author Kaushal Digraskar



package com.participants.kaushal;
//Imports
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//////////////////////////////////////////////


public class classRobot {
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		//Setting property
		System.setProperty("webdriver.chrome.driver", "Test/resources/chromedriver.exe");
		
		// Open Chrome
		WebDriver driver = new ChromeDriver();
		
		// Maximize the window
		driver.manage().window().maximize();

		// Open facebook
		driver.get("http://www.facebook.com");

		
		// Create object of Robot class
		Robot robot = new Robot();

		// press arrow down key of keyboard
		robot.keyPress(KeyEvent.VK_DOWN); 
		
		// sleep has only been used to showcase each event separately
		Thread.sleep(2000); 
		robot.keyPress(KeyEvent.VK_TAB);//Tab functionality
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);//Tab Functionality
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);//Tab Functionality
		Thread.sleep(2000);
		
		// Finding Element By ID
		driver.findElement(By.id("email")).sendKeys("Selenium@gmail.com");
		
		// pressing shift
		robot.keyPress(KeyEvent.VK_SHIFT);
		// Enter password
		driver.findElement(By.id("pass")).sendKeys("mukesh");
		//Element is Found and this comment is just to confuse you all
		//	 robot.keyRelease(KeyEvent.VK_SHIFT);//Releasing SHIFT
		// Pressing Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		

		// Release Enter
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}

}
