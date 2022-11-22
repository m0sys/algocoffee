package com.m0.algo.sort;

/*
 * Sedgewick 4th Edition: S2.4 - Priority Queue
 */

/*
 * Implementation of HeapSort using Sinking for greater efficiency.
 */

public class HeapSort extends GenericSort {

  public static void sort(Comparable[] a) {
    int N = a.length;
    /* TODO: get rid of the +1 wasted storage. */
    /* Create the heap from right to left skipping the first half of singles. */
    for (int k = N / 2; k >= 1; k--) {
      sink(a, k, N);
    }

    /* Sort while heapifying. */
    while (N > 1) {
      exch(a, 1, N--);
      sink(a, 1, N);
    }
  }

  private static void sink(Comparable[] a, int k, int N) {
    while (left(k) <= N) {
      int j = left(k);
      if (j < N && less(a, j, j + 1)) j++;
      if (!less(a, k, j)) break;
      exch(a, j, k);
      k = j;
    }
  }

  private static int parent(int k) {
    return k / 2;
  }

  private static int left(int k) {
    return 2 * k;
  }

  private static boolean less(Comparable[] a, int i, int j) {
    return a[i - 1].compareTo(a[j - 1]) < 0;
  }

  protected static void exch(Comparable[] a, int i, int j) {
    Comparable t = a[i - 1];
    a[i - 1] = a[j - 1];
    a[j - 1] = t;
  }

  public static void main(String[] args) {
    String[] a = {"P", "R", "I", "O", "R", "I", "T", "Y", "Q", "U", "E", "U", "E"};
    sort(a);
    assert isSorted(a);
    show(a);
  }
}
