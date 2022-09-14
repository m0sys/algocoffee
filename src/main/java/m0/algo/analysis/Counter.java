package com.m0.algo.analysis;

public class Counter {
  /* Member vars */
  private int cnt;
  private final String id;

  public Counter(String id) {
    this.id = id;
    cnt = 0;
  }
  public void incr() { cnt++; }
  public int tally() { return cnt; }

  public String toString() { return id + ": " + cnt; }
}
