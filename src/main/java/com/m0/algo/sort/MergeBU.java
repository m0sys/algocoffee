package com.m0.algo.sort;

/*
 * Sedgewick 4th Edition: S2.1 - Elementary Sorts
 */

/*
 * MergeBU sort merges pairs of elements together and increases the size of
 * the merge window by 2 on each pass until it reaches the point where it merges
 * to half arrays together.
 */

public class MergeBU extends GenericSort {
  private static Comparable[] aux;

  public static void sort(Comparable[] a) {
    int N = a.length;
    aux = new Comparable[N];

    for (int sz = 1; sz < N; sz *= 2)
      for (int lo = 0; lo < N - sz; lo += 2 * sz)
        merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
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
