package com.teams.team5.webelements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_CheckBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String url = "http://cookbook.seleniumacademy.com/Config.html";
		
		
		System.setProperty("webdriver.chrome.driver","test/resources/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		
	    driver.manage().window().maximize();

	    driver.get(url);
	    
	    
	    //selecting
	    driver.findElement(By.name("abs")).click();
	    driver.findElement(By.name("airbags")).click();
	    driver.findElement(By.name("parksensor")).click();

	    
	    Thread t = new Thread();
	    try {
			t.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    //deselecting
	    driver.findElement(By.name("airbags")).click();
	   
	    try {
			t.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver.quit();
		
		


	}

}



