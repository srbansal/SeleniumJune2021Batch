package scripts.basics;

import org.testng.annotations.Test;

public class GroupTest {
  @Test(groups= {"group1","group2"})
  public void t12() {
  System.out.println("T12");
  }
  @Test(groups= {"group2","group3"})
  public void t23() {
  System.out.println("T23");
  }
  @Test(groups= {"group3","group1"})
  public void t31() {
  System.out.println("T31");
  }
}
