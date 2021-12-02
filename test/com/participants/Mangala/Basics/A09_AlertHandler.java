package scripts.bascis;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A09_AlertHandler {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		  WebDriver driver;
	       System.setProperty("webdriver.chrome.driver","test/resources/chromedriver.exe");
	       driver=new ChromeDriver();
	       driver.get("http://demo.guru99.com/popup.php");			
	       driver.manage().window().maximize();		
	       driver.findElement(By.name("cusid")).sendKeys("12525");	//locating by id ann sending keys				
	        driver.findElement(By.name("submit")).submit();					
	              
	        Alert alert = driver.switchTo().alert();// Switching to alert popup		
	        		
	            
	        //String alertMessage= driver.switchTo().alert().getText();	// getting text present in alert dailogue box	
	        String alertMessage= alert.getText();	
	        
	        System.out.println(alertMessage);	
	        Thread.sleep(5000);
	        		
	        alert.accept();//Accepting alert message
			
	        driver.close();
	}

}
