package com.m0.algo.graphics;

// import edu.princeton.cs.algs4.StdDraw;

/*
 * Sedgewick 4th Edition: S1.2 - Data Abstraction
 *
 * Problem 1.2.2: Write an Interval1D client that takes an int value N as
 * command-line argument, reads N intervals (each defined by a pair of double
 * values) from standard input, and prints all pairs that intersect.
 */

public class Interval1D {
  /* Member vars */
  final double lo;
  final double hi;

  public Interval1D(double lo, double hi) {
    this.lo = lo;
    this.hi = hi;
  }

  public double length() { return hi - lo; }

  public boolean contains(double x) { return x <= hi && x >= lo; }
  public boolean intersects(Interval1D other) {
    return contains(other.hi) || contains(other.lo);
  }

  public String toString() { return "[" + lo + ", " + hi + "]"; }

  public void draw() {
    //
    // StdDraw.line(lo, 0, hi, 0);
  }
}
