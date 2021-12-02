package script.basis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class A14_CreateProfileFF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
				
		FirefoxOptions options = new FirefoxOptions();
		ProfilesIni myprofileini = new ProfilesIni();
		FirefoxProfile myprofile = myprofileini.getProfile("Selenium_FirefoxFox");
		options.setProfile(myprofile);
		System.setProperty("webdriver.gecko.driver", "test/resources/geckodriver.exe");
		//driver = new FirefoxDriver(options);
		
		
		WebDriver driver=new FirefoxDriver(options);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
				
				
		
		
		

	}

}


/*
 -------------
 create profile in FF
 ----
 go to firefox
 then type at search bar about:profiles(ignore pop up as not now)
 then create a new  profile or you can use already created
 
 
 
 */
