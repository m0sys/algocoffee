package com.m0.algo.sort;
/*
 * Sedgewick 4th Edition: S2.1 - Elementary Sorts
 */

/*
 * Shell sort uses Insertion sort to sort the array at h increments appart.
 * This results in h partially sorted subsequences. Eventually, h is reduced to
 * 1 resulting in the array being fully sorted.
 */

public class ShellSort extends GenericSort {
  public static void sort(Comparable[] a) {
    int N = a.length;
    int h = 1;
    while (h < N / 3) h = 3 * h + 1;
    while (h >= 1) {
      for (int i = h; i < N; i++) {
        for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
          exch(a, j, j - h);
        }
      }
      h = h / 3;
    }
  }

  public static void main(String[] args) {
    String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
    sort(a);
    assert isSorted(a);
    show(a);
  }
}
