package Selenium_MavenProject.Selenium_MavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InnerIframe {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Iframe with in an Iframe")).click();
		
		WebElement outeriFrame=driver.findElement(By.cssSelector("#Multiple > iframe"));
		driver.switchTo().frame(outeriFrame);//Passing Frame as web element//Switched to outer Iframe
		
		WebElement InnerIframe=driver.findElement(By.cssSelector("body > section > div > div > iframe"));
		driver.switchTo().frame(InnerIframe);//Switched to Inner iframe
		
		driver.findElement(By.cssSelector("body > section > div > div > div > input[type=text]")).sendKeys("Welcome");
		
		Thread.sleep(4000);
		driver.quit();


	}

}
