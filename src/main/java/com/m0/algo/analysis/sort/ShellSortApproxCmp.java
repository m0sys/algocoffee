package com.m0.algo.analysis.sort;

import com.m0.algo.analysis.Stopwatch;
import com.m0.algo.sort.ShellSortArr;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
 * Sedgewick 4th Edition: S2.1 - Elementary Sorts
 *
 * Problem 2.1.12: Instrument shell sort to print the number of compares divided
 * by the array size for each increment. Write a test client that tests the
 * hypothesis that this number is a small constant, by sorting arrays of random
 * Double values, using array sizes that are increasing powers of 10, starting
 * at 100.
 */

public class ShellSortApproxCmp {
  public static double timeRandomInput(int N, int T) {
    double total = 0.0;
    Double[] a = new Double[N];

    for (int t = 0; t < T; t++) {
      for (int i = 0; i < N; i++) a[i] = StdRandom.uniform();

      Stopwatch timer = new Stopwatch();
      ShellSortArr.sort(a);
      total += timer.elapsedTime();
    }

    return total / T;
  }

  public static void main(String[] args) {
    int N = 100;
    while (true) {
      StdOut.printf("Avg Shell Sort Time: %.1f", timeRandomInput(N, 10));
      N *= 10;
    }
  }
}
