package scripts.bascis;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class A01_MySeleniumTest {

	public static void main(String[] args)  throws IOException, 
	 InterruptedException
	{
		// TODO Auto-generated method stub
       System.out.println("Hello Selenium(SE)");
       WebDriver driver;
       System.setProperty("webdriver.chrome.driver","test/resources/chromedriver.exe");
       driver=new ChromeDriver();
       String baseURL="https://www.google.com";
       driver.get(baseURL);
      /* String actualTitle=driver.getTitle();
     
       if(actualTitle.equals(expectedTitle))
       {
    	   System.out.println("Title Matched: TC Passed");
    	   
       }
       else
       {
    	   System.out.println("Title not Matched: TC Failed"); 
       }
       
       
       WebElement element= driver.findElement(By.name("q"));
       element.sendKeys("Selenium");
       element.sendKeys(keys.TAB);
       element.sendKeys(Keys.ESCAPE);
       
       driver.findElement(By.name("btnK")).click(); */
       
       
       Thread.sleep(3000);
       
       
       driver.quit();

	}
 
}
