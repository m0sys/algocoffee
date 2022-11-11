package com.m0.algo.collections;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinPQTest {
  private final int MAX_N = 16;

  @Test
  public void testIsEmpty() {
    MinPQ pq = new MinPQ<Integer>(MAX_N);
    assertTrue(pq.isEmpty());
    pq.insert(20);
    assertFalse(pq.isEmpty());
  }

  @Test
  public void testSize() {
    MinPQ pq = new MinPQ<Integer>(MAX_N);
    assertEquals(0, pq.size());
    for (int i = 0; i < MAX_N; i++) {
      pq.insert(i);
      assertEquals(i + 1, pq.size());
    }
  }

  @Test
  public void testInsertAndDelMin() {
    MinPQ pq = new MinPQ<Integer>(MAX_N);
    pq.insert(20);
    assertEquals(20, pq.delMin());
    pq.insert(100);
    pq.insert(20);
    pq.insert(40);
    assertEquals(20, pq.delMin());
    pq.insert(200);
    assertEquals(40, pq.delMin());
    assertEquals(100, pq.delMin());
    assertEquals(200, pq.delMin());
  }
}
