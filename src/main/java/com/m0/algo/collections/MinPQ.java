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

  public MinPQ() {
    pq = (Key[]) new Comparable[1];
  }

  public MinPQ(Iterable<Key> it) {
    this();
    for (Key k : it) insert(k);
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void insert(Key k) {
    if (N == pq.length) resize(2 * pq.length);
    pq[N] = k;
    swim(N);
    N++;
  }

  public Key delMin() {
    Key max = pq[0];
    exch(0, --N);
    pq[N] = null;
    if (N > 0 && N == pq.length / 4) resize(pq.length / 2);
    sink(0);
    return max;
  }

  private void exch(int i, int j) {
    Key tmp = pq[i];
    pq[i] = pq[j];
    pq[j] = tmp;
  }

  private void swim(int k) {

    while (k > 0 && greater(parent(k), k)) {
      exch(parent(k), k);
      k = parent(k);
    }
  }

  private void sink(int k) {
    while (left(k) < N) {
      int j = left(k);
      if (j < N - 1 && greater(j, j + 1)) j++;
      if (!greater(k, j)) break;
      exch(j, k);
      k = j;
    }
  }

  private int parent(int k) {
    return (k - 1) / 2;
  }

  private int left(int k) {
    return 2 * k + 1;
  }

  private void resize(int sz) {
    Key[] tmp = (Key[]) new Comparable[sz];
    for (int i = 0; i < N; i++) tmp[i] = pq[i];
    pq = tmp;
  }

  private boolean greater(int i, int j) {
    return pq[i].compareTo(pq[j]) > 0;
  }
}
