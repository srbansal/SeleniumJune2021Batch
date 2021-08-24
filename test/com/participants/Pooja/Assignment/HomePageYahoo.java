package com.participants.Pooja.Assignment;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class HomePageYahoo {

    WebDriver driver;

    By homePageUserName = By.xpath("//*[@id=\"ybar-logo\"]/img[1]");

    

    public HomePageYahoo(WebDriver driver){

        this.driver = driver;

    }

    //Get the User name from Home Page

        public String getHomePageDashboardUserName(){

         return    driver.findElement(homePageUserName).getText();

        }

}

