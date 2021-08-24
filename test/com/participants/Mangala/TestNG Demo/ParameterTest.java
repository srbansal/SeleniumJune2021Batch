package scripts.TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class ParameterTest {
	@Parameters({"suite=param"})
  @Test(description="Taking parms")
  public void f(String param) {
		System.out.println("Parameter value:"+ param);
  }
}
