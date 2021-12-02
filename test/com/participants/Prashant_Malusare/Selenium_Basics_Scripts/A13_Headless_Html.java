package script.basis;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
public class A15_Headless_Html {

	public static void main(String[] args) 
	{
	    // Declaring and initializing the HtmlUnitWebDriver 

		HtmlUnitDriver unitDriver = new HtmlUnitDriver(); // open demo site web page 
		unitDriver.get("https://demoqa.com/"); //Print the title of the page
		System.out.println("Title of the page is -> " + unitDriver.getTitle()); 
		System.setProperty("webdriver.chrome.driver", "Test/resources/chromedriver.exe"); //create object of chrome options
		
		
		ChromeOptions options = new ChromeOptions(); //add the headless argument
		options.addArguments("headless"); //pass the options parameter in the Chrome driver declaration 
		WebDriver driver = new ChromeDriver(options); //Navigate to toolsQA site URL
		driver.get("https://google.com/"); //Print the Title of the Page 
		System.out.println("Title of the page is -> " + driver.getTitle()); 
		
	}


}


