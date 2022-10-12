package com.m0.algo.sort;
/*
 * Sedgewick 4th Edition: S2.1 - Elementary Sorts
 */

/*
 * Insertion sort assumes that the left hand size of i is sorted, and inserts
 * new elem at index i from the right hand side into the already sorted array.
 */
public class Insertion extends GenericSort {
  public static void sort(Comparable[] a) {
    /* Sort a[] in increasing order. */
    final int N = a.length;
    for (int i = 1; i < N; i++) {
      for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) exch(a, j, j - 1);
    }
  }

  public static void main(String[] args) {
    String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
    sort(a);
    assert isSorted(a);
    show(a);
  }
}
