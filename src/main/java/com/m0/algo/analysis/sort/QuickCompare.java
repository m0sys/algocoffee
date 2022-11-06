package com.m0.algo.analysis.sort;

import com.m0.algo.analysis.SortCompare;

/*
 * Sedgewick 4th Edition: S2.3 - Quick Sort
 *
 *
 * Compare improvements of quick sort with vanilla merge sort and other quicks.
 */

public class QuickCompare {
  public static void main(String[] args) {
    int N = 128;

    while (true) {
      SortCompare.main(new String[] {"Quick", "Merge", Integer.toString(N), Integer.toString(10)});
      N *= 2;
      SortCompare.main(
          new String[] {"Quick", "ImprovedQuick", Integer.toString(N), Integer.toString(10)});
      SortCompare.main(new String[] {"Quick", "QuickX", Integer.toString(N), Integer.toString(10)});
      N *= 2;
    }
  }
}
