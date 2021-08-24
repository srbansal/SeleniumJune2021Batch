package scripts.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
  @Test (dataProvider = "dp")
  public void f(Integer n, String s) 
  {
	   System.out.println("Provided values are:"+n+" "+s);
  }
	 @DataProvider public Object[][] dp() 
	 { return new Object[][]
			 { new Object[] { 1, "a" },
		     new Object[] { 2, "b" }, };
			 }
	  
  }

