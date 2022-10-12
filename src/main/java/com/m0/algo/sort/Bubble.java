package com.m0.algo.sort;

/*
 * Sedgewick 4th Edition: S2.1 - Elementary Sorts
 */

/*
 * Bubble up the largest elem to the end of the array.
 */
public class Bubble extends GenericSort {
  public static void sort(Comparable[] a) {
    /* Sort a[] in increasing order. */
    final int N = a.length;

    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        if (less(a[j], a[i])) exch(a, i, j);
      }
    }
  }

  public static void main(String[] args) {
    String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
    sort(a);
    assert isSorted(a);
    show(a);
  }
}
