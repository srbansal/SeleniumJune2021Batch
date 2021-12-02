package com.participants.sanket;

import java.io.File;

import java.io.FileReader;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class YahooLogin {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		FileReader read = new FileReader("C:\\Users\\91758\\eclipse-workspace\\SeleniumMav\\test\\files\\credentials.properties");
        prop.load(read);
        
        String getusername = prop.getProperty("username");
        String getPassword = prop.getProperty("password");
        String yahooName = prop.getProperty("yahoo");
        
		WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://login.yahoo.com");
		
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys(getusername);
		
		WebElement btnSubmit = driver.findElement(By.name("signin"));
		btnSubmit.click();
		
		Thread.sleep(2000);
		
		WebElement password = driver.findElement(By.id("login-passwd"));
		password.sendKeys(getPassword);
		
		WebElement btnSubmitP = driver.findElement(By.name("verifyPassword"));
		btnSubmitP.click();
		
		Thread.sleep(2000);
		
		String checkName = driver.getTitle();
		
	
		if(checkName.contains(getusername) || checkName.contains(yahooName)){
			System.out.println("Logged In Succesfully");
		}else {
			
			//we can make a method and call this code for reuse
			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
			String time = String.valueOf(System.currentTimeMillis());
			ImageIO.write(screenshot.getImage(), "jpg", new File("C:\\Users\\91758\\eclipse-workspace\\SeleniumMav\\"+time+".jpg"));
			
			
			System.out.println("Not able Log In");
		}

	}

}
