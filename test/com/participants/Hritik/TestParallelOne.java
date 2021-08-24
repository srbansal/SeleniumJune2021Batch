package scripts.basics;

import org.testng.annotations.Test;

public class TestParallelOne {
	  @Test
	  public void testOne() {
	      System.out.println("Test one thread id: " + Thread.currentThread().getId());
	  }
	  @Test
	  public void testTwo() {
	      System.out.println("Test two thread id: " + Thread.currentThread().getId());
	  }
	}