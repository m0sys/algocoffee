package com.m0.algo.analysis.sort;

import com.m0.algo.analysis.SortCompare;

/*
 * Sedgewick 4th Edition: S2.2 - Merge Sort
 *
 *
 * Compare improvements of merge sort with vanilla merge sort.
 */

public class MergeCompare {
  public static void main(String[] args) {
    int N = 128;

    while (true) {
      SortCompare.main(
          new String[] {"ImprovedMerge", "Merge", Integer.toString(N), Integer.toString(10)});
      N *= 2;
    }
  }
}
