package scripts.basics;

import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class ParaDataPro {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  Reporter.log("Executing test no: "+n+" data: "+s);
	  System.out.println("test no: "+n+" data: "+s);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
      new Object[] { 3, "c" },
    };
  }
}
