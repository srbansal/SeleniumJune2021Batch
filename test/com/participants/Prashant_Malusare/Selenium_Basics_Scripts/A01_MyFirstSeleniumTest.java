package script.basis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A01_MyFirstSeleniumTest {

	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("Hello Selenium(SE)");
		WebDriver driver;
		
		String baseUrl="https://www.google.com/";
		String expectedTitle="Google";
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(baseUrl);
		
		String actualTitle=driver.getTitle();
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Title Matched: TC Passed");
		}
		else
		{
			System.out.println("Title NOT Matched: TC Failed");
		}
//-------------------------		
/*		
		WebElement element =driver.findElement(By.name("q"));
		element.sendKeys("Selenium");
		//element.sendKeys(Keys.ESCAPE);
		//element.sendKeys(Keys.TAB);

		
		//driver.findElement(By.name("btnk")).click();
		driver.findElement(By.name("btnk")).submit();
		
	*/	
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Wikipedia.org");
		driver.findElement(By.name("btnK")).submit();

		Thread.sleep(4000);
//		driver.get(baseUrl);//not allowed after close/ quit
		driver.quit();

//        System.out.println(driver.getTitle();//not allowed after close/quite)
	}

}
