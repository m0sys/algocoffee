package com.m0.algo.collections;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueLLTest {
  @Test
  public void testQueueDequeue() {
    QueueLL<Integer> q = new QueueLL<>();

    for (int i = 0; i < 20; i++) q.enqueue(i);
    assertEquals(20, q.size());

    for (int i = 0; i < 20; i++) assertEquals(i, (int) q.dequeue());
  }

  @Test
  public void testOverflowCapabilities() {
    int N = Short.MAX_VALUE;
    QueueLL<Integer> q = new QueueLL<>();

    for (int i = 0; i < N; i++) q.enqueue(i);
    assertEquals(N, q.size());

    for (int i = 0; i < N; i++) assertEquals(i, (int) q.dequeue());
  }
}
