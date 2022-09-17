package com.m0.algo.collections;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResizingArrStkTest {
  @Test
  public void testPushAndPop() {
    ResizingArrStk<Integer> stk = new ResizingArrStk<Integer>();

    for (int i = 0; i < 20; i++) stk.push(i);
    assertEquals(20, stk.size());

    for (int i = 19; i > 0; i--) assertEquals(i, (int) stk.pop());
  }

  @Test
  public void testOverflowCapabilities() {
    int N = Short.MAX_VALUE;
    ResizingArrStk<Integer> stk = new ResizingArrStk<Integer>();

    for (int i = 0; i < N; i++) stk.push(i);
    assertEquals(N, stk.size());

    for (int i = N - 1; i > 0; i--) assertEquals(i, (int) stk.pop());
  }
}
