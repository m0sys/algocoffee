package com.m0.algo.analysis;

import com.m0.algo.sort.FastMerge;
import com.m0.algo.sort.ImprovedMerge;
import com.m0.algo.sort.ImprovedQuick;
import com.m0.algo.sort.Insertion;
import com.m0.algo.sort.Merge;
import com.m0.algo.sort.Quick;
import com.m0.algo.sort.Selection;
import com.m0.algo.sort.ShellSort;
import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.QuickX;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
 * Sedgewick 4th Edition: S2.1 - Elementary Sorts
 */

public class SortCompare {

  public static double time(String alg, Double[] a) {
    Stopwatch timer = new Stopwatch();
    if (alg.equals("Insertion")) Insertion.sort(a);
    if (alg.equals("Selection")) Selection.sort(a);
    if (alg.equals("Shell")) ShellSort.sort(a);
    if (alg.equals("Merge")) Merge.sort(a);
    if (alg.equals("FastMerge")) FastMerge.sort(a);
    if (alg.equals("ImprovedMerge")) ImprovedMerge.sort(a);
    if (alg.equals("Quick")) Quick.sort(a);
    if (alg.equals("ImprovedQuick")) ImprovedQuick.sort(a);
    if (alg.equals("QuickX")) QuickX.sort(a);
    if (alg.equals("Heap")) Heap.sort(a);

    return timer.elapsedTime();
  }

  public static double timeRandomInput(String alg, int N, int T) {
    double total = 0.0;
    Double[] a = new Double[N];

    for (int t = 0; t < T; t++) {
      for (int i = 0; i < N; i++) a[i] = StdRandom.uniform();
      total += time(alg, a);
    }
    return total;
  }

  public static void main(String[] args) {
    String alg1 = args[0];
    String alg2 = args[1];

    int N = Integer.parseInt(args[2]);
    int T = Integer.parseInt(args[3]);

    double t1 = timeRandomInput(alg1, N, T);
    double t2 = timeRandomInput(alg2, N, T);
    StdOut.printf("For %d random Doubles\n  %s is", N, alg1);
    StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
  }
}
