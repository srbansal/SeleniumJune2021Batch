package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BrowserDriver.BrowserFactory;
import pages.YahooLogin_PF;

public class Yahoo_Login_Test_PF {

	@Test
	public void loginToYahoo()
	{
		WebDriver driver=BrowserFactory.startBrowser("https://login.yahoo.com/");
		YahooLogin_PF login=PageFactory.initElements(driver, YahooLogin_PF.class);//.class-returns bytecode
		
		login.yahoologin("pratibha2399@yahoo.com", "Password@2399");
		
		
	}
}
