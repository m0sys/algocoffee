package com.m0.algo.graph.weighted;

/*
 * Sedgewick 4th Edition: S4.4 - Shortest Paths
 */

public class DiEdge {
  private final int v;
  private final int w;
  private final double weight;

  public DiEdge(int v, int w, double weight) {
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  public double weight() {
    return weight;
  }

  public int from() {
    return v;
  }

  public int to() {
    return w;
  }

  public int compareTo(DiEdge that) {
    if (this.weight < that.weight) return -1;
    else if (this.weight > that.weight) return +1;
    else return 0;
  }

  public String toString() {
    return String.format("%d-%d %.2f", v, w, weight);
  }
}
