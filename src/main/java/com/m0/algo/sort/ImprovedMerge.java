package com.m0.algo.sort;

/*
 * Sedgewick 4th Edition: S2.2 - Merge Sort
 *
 * Problem 2.2.11: Improvements. Implement the three improvements to mergesort
 * that are described in the text on page 275: Add a cutoff for small
 * subarrays, test whether the array is already in order, and avoid the copy by
 * switching arguments in the recursive code.
 */

public class ImprovedMerge extends GenericSort {

  public static void sort(Comparable[] a) {
    int len = a.length;
    /* Add cutoff to improve merge sort by 10% for small arrays. */
    if (len < 16) {
      Insertion.sort(a);
      return;
    }

    var aux = a.clone();
    sort(aux, a, 0, len - 1);
  }

  private static void sort(Comparable[] src, Comparable[] dst, int lo, int hi) {
    if (hi <= lo) return;

    int mid = lo + (hi - lo) / 2;
    sort(dst, src, lo, mid);
    sort(dst, src, mid + 1, hi);
    /*
     * Skip merging if largest left hand side is less than or equal to smallest
     * right hand side
     */
    // if (equal(a[mid], a[mid + 1]) || less(a[mid], a[mid + 1])) return;
    merge(src, dst, lo, mid, hi);
  }

  private static void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {
    int i = lo, j = mid + 1;

    /* Copy the partically sorted array into the aux array. */
    // for (int k = lo; k <= hi; k++) aux[k] = a[k];

    /* Merge back the aux into the array in sorted order. */
    for (int k = lo; k <= hi; k++)
      if (i > mid) // left half is exhausted
      dst[k] = src[j++];
      else if (j > hi) // right half is exhausted
      dst[k] = src[i++];
      else if (less(src[j], src[i])) dst[k] = src[j++];
      else dst[k] = src[i++];
  }

  public static void main(String[] args) {
    String[] a = {
      "M", "E", "R", "G", "E", "S", "O", "R",
      "T", "E", "X", "A", "M", "P", "L", "E"
    };
    sort(a);
    assert isSorted(a);
    show(a);

    /* String less than 15. */
    String[] a2 = {"H", "E", "L", "L", "O"};
    sort(a2);
    assert isSorted(a2);
    show(a2);

    /* Already sorted list. */
    String[] a3 = {"A", "B", "C", "D", "E", "F", "G"};
    sort(a3);
    assert isSorted(a3);
    show(a3);
  }
}
