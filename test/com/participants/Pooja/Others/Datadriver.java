package com.participants.Pooja.Others;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datadriver {
  @Test(dataProvider="dp")
  public void f(Integer n,String s) {
	  System.out.println("provided values are "+n+" "+s);
	  
  }
  
  @DataProvider
  public Object[][] dp(){
	  return new Object[][] {
		  new Object[] {1,"a"},
		  new Object[] {2,"b"}
	  };
  }
}
