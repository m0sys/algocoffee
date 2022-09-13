package com.m0.algo.graphics;

import static org.junit.Assert.*;

import org.junit.Test;

public class Interval1DTest {
  @Test
  public void verifyNoExceptionThrownOnInit() {
    Interval1D iv = new Interval1D(0, 10);
  }

  @Test
  public void testLength() {
    Interval1D iv = new Interval1D(0, 10);
    Interval1D iv2 = new Interval1D(0, 1);
    Interval1D iv3 = new Interval1D(0, 0);

    /* Test values. */
    assertEquals(10, iv.length(), 0);
    assertEquals(1, iv2.length(), 0);
    assertEquals(0, iv3.length(), 0);
  }

  @Test
  public void testContains() {
    Interval1D iv = new Interval1D(0, 10);
    Interval1D iv2 = new Interval1D(0, 1);
    Interval1D iv3 = new Interval1D(0, 0);

    /* Test values. */
    assertEquals(true, iv.contains(1));
    assertEquals(true, iv2.contains(1));
    assertEquals(false, iv3.contains(1));
  }

  @Test
  public void testIntersects() {
    Interval1D iv = new Interval1D(0, 10);
    Interval1D iv2 = new Interval1D(5, 15);
    Interval1D iv3 = new Interval1D(-10, 4);

    /* Test values. */
    assertEquals(true, iv.intersects(iv2));
    assertEquals(true, iv.intersects(iv3));
    assertEquals(false, iv2.intersects(iv3));
  }
}
