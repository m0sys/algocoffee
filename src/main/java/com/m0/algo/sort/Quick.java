package com.m0.algo.sort;

import edu.princeton.cs.algs4.StdRandom;

/*
 * Sedgewick 4th Edition: S2.3 - Quick Sort
 *
 * Problem 2.3.6: Write a program to compute the exact value of CN,and compare
 * the exact value with the approximation 2NlnN, for N = 100, 1,000, and 10,000.
 */

public class Quick extends GenericSort {
  // private static int cmp_cnt;

  public static void sort(Comparable[] a) {
    // cmp_cnt = 0;
    StdRandom.shuffle(a);
    sort(a, 0, a.length - 1);
    // StdOut.printf("Experimental Cmp = %d\n", cmp_cnt);
    // StdOut.printf("Theoretical Cmp = %.2f\n", 2 * a.length *
    // Math.log(a.length) / Math.log(2));
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) return;
    int j = partition(a, lo, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
  }

  private static int partition(Comparable[] a, int lo, int hi) {
    int i = lo, j = hi + 1;
    var v = a[lo];

    while (true) {
      while (less(a[++i], v)) {
        // cmp_cnt++;
        if (i == hi) break;
      }

      while (less(v, a[--j])) {
        // cmp_cnt++;
        if (j == lo) break;
      }
      if (i >= j) break;
      exch(a, i, j);
    }
    exch(a, lo, j);
    return j;
  }

  public static void main(String[] args) {
    String[] a = {
      "Q", "U", "I", "C", "K", "S", "O", "R",
      "T", "E", "X", "A", "M", "P", "L", "E"
    };
    sort(a);
    assert isSorted(a);
    show(a);
  }
}
