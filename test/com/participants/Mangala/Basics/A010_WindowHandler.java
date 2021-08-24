package scripts.bascis;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A010_WindowHandler {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.out.println("Hello Welcome to window handler");
	       WebDriver driver;
	       System.setProperty("webdriver.chrome.driver","test/resources/chromedriver.exe");
	       driver=new ChromeDriver();
	       driver.get("http://demo.guru99.com/popup.php");			
	       driver.manage().window().maximize();		
	                		
	       driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();			
	        		
	        String MainWindow=driver.getWindowHandle();		
	        System.out.println("Main window id:"+MainWindow);	
	        System.out.println("Main window Title:"+driver.getTitle());
	        // To handle all new opened window.				
	           Set<String> s1=driver.getWindowHandles();		
	          Iterator<String> i1=s1.iterator();		
	         
	        while(i1.hasNext())			
	        {		
	            String ChildWindow=i1.next();		
	            
	            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
	            {    		
	                 
	                    // Switching to Child window
	                    driver.switchTo().window(ChildWindow);	                                                                                                           
	                    driver.findElement(By.name("emailid"))
	                    .sendKeys("gaurav.3n@gmail.com"); 
	                    Thread.sleep(3000);                   
	                    driver.findElement(By.name("btnLogin")).click();			
	                    Thread.sleep(3000);    
	                    System.out.println("Child window id:"+ChildWindow);
	                    System.out.println("Child window Title:"+driver.getTitle());
				// Closing the Child Window.
	                        driver.close();		
	            }		
	        }		
	       
	        // Switching to Parent window i.e Main Window.
	            driver.switchTo().window(MainWindow);
	}

}
