package com.m0.algo.sort;
/*
 * Sedgewick 4th Edition: S2.1 - Elementary Sorts
 */

/*
 * Selection sort is called as so because it interatively selects the next
 * smallest item within the unsorted list and adds it to the sorted part of
 * list.
 */
public class Selection extends GenericSort {
  /* FIXME: Comparable is raw type (warning). */
  public static void sort(Comparable[] a) {
    /* Sort a[] in increasing order. */
    final int N = a.length;
    for (int i = 0; i < N; i++) {
      var min = i;
      for (int j = i + 1; j < N; j++) {
        if (less(a[j], a[min])) min = j;
        exch(a, i, min);
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
