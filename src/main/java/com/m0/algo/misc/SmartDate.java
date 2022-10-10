package com.m0.algo.misc;

/*
 * Sedgewick 4th Edition: S1.2 - Data Abstraction
 *
 * Problem 1.2.11: Develop an implementation SmartDate of our Date API that
 * raises an exception if the date is not legal.
 */


public class SmartDate extends Date {

  public SmartDate(int m, int d, int y) {
    super(m, d, y);
    if (m < 0 || m > 12)
      throw new IllegalArgumentException("error: month has to be between 1 and 12");

    if (d < 0 || d > 31)
      throw new IllegalArgumentException("error: year has to be between 1 and 31");
  }
}
