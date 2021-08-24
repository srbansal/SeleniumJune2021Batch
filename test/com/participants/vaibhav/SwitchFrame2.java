package com.persistent.vaibhav;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class SwitchFrame2 {
	WebDriver driver;
  @Test
  public void frame2() {
	  // Get all frames on the Page, created with <frame> tag
      List<WebElement> frames = driver.findElements(By.tagName("frame"));
      // In this example frame in the middle is activated by checking the contents
      // Activate frame and check if it has the desired content. If found perform the
      // operations
      // if not, then switch back to the Page and continue checking next frame
      for (WebElement frame : frames) {
          // switchTo().frame() also accepts frame elements apart from id, name or index
          driver.switchTo().frame(frame);
          if (driver.getPageSource().contains("This Frame doesn't have id or name")) {
              assertTrue(true);
              // Take necessary action here 
              break;
          } else
              driver.switchTo().defaultContent();
      }
      // Activate the Page, this will move context from frame back to the Page
      driver.switchTo().defaultContent();

  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  System.setProperty(PropertyReader.getProperties("cKey"), PropertyReader.getProperties("cValue"));
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
