package com.persistent.vaibhav;

import org.testng.annotations.Test;

public class TestParallel {
	  @Test
	  public void testOne() {
	      System.out.println("Test one thread id: " + Thread.currentThread().getId());
	  }
	  @Test
	  public void testTwo() {
	      System.out.println("Test two thread id: " + Thread.currentThread().getId());
	  }
	}
