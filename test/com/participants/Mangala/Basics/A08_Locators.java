package scripts.bascis;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
public class A08_Locators {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		// TODO Auto-generated method stub
		   WebDriver driver;
	       System.setProperty("webdriver.chrome.driver","test/resources/chromedriver.exe");
	       driver=new ChromeDriver();
		   List<WebElement> links= driver.findElements(By.tagName("a"));
        
        int i= links.size();
        System.out.println(i);
        
        for(int j=0; j<i; j++)
        {
            
            System.out.println(links.get(j).getText());
        }
        driver.findElement(By.className("download-link mzp-c-button mzp-t-product mzp-t-xl")).click();   
      
		Dimension size =driver.manage().window().getSize();
		driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.navigate().back();
        
        Thread.sleep(2000);
        driver.navigate().forward();
        
        Thread.sleep(2000);
        driver.navigate().refresh();
        
        Thread.sleep(2000);

        
        Thread.sleep(2000);
        driver.manage().window().setSize(size);
        String currenturl =driver.getCurrentUrl();
        String pagesource=driver.getPageSource();
  		//2.ById
  		System.out.println(currenturl+" "+pagesource.charAt(0));
  	      driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");
  	      
  			Thread.sleep(2000);
  			driver.findElement(By.cssSelector(("body"))).sendKeys(Keys.CONTROL+"T");
  			Thread.sleep(2000);
  			
        
        driver.close();
	
	}

}
