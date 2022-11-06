package com.m0.algo.collections;

/*
 * Sedgewick 4th Edition: S2.4 - Priority Queue
 */

/*
 * Implementation of a Min Priority Queue.
 *
 *
 * Class Invariant: parent(k) <= left(k) && parent(k) <= right(k) for all
 * k in range(1, N).
 */

public class MinPQ<Key extends Comparable<Key>> {
  private Key[] pq;
  private int N = 0;

  public MinPQ(int maxN) {
    pq = (Key[]) new Comparable[maxN + 1];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void insert(Key k) {
    /* TODO: add resizing code + bound checking. */
    pq[++N] = k;
    swim(N);
  }

  public Key delMin() {
    Key min = pq[1];
    exch(1, N--);
    pq[N + 1] = null;
    sink(1);
    return min;
  }

  private boolean greater(int i, int j) {
    return pq[i].compareTo(pq[j]) > 0;
  }

  private void exch(int i, int j) {
    Key tmp = pq[i];
    pq[i] = pq[j];
    pq[j] = pq[i];
  }

  private void swim(int k) {
    while (k > 1 && greater(parent(k), k)) {
      exch(parent(k), k);
      k = parent(k);
    }
  }

  private void sink(int k) {
    while (left(k) <= N) {
      int j = left(k);
      if (j < N && greater(j, j + 1)) j++;
      exch(j, k);
      k = j;
    }
  }

  private int parent(int k) {
    return k / 2;
  }

  private int left(int k) {
    return 2 * k;
  }
}
