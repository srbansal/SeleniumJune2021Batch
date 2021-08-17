package com.teams.team5.WebElements;

import java.awt.Dimension;
import java.awt.List;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Handling_RadioButtonAndDropDownList {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		String baseUrl = "https://gcreddy.com/project/create_account.php";
		driver=new ChromeDriver();
		driver.get(baseUrl);
		
		
		WebElement radioButton = driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/form/div/div[2]/table/tbody/tr[1]/td[2]/input[2]"));
				System.out.println("Handling Radio Button \n");
				boolean status = radioButton.isDisplayed();//Check Status
				System.out.println("Displayed Status is: "+status);//true

				status = radioButton.isEnabled();
				System.out.println("Enabled Status is: "+status);//true

				status = radioButton.isSelected();//Check Status
				System.out.println("Initial Selected Status is: "+status);//false

				radioButton.click();
				Thread.sleep(3000);

				status = radioButton.isSelected();//Check Status
				System.out.println("Selected Status is: "+status);//true

				driver.findElement(By.name("gender")).click();

				status = radioButton.isSelected();
				System.out.println("Selected Status is: "+status);//false
				
				Thread.sleep(2000);
				
				System.out.println("----------------------------------------------------------------");
				System.out.println("Handling Drop-down list \n");
				boolean status1 = driver.findElement(By.name("country")).isDisplayed(); //Check Status
				System.out.println("Displated Status is: "+status1);//true

				status1 = driver.findElement(By.name("country")).isEnabled();
				System.out.println("Enabled Status is: "+status1);//true
				
				Select dropDown = new Select (driver.findElement(By.name("country")));
				dropDown.selectByIndex(111); // select by providing index
				
				dropDown.selectByValue("3"); // select by using value
				
				dropDown.selectByVisibleText("India"); //select by text
				Thread.sleep(5000);
				
				java.util.List<WebElement> myList = dropDown.getOptions();		
				int itemscount = myList.size();
				System.out.println(itemscount);

				Thread.sleep(4000);
				
				
				
				
				
				
				
				
				//driver.close();
		
	}

}
