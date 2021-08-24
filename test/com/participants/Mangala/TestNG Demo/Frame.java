package scripts.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;


public class Frame {
	WebDriver driver;

  @Test
  public void f() throws  IOException, InterruptedException {
	 // driver.get(PropertyReader.getProperties("fURL"));

		// Left Frame
		// Activate the frame on left side using it's id or name attribute
		try {
		//driver.switchTo().frame("frame-left"); //id attribute attribute of frame element
			driver.switchTo().frame("left"); // id attribute or a name attribute of frame element
		} catch (NoSuchFrameException e) {
			fail("Frame was expected but not found");
		}
		// Get an element from the frame on left side and verify it's contents
		WebElement leftmsg = driver.findElement(By.tagName("p"));
		assertEquals(leftmsg.getText(), "This is Left Frame");
		// Activate the Page, this will move context from frame back to the Page
		driver.switchTo().defaultContent();

		// Right Frame
		// Activate the frame on right side using it's name attribute
		driver.switchTo().frame("right");

		// Get an element from the frame on right side and verify it's contents
		WebElement rightmsg = driver.findElement(By.tagName("p"));
		assertEquals(rightmsg.getText(), "This is Right Frame");

		// Activate the Page, this will move context from frame back to the Page
		driver.switchTo().defaultContent();

		Thread.sleep(3000);

		// Middle Frame
		// Activate the frame in middle using it's index. Index starts at 0
		driver.switchTo().frame(1);
		// index
		// Get an element from the frame in the middle and verify it's contents
		WebElement middlemsg = driver.findElement(By.tagName("p"));
		assertEquals("This Frame doesn't have id or name", middlemsg.getText());

		// Activate the Page, this will move context from frame back to the Page
		driver.switchTo().defaultContent();
  }
  @BeforeMethod
  public void beforeMethod() throws IOException{
	 // System.setProperty(PropertyReader.getProperties("cKey"), PropertyReader.getProperties("cValue"));
		driver = new ChromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
