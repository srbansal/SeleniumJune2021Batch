package ThreadConcept;

import org.testng.annotations.Test;

public class TestParallelOne {
  @Test
  public void testCaseOne() {
	  System.out.println("Test case 1: "+Thread.currentThread().getId());
  }
  
  @Test
  public void testCaseTwo() {
	  System.out.println("Test case 2: "+Thread.currentThread().getId());

  }
}
