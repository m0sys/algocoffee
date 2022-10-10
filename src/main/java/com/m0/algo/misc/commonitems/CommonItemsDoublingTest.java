package com.m0.algo.misc.commonitems;

import com.m0.algo.analysis.Stopwatch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class CommonItemsDoublingTest {
  public static double timeTrial(int N) {
    int MAX = 1000000;
    int[] a1 = new int[N];
    int[] a2 = new int[N];

    /* Run trial data size N. */
    for (int i = 0; i < N; i++) {
      a1[i] = StdRandom.uniform(-MAX, MAX);
      a2[i] = StdRandom.uniform(-MAX, MAX);
    }

    /* Sort the arrays. */
    Arrays.sort(a1);
    Arrays.sort(a2);

    Stopwatch timer = new Stopwatch();
    CommonItems.printCommon(a1, a2);

    return timer.elapsedTime();
  }

  public static void main(String[] args) {
    for (int N = 250; true; N += N) {
      double time = timeTrial(N);
      StdOut.printf("%7d %5.1f\n", N, time);
    }
  }
}
