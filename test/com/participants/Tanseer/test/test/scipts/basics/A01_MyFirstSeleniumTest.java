package scipts.basics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A01_MyFirstSeleniumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String baseUrl="https://www.google.com";
		String expectedTitle= "Google";
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(baseUrl);
		String actualTitle=driver.getTitle();
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Title Matched:TC passed");
		}
		else {
			System.out.println("Title NOT Matched:TC Failed");
		}
		//Thread.sleep(2000);
		driver.close();
	}

}
