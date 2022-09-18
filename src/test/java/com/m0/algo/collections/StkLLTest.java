package com.m0.algo.collections;

import static org.junit.Assert.*;

import org.junit.Test;

public class StkLLTest {
  @Test
  public void testPushAndPop() {
    StkLL<Integer> stk = new StkLL<Integer>();

    for (int i = 0; i < 20; i++) stk.push(i);
    assertEquals(20, stk.size());

    for (int i = 19; i > 0; i--) assertEquals(i, (int) stk.pop());
  }

  @Test
  public void testOverflowCapabilities() {
    int N = Short.MAX_VALUE;
    StkLL<Integer> stk = new StkLL<Integer>();

    for (int i = 0; i < N; i++) stk.push(i);
    assertEquals(N, stk.size());

    for (int i = N - 1; i > 0; i--) assertEquals(i, (int) stk.pop());
  }

  @Test
  public void testPeek() {

    StkLL<Integer> stk = new StkLL<Integer>();

    for (int i = 0; i < 20; i++) stk.push(i);
    assertEquals(20, stk.size());

    assertEquals(19, (int) stk.peek());
    assertEquals(20, stk.size());
  }
}
