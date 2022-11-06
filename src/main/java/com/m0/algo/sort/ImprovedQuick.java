package com.m0.algo.sort;

import edu.princeton.cs.algs4.StdRandom;

/*
 * Sedgewick 4th Edition: S2.3 - Quick Sort
 *
 * Problem 2.3.17: Sentinels. Modify the code in Algorithm 2.5 to remove both
 * bounds checks in the inner while loops.
 *
 * Problem 2.3.18: Median-of-3 partitioning. Add median-of-3 partitioning to
 * quicksort, as described in the text (see page 296). Run doubling tests to
 * determine the effectiveness of the change
 */

public class ImprovedQuick extends GenericSort {
  public static void sort(Comparable[] a) {
    StdRandom.shuffle(a);
    findRightSentinal(a);
    sort(a, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    /* Cutoff improvement. */
    /* TODO: finetune M to personal system */
    int M = 7;
    if (hi <= lo + M) {
      InternalInsertion.sort(a, lo, hi);
      return;
    }

    int j = partition(a, lo, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
  }

  private static int partition(Comparable[] a, int lo, int hi) {
    int i = lo, j = hi + 1;
    /* Median-of-3 improvement.*/

    InternalInsertion.sort(a, lo, lo + 2);
    exch(a, lo, lo + 1);
    var v = a[lo];

    while (true) {
      while (less(a[++i], v))
        ;

      while (less(v, a[--j]))
        ;
      if (i >= j) break;
      exch(a, i, j);
    }
    exch(a, lo, j);
    return j;
  }

  private static void findRightSentinal(Comparable[] a) {
    var max = a[0];
    int maxi = 0;
    var len = a.length;
    for (int i = 1; i < len; i++)
      if (less(max, a[i])) {

        max = a[i];
        maxi = i;
      }

    exch(a, maxi, a.length - 1);
  }

  private class InternalInsertion extends GenericSort {

    public static void sort(Comparable[] a, int lo, int hi) {
      /* Sort a[] in increasing order. */
      for (int i = lo; i <= hi; i++) {
        for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) exch(a, j, j - 1);
      }
    }
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
