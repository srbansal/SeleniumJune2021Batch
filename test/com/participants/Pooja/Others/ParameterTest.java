package com.participants.Pooja.Others;

import org.testng.annotations.Test;

import utilities.PropertyReader;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class ParameterTest {
	@Test  
	@Parameters("mango")  
	public void mango(String m)  
	{  
	System.out.println("Fruits names are:  ");  
	System.out.println(m);  
	}  
	@Test  
	@Parameters("orange")  
	public void orange(String o)  
	{  
	System.out.println(o);  
	}  
	
	@Test  
	@Parameters("Cauliflower")  
	public void c(String m)  
	{  
	System.out.println(m);  
	}  
	
	@Test  
	@Parameters("Ladyfinger")  
	public void L(String l)  
	{  	System.out.println("Vegetable names are :");  

	System.out.println(l);  
	}  
}