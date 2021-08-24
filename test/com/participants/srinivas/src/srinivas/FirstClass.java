package srinivas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class FirstClass {
	System.setProperty("webdriver.chromedriver","resources/chromedriver.exe");
	WebDriver driver =new ChromeDriver();
	
	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	
	driver.findElement(By.name("submit"));
	
	Alert alert=driver.switchTo().alert();
	
	System.out.println(alert.getText());
	
	alert.accept();
	

}
