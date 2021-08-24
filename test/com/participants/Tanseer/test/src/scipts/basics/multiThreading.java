package scipts.basics;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class multiThreading {
  @Test
  public void f() {
	  System.out.println("Thread id of f:"+Thread.currentThread().getId());
  }@Test
  public void f2() {
	  System.out.println("Thread id of f2:"+Thread.currentThread().getId());
  }

}
