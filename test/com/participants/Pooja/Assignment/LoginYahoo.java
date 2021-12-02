package com.participants.Pooja.Assignment;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class LoginYahoo {

    WebDriver driver;

    By UserNameYahoo = By.name("login-username");

    By PasswordYahoo = By.name("login-passwd");

    By titleText =By.className("logo");

    By signin = By.name("login-signin");

    public LoginYahoo(WebDriver driver){

        this.driver = driver;

    }

    //Set user name in textbox

    public void setUserName(String strUserName){

        driver.findElement(UserNameYahoo).sendKeys(strUserName);

    }

    //Set password in password textbox

    public void setPassword(String strPassword){

         driver.findElement(PasswordYahoo).sendKeys(strPassword);

    }

    //Click on login button

    public void clickLogin(){

            driver.findElement(signin).click();

    }

    //Get the title of Login Page

    public String getLoginTitle(){

     return    driver.findElement(titleText).getText();

    }

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return
     * @throws InterruptedException 

     */

    public void loginToYahoo(String strUserName,String strPasword) throws InterruptedException{

        //Fill user name
    	Thread.sleep(5000);
        this.setUserName(strUserName);

        //Fill password
        this.clickLogin();  
        Thread.sleep(5000);
        this.setPassword(strPasword);

        //Click Login button

        this.clickLogin();        
    }

}
