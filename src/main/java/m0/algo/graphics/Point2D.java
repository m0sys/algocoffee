package com.m0.algo.graphics;

/*
 * Sedgewick 4th Edition: S1.2 - Data Abstraction
 *
 * Problem 1.2.1: Write a Point2D client that takes an integer value N from the
 * command line, generates N random points in the unit square, and computes the
 * distance separating the closest pair of points.
 */

// import edu.princeton.cs.algs4.StdDraw;
import java.lang.Math;

public class Point2D {
  /* Member variables. */
  private final double x;
  private final double y;

  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double x() { return x; }
  public double y() { return y; }

  public double r() { return Math.sqrt(x * x + y * y); }
  public double theta() { return Math.atan(y / x); }

  public double distTo(Point2D other) {
    return Math.sqrt(Square(x - other.x) + Square(y - other.y));
  }

  public void draw() {
    //
    // StdDraw.point(x, y);
  }

  private static double Square(double a) { return a * a; }

  public static void main(String[] args) {
    Point2D p = new Point2D(0, 0);
    Point2D p2 = new Point2D(2, 1);
    Point2D p3 = new Point2D(1, 2);

    p.draw();
    p2.draw();
    p3.draw();

    while (true) {
    }
  }
}
