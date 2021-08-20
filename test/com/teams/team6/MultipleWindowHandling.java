package com.teams.team6;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowHandling {

	public static void main(String[] args) {
		
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "testone/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.salesforce.com");
		String firstWindowTitle=driver.getTitle();
		
		//driver.switchTo().newWindow(windowType.TAB);      This command is used for opening a new tab in the same browser.
		//													But this package WindowType is available in selenium 4 and it is a beta version.
		
		driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/div/div[6]/div[1]/div[1]/div[3]/div/div[1]/div/a")).click();
		
		Set<String> handles=driver.getWindowHandles();		//Set is used as it avoids duplicate entries and id for every 
															//								window(tab opened) is different
															//getWindowHandles() is function which returns all the id's of the tab opened at time
		System.out.println(handles);
		
		List<String> list=new ArrayList<String>(handles);
		
		String parentHandle=list.get(0);
		String childHandle=list.get(1);
		
		System.out.println("Second Window's id is : "+childHandle);
		
		driver.switchTo().window(parentHandle);			//switching the windows 
		
		System.out.println("First Window id is : "+parentHandle);
		if(firstWindowTitle.equals(driver.getTitle()))				//Ensures that the driver has switched from second to first window 
			System.out.println("Successfully Switched to First Window");
		else
			System.out.println("NOT SWITCHED");
		
		//driver.close();
		driver.quit();
		  

	}

}
