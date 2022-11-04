package com.m0.algo.sort;

/*
 * Sedgewick 4th Edition: S2.1 - Elementary Sorts
 */

/*
 * Merge sort recursively sorts the left and right half of an array and merges
 * them together into the final sorted array.
 */

public class Merge extends GenericSort {
  private static Comparable[] aux;

  public static void sort(Comparable[] a) {
    aux = new Comparable[a.length];
    sort(a, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) return;

    int mid = lo + (hi - lo) / 2;
    sort(a, lo, mid);
    sort(a, mid + 1, hi);
    merge(a, lo, mid, hi);
  }

  private static void merge(Comparable[] a, int lo, int mid, int hi) {
    int i = lo, j = mid + 1;

    /* Copy the partically sorted array into the aux array. */
    for (int k = lo; k <= hi; k++) aux[k] = a[k];

    /* Merge back the aux into the array in sorted order. */
    for (int k = lo; k <= hi; k++)
      if (i > mid) // left half is exhausted
      a[k] = aux[j++];
      else if (j > hi) // right half is exhausted
      a[k] = aux[i++];
      else if (less(aux[j], aux[i])) a[k] = aux[j++];
      else a[k] = aux[i++];
  }

  public static void main(String[] args) {
    String[] a = {
      "M", "E", "R", "G", "E", "S", "O", "R",
      "T", "E", "X", "A", "M", "P", "L", "E"
    };
    sort(a);
    assert isSorted(a);
    show(a);
  }
}
