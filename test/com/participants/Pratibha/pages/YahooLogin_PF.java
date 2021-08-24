package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class YahooLogin_PF {
	
	WebDriver driver;
	
	public YahooLogin_PF(WebDriver driver)
	{
		this.driver=driver;
	}

	@FindBy(id="login-username") 
	WebElement username;
	
	@FindBy(how=How.ID, using="login-signin")// how- class, id and using- variables
	WebElement signinButton;
	
	@FindBy(how=How.ID, using="login-passwd")
	WebElement password;
	
	@FindBy(how=How.NAME, using="verifyPassword")
	WebElement LogInButton;
	
	public void yahoologin(String email, String pass)
	{
		username.sendKeys(email);
		signinButton.click();
		password.sendKeys(pass);
		LogInButton.click();
	}
}	
