package com.m0.algo.search;
import com.m0.algo.analysis.Counter;
import java.util.Arrays;

public class BinarySearch {
  public static int rank(int key, int[] a) {
    int lo = 0;
    int hi = a.length - 1;

    Counter cnt = new Counter("Binary Search");
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;

      if (a[mid] == key) {
        System.out.println(cnt);
        return mid;
      } else if (a[mid] > key)
        hi = mid - 1;
      else
        lo = mid + 1;

      cnt.incr();
    }

    System.out.println(cnt);
    return -1;
  }

  public static void main(String[] args) {
    int N = 20;
    int factor = 200;
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
      BinarySearch.rank(arr[i], arr);
  }
}
