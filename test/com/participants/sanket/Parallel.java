package com.participants.sanket;

import org.testng.annotations.Test;

public class Parallel {
  @Test
  public void testOne() {
	  System.out.println("one "+ Thread.currentThread().getId());
  }
  @Test
  public void testTwo() {
	  System.out.println("two "+ Thread.currentThread().getId());
  }
}
