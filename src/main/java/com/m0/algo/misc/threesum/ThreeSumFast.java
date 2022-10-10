package com.m0.algo.misc.threesum;

import com.m0.algo.search.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/*
 * Sedgewick 4th Edition: S1.4 - Analysis of Algorithms
 */

public class ThreeSumFast {
  public static int cnt(int[] a) {
    // System.out.println("Running ThreeSumFast!");
    Arrays.sort(a);
    int N = a.length;
    int cnt = 0;
    for (int i = 0; i < N; i++)
      for (int j = i + 1; j < N; j++) if (BinarySearch.rank(-a[i] - a[j], a) > j) cnt++;
    return cnt;
  }

  public static void main(String[] args) {
    int a[] = new In(args[0]).readAllInts();
    StdOut.println(cnt(a));
  }
}
