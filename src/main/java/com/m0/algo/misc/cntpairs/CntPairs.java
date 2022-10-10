package com.m0.algo.misc.cntpairs;

import com.m0.algo.search.BinarySearch;
import java.util.Arrays;

/*
 * Sedgewick 4th Edition: S1.4 - Analysis of Algorithms
 *
 * Problem 1.4.8: Write a program to determine the number pairs of values in an
 * input file that are equal. If your first try is quadratic, think again and
 * use Arrays.sort() to develop a linearithmic solution.
 */

/*
 * Count Pairs using O(NlogN) time.
 */

public class CntPairs {
  public static int cnt(int[] a) {
    Arrays.sort(a);
    int cnt = 0;
    int N = a.length;

    for (int i = 0; i < N; i++) {
      if (BinarySearch.rank(a[i], a) > i) cnt++;
    }

    return cnt;
  }
}
