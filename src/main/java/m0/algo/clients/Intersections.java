package com.m0.algo.clients;

/*
 * Sedgewick 4th Edition: S1.2 - Data Abstraction
 *
 * Problem 1.2.2: Write an Interval1D client that takes an int value N as
 * command-line argument, reads N intervals (each defined by a pair of double
 * values) from standard input, and prints all pairs that intersect.
 */

import com.m0.algo.graphics.Interval1D;
import java.util.Scanner;

/*
 * Find N intersections in O(n2).
 */
public class Intersections {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Please enter 1 int command line argument.");
      System.out.println("e.g. java Intersections 10");
      return;
    }

    Scanner input = new Scanner(System.in);
    int N = Integer.parseInt(args[0]);

    Interval1D[] ivs = new Interval1D[N];

    for (int i = 0; i < N; i++) {
      System.out.printf("%d: Enter hi: ", i);
      double hi = input.nextDouble();
      System.out.printf("\n%d: Enter lo: ", i);
      double lo = input.nextDouble();
      ivs[i] = new Interval1D(hi, lo);
    }

    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        if (i != j && ivs[i].intersects(ivs[j]))
          System.out.println(ivs[i] + " intersects with " + ivs[j]);
  }
}
