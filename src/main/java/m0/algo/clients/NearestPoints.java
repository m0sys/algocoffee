package com.m0.algo.clients;
/*
 * Sedgewick 4th Edition: S1.2 - Data Abstraction
 *
 * Problem 1.2.1: Write a Point2D client that takes an integer value N from the
 * command line, generates N random points in the unit square, and computes the
 * distance separating the closest pair of points.
 */

import com.m0.algo.graphics.Point2D;

/*
 * Computes the nearest pair of points in O(n^2).
 */

public class NearestPoints {

  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Please enter 1 int command line argument.");
      System.out.println("e.g. java NearestPoints 10");
      return;
    }

    final int N = Integer.parseInt((args[0]));

    Point2D[] points = new Point2D[N];

    // Fill up the arr with random points.
    for (int i = 0; i < N; i++)
      points[i] = new Point2D(Math.random(), Math.random());

    double bestDist = Double.POSITIVE_INFINITY;
    int bestI = 0;
    int bestJ = 0;
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        if (i != j) {
          double dist = points[i].distTo(points[j]);
          if (dist < bestDist) {
            bestDist = dist;
            bestI = i;
            bestJ = j;
          }
        }
    System.out.printf("(%d, %d): %.2f\n", bestI, bestJ, bestDist);
  }
}
