package com.m0.algo.sort;

import edu.princeton.cs.algs4.StdOut;

/*
 * Sedgewick 4th Edition: S2.1 - Elementary Sorts
 *
 * Problem 2.1.11: Implement a version of shell sort that keeps the increment
 * sequence in an array,rather than computing it.
 */

public class ShellSortArr extends GenericSort {

  public static void sort(Comparable[] a) {

    int N = a.length;
    int[] arr = genSeq(N);

    int idx = 0;
    int h = arr[idx];
    while (h >= 1) {
      int numCmps = 0;
      for (int i = h; i < N; i++) {
        for (int j = i; j >= h && less(a[j], a[j - h]); j -= h, numCmps++) {
          exch(a, j, j - h);
        }
      }

      StdOut.printf("NumCmp for N = %d and h = %d is %d\n", N, h, numCmps / N);
      idx++;
      h = arr[idx];
    }
  }

  private static final int[] genSeq(int N) {
    int[] arr = new int[N / 3];
    int h = 1;

    while (h < N / 3) h = 3 * h + 1;
    int idx = 0;
    while (h >= 1) {
      arr[idx] = h;
      idx++;
      h /= 3;
    }
    return arr;
  }

  public static void main(String[] args) {
    String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
    sort(a);
    assert isSorted(a);
    show(a);
  }
}
