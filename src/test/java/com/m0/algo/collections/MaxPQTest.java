package com.m0.algo.collections;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxPQTest {
  private final int MAX_N = 10;

  @Test
  public void testIsEmpty() {
    MaxPQ pq = new MaxPQ<Integer>(MAX_N);
    assertTrue(pq.isEmpty());
    pq.insert(20);
    assertFalse(pq.isEmpty());
  }
}
