
package com.participants.kaushal;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;j
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Admin
 */
public class DDTUsingJSON {

    /**
     * @param args the command line arguments
     */
     static WebDriver driver;
        
    
    public static void main(String[] args) throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
        // TODO code application logic here
		System.setProperty("webdriver.chrome.driver", "Test/resources/chromedriver.exe");

    	driver= new ChromeDriver();
        driver.get("http://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        readWriteJSON();
        driver.close();    
    }
    static public void readWriteJSON() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
JSONParser jsonParser;
        jsonParser = new JSONParser();
try  {
FileReader reader = new FileReader("E:\\Selenium\\files\\Testdata.json");
//Read JSON file
            //Object obj = jsonParser.parse(reader);
            //JSONArray usersList = (JSONArray) obj;
            Object obj  = jsonParser.parse(reader);
            JSONArray usersList = new JSONArray();
            usersList.add(obj);
            System.out.println(usersList); //This prints the entire json file
            for(int i=0;i<usersList.size();i++) {
            JSONObject users= (JSONObject)usersList.get(i);
            System.out.println(users);//This prints every block - one json object
            JSONObject user = (JSONObject) users.get("users");
            System.out.println(user); //This prints each data in the block
            String username = (String) user.get("username");
            String password = (String) user.get("password");
            String result = login(username,password);
            user.put("result", result);

            //Write JSON file
                try (FileWriter file = new FileWriter("Testdata1.json")) {
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
static public String login(String username, String password) throws InterruptedException {
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

}
