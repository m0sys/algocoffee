package com.m0.algo.search.hash;

import com.m0.algo.collections.BagLL;
import edu.princeton.cs.algs4.SequentialSearchST;

/*
 * Sedgewick 4th Edition: S3.4 - Hash Tables
 */

public class SeparateChainingHashST<Key, Value> {
  private int N; //  num key-val pairs
  private int M; // hash table sz
  private SequentialSearchST<Key, Value>[] st; // arr of ST objs

  public SeparateChainingHashST() {
    this(997);
  }

  public SeparateChainingHashST(int M) {
    /* Create M linked lists. */
    this.M = M;

    st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];

    for (int i = 0; i < M; i++) st[i] = new SequentialSearchST<>();
  }

  private int hash(Key key) {
    return (key.hashCode() & 0x7fffffff) % M;
  }

  public Value get(Key key) {
    return (Value) st[hash(key)].get(key);
  }

  public void put(Key key, Value val) {
    st[hash(key)].put(key, val);
  }

  public Iterable<Key> keys() {
    BagLL<Key> b = new BagLL<>();

    for (int i = 0; i < M; i++) {
      var curr_st = st[i];
      for (var k : curr_st.keys()) b.add(k);
    }

    return b;
  }

  public void deletee(Key key) {
    st[hash(key)].delete(key);
  }
}
