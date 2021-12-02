package scripts.TestNG;

import org.testng.annotations.Test;

public class Multithread {
  @Test
  public void f() {
	  System.out.println("Thread of f:" +Thread.currentThread().getId());
	  
  }
  @Test
  public void f1() {
	  System.out.println("Thread of f:" +Thread.currentThread().getId());
	  
  }
}
