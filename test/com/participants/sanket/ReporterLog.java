package com.participants.sanket;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReporterLog {
  @Test
  public void f() throws Exception{
	  String userName = "UserName";
	  String userPassword = "UserPassword";
	  Reporter.log("username : "+ userName+", Password : "+userPassword);
  }
}
