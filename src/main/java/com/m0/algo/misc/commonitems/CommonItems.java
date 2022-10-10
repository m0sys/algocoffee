package com.m0.algo.misc.commonitems;

/*
 * Sedgewick 4th Edition: S1.4 - Analysis of Algorithms
 *
 * Problem 1.4.12: Write a program that, given two sorted arrays of N int
 * values, prints all ele- ments that appear in both arrays, in sorted order.
 * The running time of your program should be proportional to N in the worst
 * case.
 */

import edu.princeton.cs.algs4.StdOut;

/*
 * Find all elements that are common between the two sorted arrays.
 */

public class CommonItems {
  /*
   * Precondition: a1, a2 must be sorted arrays of same length.
   */
  public static void printCommon(int a1[], int a2[]) {
    final int N = a1.length;

    /*
     * Since both arrays are of same length and sorted any item in common must
     * be in the same position as the other. Otherwise, there will exist some
     * other uncommon element that will fill up the space.
     */
    for (int i = 0; i < N; i++) {
      if (a1[i] == a2[i]) StdOut.printf("%d: %d is common!\n", i, a1[i]);
    }
  }
}
