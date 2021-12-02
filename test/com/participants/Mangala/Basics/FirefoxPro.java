package scripts.bascis;
import  org.openqa.selenium.WebDriver;
import  org.openqa.selenium.firefox.FirefoxDriver;
import  org.openqa.selenium.firefox.FirefoxOptions;
import  org.openqa.selenium.firefox.ProfilesIni;
import  org.openqa.selenium.firefox.FirefoxProfile;
public class FirefoxPro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
         ProfilesIni myprofileini=new ProfilesIni ();
         FirefoxProfile myprofile= myprofileini.getProfile("ProfileQA");
         FirefoxOptions options =new  FirefoxOptions();
         options.setProfile(myprofile);
         
         System.setProperty("webdriver.gecko.driver","test/resources/geckodriver.exe");
         WebDriver driver=new FirefoxDriver(options);
         driver.get("https://www.google.com");
         
	}

}
