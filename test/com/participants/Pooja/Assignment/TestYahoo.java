package com.participants.Pooja.Assignment;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.Assert;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import Assignment.HomePageYahoo;
import Assignment.LoginYahoo;

public class TestYahoo {

    String driverPath = "test/resources/chromedriver.exe";
    
    WebDriver driver;

    LoginYahoo objLogin;

    HomePageYahoo objHomePage;

    @BeforeTest

    public void setup(){

	System.setProperty("webdriver.chrome.driver", driverPath);
        
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://login.yahoo.com/");

    }

    /**

     * This test case will login in http://demo.guru99.com/V4/

     * Verify login page title as guru99 bank

     * Login to application

     * Verify the home page using Dashboard message
     * @throws InterruptedException 

     */

    @Test(priority=0)

    public void test_Home_Page_Appear_Correct() throws InterruptedException{

        //Create Login Page object

    objLogin = new LoginYahoo(driver);

    //Verify login page title

    String loginPageTitle = objLogin.getLoginTitle();

    Assert.assertTrue(loginPageTitle.toLowerCase().contains("Yahoo"));

    //login to application

    objLogin.loginToYahoo("poojashitole@yahoo.com", "prs25071999");

    // go the next page

    objHomePage = new HomePageYahoo(driver);

    //Verify home page

    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("Celebrating all the athletes competing in Tokyo. You inspire us!"));

    }
}