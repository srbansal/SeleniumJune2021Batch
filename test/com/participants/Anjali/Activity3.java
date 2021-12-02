package scripts.basics;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import java.util.*;

public class Activity3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		String baseUrl="https://in.yahoo.com/";
		
		System.setProperty("webdriver.chrome.driver", "test/resource/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(baseUrl);
		
		driver.findElement(By.className("_yb_145i1")).click();
		driver.findElement(By.id("login-username")).sendKeys("anjali_namdeo@yahoo.com");
		driver.findElement(By.id("login-signin")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("login-passwd")).sendKeys("BabyAkks123");
		driver.findElement(By.id("login-signin")).click();
		
		/*String n=driver.findElement(By.className("_yb_1n21y _yb_1hojn _yb_ezond")).toString();
		String ex="Anjali";
		System.out.println(n);
		
		if(n.equals(ex))
		{System.out.println("Logged");}
		else
		{System.out.println("Not Logged");}
		*/
		Thread.sleep(2000);
		driver.close();

	}

}
