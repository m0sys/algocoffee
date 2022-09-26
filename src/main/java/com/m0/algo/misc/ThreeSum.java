package com.m0.algo.misc;

/*
 * Sedgewick 4th Edition: S1.4 - Analysis of Algorithms
 */

public class ThreeSum {
  public static int cnt(int[] a) {
    int N = a.length;
    int cnt = 0;
    for (int i = 0; i < N; i++)
      for (int j = i + 1; j < N; j++)
        for (int k = j + 1; k < N; k++) if (a[i] + a[j] + a[k] == 0) cnt++;
    return cnt;
  }
}
