package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YahooHomepage {
	WebDriver driver;

   // By homePageUserName = By.xpath("//table//tr[@class='heading3']");
	//By homePageUserName = By.xpath("*[@id='ybar-logo']/img[1]");
	//By homePageUserName = By.xpath("/html/body/header/div[2]/div/div/div/div/div[3]/div/div[1]/a/img[1]");
	By homePageUserName= By.className("_yb_t7pjx _yb_y53cg _yb_1fiyi");
	//String webEle=driver.getTitle();

    

    public YahooHomepage(WebDriver driver){

        this.driver = driver;

    }

    //Get the User name from Home Page

        public String getHomePageDashboardUserName(){

        return    driver.findElement(homePageUserName).getText();
        	//return driver.getTitle();

        }

}
