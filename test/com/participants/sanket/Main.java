package com.participants.sanket;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		WebDriver driver;
		String baseUrl = PropertyFileReader.getProperties("url");
//		String title = PropertyFileReader.getProperties("title");
		System.out.println("Which Browser You Want to Open?");	
		String op = sc.next();
		String browser;
		System.setProperty("webdriver.chrome.driver", "test/resources/chromedriver.exe");
		if(op.equals("chrome")) {
			browser = PropertyFileReader.getProperties("browser");
		}else {
			browser = PropertyFileReader.getProperties("browser1");
		}
		driver=new ChromeDriver();
		driver = new FirefoxDriver();
		driver.get("https://www.google.com");
	}

}
