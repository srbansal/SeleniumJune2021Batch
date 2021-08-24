package com.participants.sanket;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParams {
  @Parameters({"suite-param"})
  @Test(description="Search on google")
  public void f(String param) {
	  System.out.print("parameter value : "+param);
  }
}
