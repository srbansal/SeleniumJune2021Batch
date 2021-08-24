package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YahooLogin {
	
	private static WebElement element=null;
	public static WebElement findTextBox(WebDriver driver) throws InterruptedException
	{
		element=driver.findElement(By.id("login-username"));
		return element;
		
	}
	public static WebElement button_signin(WebDriver driver)
	{
		element=driver.findElement(By.id("login-signin"));
		return element;
	}
	public static WebElement FindPasswordBox(WebDriver driver)
	{
		element=driver.findElement(By.id("login-passwd"));
		return element;
		
	}
	public static WebElement findSignInButton(WebDriver driver)
	{
		element=driver.findElement(By.name("verifyPassword"));
		return element;
	}
	
	
	
	
	

}
