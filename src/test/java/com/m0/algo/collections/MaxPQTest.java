package com.m0.algo.collections;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxPQTest {
  private final int MAX_N = 16;

  @Test
  public void testIsEmpty() {
    MaxPQ pq = new MaxPQ<Integer>(MAX_N);
    assertTrue(pq.isEmpty());
    pq.insert(20);
    assertFalse(pq.isEmpty());
  }

  @Test
  public void testSize() {
    MaxPQ pq = new MaxPQ<Integer>(MAX_N);
    assertEquals(0, pq.size());
    for (int i = 0; i < MAX_N; i++) {
      pq.insert(i);
      assertEquals(i + 1, pq.size());
    }
  }

  @Test
  public void testInsertAndDelMax() {
    MaxPQ pq = new MaxPQ<Integer>(MAX_N);
    pq.insert(20);
    assertEquals(20, pq.delMax());
    pq.insert(100);
    pq.insert(20);
    pq.insert(40);
    assertEquals(100, pq.delMax());
    pq.insert(200);
    assertEquals(200, pq.delMax());
    assertEquals(40, pq.delMax());
    assertEquals(20, pq.delMax());
  }

  @Test
  public void testResizing() {
    int MAX_SZ = 1000;
    MaxPQ pq = new MaxPQ<Integer>();
    for (int i = 0; i < MAX_SZ; i++) {
      pq.insert(i);
    }

    int lastMax = Integer.MAX_VALUE;
    for (int i = 0; i < MAX_SZ; i++) {
      int newMax = (int) pq.delMax();
      assertTrue(lastMax > newMax);
      lastMax = newMax;
    }
  }
}
