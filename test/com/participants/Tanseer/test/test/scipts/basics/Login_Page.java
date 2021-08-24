package scipts.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {
	//Webelements 
	//creating methods for returning various web elements like username, pass, click next and signin button
	
	static WebElement element=null;
	public static WebElement txt_Username(WebDriver driver)
	{
		element = driver.findElement(By.id("login-username"));
		return element;
	}
	public static WebElement btn_signin(WebDriver driver)
	{
		element = driver.findElement(By.name("signin"));
		return element;
	}
	public static WebElement txt_Password(WebDriver driver)
	{
		element = driver.findElement(By.id("login-passwd"));
		return element;
	}
	public static WebElement verify_Password(WebDriver driver)
	{
		element = driver.findElement(By.name("verifyPassword"));
		return element;
	}
}