package com.m0.algo.misc;

/*
 * Sedgewick 4th Edition: S1.2 - Data Abstraction
 *
 * Problem 1.2.11: Develop an implementation SmartDate of our Date API that
 * raises an exception if the date is not legal.
 */

public class Date {
  private final int month;
  private final int day;
  private final int year;

  public Date(int m, int d, int y) {
    month = m;
    day = d;
    year = y;
  }

  public int month() { return month; }

  public int day() { return day; }

  public int year() { return year; }

  public String toString() { return month() + "/" + day() + "/" + year(); }
}
