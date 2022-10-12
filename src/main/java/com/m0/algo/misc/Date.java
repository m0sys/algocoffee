package com.m0.algo.misc;

/*
 * Sedgewick 4th Edition: S1.2 - Data Abstraction
 *
 * Problem 1.2.11: Develop an implementation SmartDate of our Date API that
 * raises an exception if the date is not legal.
 */

public class Date implements Comparable<Date> {
  private final int month;
  private final int day;
  private final int year;

  public Date(int m, int d, int y) {
    month = m;
    day = d;
    year = y;
  }

  public int month() {
    return month;
  }

  public int day() {
    return day;
  }

  public int year() {
    return year;
  }

  public int compareTo(Date other) {
    if (this.year > other.year) return +1;
    if (this.year < other.year) return -1;
    if (this.month > other.month) return +1;
    if (this.month < other.month) return -1;
    if (this.day > other.day) return +1;
    if (this.day < other.day) return -1;
    return 0;
  }

  public String toString() {
    return month() + "/" + day() + "/" + year();
  }
}
