package com.m0.algo.search;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Test;

public class BinarySearchTest {
  @Test
  public void testRank() {
    int N = 20;
    int factor = 1000000;
    int arr[] = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = (int)(factor * Math.random());
    }

    for (int i = 0; i < N; i++)
      System.out.printf("%d ", arr[i]);
    System.out.printf("\n");

    Arrays.sort(arr);
    for (int i = 0; i < N; i++)
      System.out.printf("%d ", arr[i]);
    System.out.printf("\n");

    for (int i = 0; i < N; i++)
      assertEquals(i, BinarySearch.rank(arr[i], arr));
  }
}
