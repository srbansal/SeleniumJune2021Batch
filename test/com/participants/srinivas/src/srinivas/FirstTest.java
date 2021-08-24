package srinivas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
		WebDriver driver ;
		driver=new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.id("login1")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("password")).sendKeys("23456");
		driver.findElement(By.name("proceed")).submit();
		
		
		
		Alert alert=driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
		alert.accept();
		
		

	}

}
