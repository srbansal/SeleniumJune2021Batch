package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YahooLogin {
	WebDriver driver;
	By userYahooName= By.name("username");
	By passwordYahoo= By.name("password");
	By login=By.id("login-signin");
	
	public YahooLogin(WebDriver driver) {
		this.driver=driver;
	}
	public void setUserName(String strUser) {
		driver.findElement(userYahooName).sendKeys(strUser);
	}
	public void setPassword(String strPass) {
		driver.findElement(passwordYahoo).sendKeys(strPass);
	}
	public void clickLogin() {
		driver.findElement(login).click();
	}
	public void loginToYahoo(String strUserName,String strPasword){

        //Fill user name

        this.setUserName(strUserName);
        this.clickLogin();

        //Fill password

        this.setPassword(strPasword);

        //Click Login button

        this.clickLogin();        
    }

}
