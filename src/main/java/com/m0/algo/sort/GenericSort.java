package com.m0.algo.sort;

import edu.princeton.cs.algs4.StdOut;

public class GenericSort {

  protected static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  protected static boolean equal(Comparable v, Comparable w) {
    return v.compareTo(w) == 0;
  }

  protected static void exch(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  protected static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) StdOut.print(a[i] + " ");
    StdOut.println();
  }

  public static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) if (less(a[i], a[i - 1])) return false;
    return true;
  }
}
