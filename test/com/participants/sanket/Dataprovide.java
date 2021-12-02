package com.participants.sanket;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class Dataprovide {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  System.out.println(n+" "+s);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 123, "abc" },
      new Object[] { 456, "def" },
    };
  }
}
