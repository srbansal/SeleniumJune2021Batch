package scripts.basics;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class A01_MySeleniumTest {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello Se");
		// TODO Auto-generated method stub
		WebDriver driver;
		String baseUrl="https://www.google.com/";
		String exp="Google";
		
		System.setProperty("webdriver.chrome.driver", "test/resource/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(baseUrl);
		String act=driver.getTitle();
		
		if(act.equals(exp))
		{
			System.out.println("Passes");
		}
		else
		{
			System.out.println("failed");
		}
		
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Selenium");
		element.sendKeys(Keys.TAB);
		
		driver.findElement(By.name("btnK")).submit();
		

		Thread.sleep(2000);
		driver.quit();
		

	}

}
