package com.participants.kaushal;



import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class DragAndDrop {
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		
		//url for drag and drop actions
		String baseUrl = "https://jqueryui.com/droppable/";
		driver.get(baseUrl);
		Thread.sleep(2000);
		driver.switchTo().frame(0);  //there are multiple frames so need to go to 0th frame
		
		//Source element which we need to drag
		WebElement sourceElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		
		//target element where we need to drop the element
		WebElement targetElement = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		//Creating action class object
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		
		//perform drag and drop using src and dest element
		action.dragAndDrop(sourceElement, targetElement).build().perform();
		Thread.sleep(2000);
		
		//perform drag and drop using src and x, y offsets
		action.dragAndDropBy(sourceElement, 50, 50).build().perform();
		Thread.sleep(2000);
		
		//perform drag and drop using move method 
		action.clickAndHold(sourceElement).moveToElement(targetElement).build().perform();
		Thread.sleep(2000);
		
		driver.quit();
		
	}
}
