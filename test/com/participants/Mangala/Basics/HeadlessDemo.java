package scripts.bascis;

import  org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class HeadlessDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver","test/resources/chromedriver.exe");
		 ChromeOptions options = new ChromeOptions();
	        
	        //add the headless argument
	        options.addArguments("headless");
	        
	        //pass the options parameter in the Chrome driver declaration
	        WebDriver driver = new ChromeDriver(options);
	        
	     
	        driver.get("https://www.google.com");
	        
	        //Print the Title of the Page
	        System.out.println("Title of the page is -> " + driver.getTitle());
	        
	        //Close the driver
	        driver.close();

	}

}
