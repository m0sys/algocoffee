package com.m0.algo.analysis.sort;

import com.m0.algo.analysis.SortCompare;

/*
 * Sedgewick 4th Edition: S2.1 - Elementary Sorts
 *
 * Problem 2.1.27: Shellsort is subquadratic. Use SortCompare to compare
 * shellsort with insertion sort and selection sort on your computer. Use array
 * sizes that are increasing powers of 2, starting at 128.
 */

public class ShellCompare {
  public static void main(String[] args) {
    int N = 128;
    while (true) {
      SortCompare.main(
          new String[] {"Shell", "Insertion", Integer.toString(N), Integer.toString(10)});
      SortCompare.main(
          new String[] {"Shell", "Selection", Integer.toString(N), Integer.toString(10)});
      SortCompare.main(new String[] {"Shell", "Merge", Integer.toString(N), Integer.toString(10)});

      N *= 2;
    }
  }
}
