package com.m0.algo.sort;

/*
 * Sedgewick 4th Edition: S2.2 - Merge Sort
 *
 * FIXME: seems like its not working at all.
 *
 * Problem 2.2.10: Faster merge. Implement a version of merge() that copies the
 * second half of a[] to aux[] in decreasing order and then does the merge back
 * to a[]. This change allows you to remove the code to test that each of the
 * halves has been exhausted from the inner loop. Note: The resulting sort is
 * not stable (see page 341).
 */

public class FastMerge extends GenericSort {
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

    System.out.println("Printing a before copy...");
    for (int k = lo; k <= hi; k++) {
      System.out.print(a[k]);
      System.out.print(" ");
    }
    System.out.println();
    /* Copy the partically sorted array into the aux array. */

    /* Copy first half in asc. */
    for (int k = lo; k <= mid; k++) aux[k] = a[k];
    /* Copy second half in desc. */
    for (int k = hi, k2 = j; k >= j; k--, k2++) aux[k2] = a[k];

    System.out.println("Printing aux after copy...");
    for (int k = lo; k <= hi; k++) {
      System.out.print(aux[k]);
      System.out.print(" ");
    }
    System.out.println("\n");

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
