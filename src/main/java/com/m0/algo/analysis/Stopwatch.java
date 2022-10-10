package com.m0.algo.analysis;

public class Stopwatch {
  private final long start;

  public Stopwatch() {
    start = System.currentTimeMillis();
  }

  public double elapsedTime() {
    return (System.currentTimeMillis() - start) / 1000.0;
  }
}
