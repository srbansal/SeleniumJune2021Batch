package com.participants.sakshi;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class JsonDemo {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException, IOException, ParseException {
	  readWriteJSON();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
	  System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.get("http://demowebshop.tricentis.com");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	//  driver.close();
  }

  
  public String login(String username, String password) throws InterruptedException {
	  driver.findElement(By.linkText("Log in")).click();
	  driver.findElement(By.name("Email")).sendKeys(username);
	  driver.findElement(By.name("Password")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@class='button-1 login-button' and @value='Log in']")).click();

	  if(driver.findElements(By.xpath("//input[@id='vote-poll-1']")).size()>0)
	  {
	  String uname = driver.findElement(By.xpath("//a[@href='/customer/info']")) .getText();
	  if(uname.equals(username))
	  driver.findElement(By.xpath("//a[@href='/logout']")).click();
	  }
	  else 
	  {
	  driver.findElement(By.xpath("//a[@href='/login']")).click();
	  return "Invalid User";
	  }
	  return "Valid User";
	  }

	  @SuppressWarnings("unchecked")
	  public void readWriteJSON() throws InterruptedException, IOException, ParseException {
	  JSONParser jsonParser = new JSONParser();
	  try  {
	  FileReader reader = new FileReader("C:\\Users\\SAKSHI ANAND DHAMNE\\Desktop\\Testdata.json");
	  //Read JSON file
	              Object obj = jsonParser.parse(reader);
	              JSONArray usersList = (JSONArray) obj;
	              System.out.println(usersList); //This prints the entire json file
	              for(int i=0;i<usersList.size();i++) {
	              JSONObject users = (JSONObject) usersList.get(i);
	              System.out.println(users);//This prints every block - one json object
	              JSONObject user = (JSONObject) users.get("users");
	              System.out.println(user); //This prints each data in the block
	              String username = (String) user.get("username");
	              String password = (String) user.get("password");
	              String result = login(username,password);
	              user.put("result", result);

	              //Write JSON file
	                  try (FileWriter file = new FileWriter("C:\\Users\\SAKSHI ANAND DHAMNE\\Desktop\\Testdata1.json")) {
	                      file.append(usersList.toJSONString());
	                      file.flush();
	                  } catch (IOException e) {
	                      e.printStackTrace();
	                  }
	              System.out.println(user);
	               }
	           } catch (FileNotFoundException e) {
	  e.printStackTrace();
	  }
	  }
}
