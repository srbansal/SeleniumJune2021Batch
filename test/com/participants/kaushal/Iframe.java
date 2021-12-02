package com.participants.kaushal;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import java.io.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe {
	WebDriver webdriver = null;

	public static void main(String[] args) {
		Iframe i = new Iframe();
		i.cookBook();
	}

	public void cookBook() {
		System.setProperty("webdriver.chrome.driver", "Test/resources/chromedriver.exe");
		webdriver = new ChromeDriver();
		String url = "http://cookbook.seleniumacademy.com/Frames.html";// base Url
		webdriver.get(url);
		try {
			UUID uuid=UUID.randomUUID();
			File src = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\Users\\Lenovo\\Pictures\\Screenshots\\ss"+uuid+".png"));
//			Thread.sleep(1000);
////		            driver.switchTo().frame("frame-left"); //id attribute attribute of frame element
//			webdriver.switchTo().frame("left"); // id attribute or a name attribute of frame element
//
//			// Get an element from the frame on left side and verify it's contents
//			WebElement leftmsg = webdriver.findElement(By.tagName("p"));
//			assertEquals(leftmsg.getText(), "This is Left Frame");
//			// Activate the Page, this will move context from frame back to the Page
////		        webdriver.switchTo().defaultContent();		
//			// Activate the frame in middle using it's index. Index starts at 0
//			Thread.sleep(1000);
//			webdriver.switchTo().frame(1);
//			// index
//			// Get an element from the frame in the middle and verify it's contents
//			WebElement middlemsg = webdriver.findElement(By.tagName("p"));
//			assertEquals("This Frame doesn't have id or name", middlemsg.getText());
//
//			// Activate the Page, this will move context from frame back to the Page
//			// Get all frames on the Page, created with <frame> tag
//			List<WebElement> frames = webdriver.findElements(By.tagName("frame"));
//			// In this example frame in the middle is activated by checking the contents
//			// Activate frame and check if it has the desired content. If found perform the
//			// operations
//			// if not, then switch back to the Page and continue checking next frame
//			int counter = 0;
//			for (WebElement frame : frames) {
//				// switchTo().frame() also accepts frame elements apart from id, name or index
//				webdriver.switchTo().frame(frame);
//				if (webdriver.getPageSource().contains("This Frame doesn't have id or name")) {
//					assertTrue(true);
//					counter++;
//					System.out.println("Breaking page at" + counter);
//					// Take necessary action here
//					break;
//				} else
//					System.out.println("Else Staement");
//				webdriver.switchTo().defaultContent();
//			}
//			// Activate the Page, this will move context from frame back to the Page
//			webdriver.switchTo().defaultContent();
//			System.out.println("2" + Thread.currentThread().getId());

			// The frame on the right side has a nested iframe containing 'Twitter Follow'
			// Button
			// Activate the frame on right side using it's name attribute

			// Store the handle of current driver window
			String currentWindow = webdriver.getWindowHandle();

			webdriver.switchTo().frame("right");

			// Get the iframe element
			WebElement twitterframe = webdriver.findElement(By.tagName("iframe"));

			// Activate the iframe
			webdriver.switchTo().frame(twitterframe);

			// Get and Click the follow button from iframe
			// a Popup Window will appear after click

			WebElement button = webdriver.findElement(By.id("follow-button"));
			button.click();
			// The Twitter Popup does not have name or title.
			// Script will get handles of all open windows and
			// desired window will be activated by checking it's Title
			Set<String> allWindows = webdriver.getWindowHandles();
			if (!allWindows.isEmpty()) {
				for (String windowId : allWindows) {
					/*
					 * //If there are only two windows then following will work
					 * if(!windowId.equals(currentWindow)) { driver.switchTo().window(windowId);
					 * driver.close(); break; }
					 */

					// But best is to use below as it will work even if another window
					// is open apart from twitter.
					webdriver.switchTo().window(windowId);
					System.out.println("" + webdriver.getTitle().toString());

					if (webdriver.getTitle().toString().contains("Unmesh Gundecha ?? (@upgundecha) / Twitter")) {
						assertTrue(true);
						System.out.println("" + webdriver.getTitle());
						webdriver.close();
						break;
					}

				}
			}

		} catch (Exception e) {
			// *[@id="tabs-1"]/p[3]/input[1]

		}
	}
}
