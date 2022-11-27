package com.m0.algo.graph;

import com.m0.algo.collections.BagLL;

/*
 * Sedgewick 4th Edition: S4.2 - Directed Graphs
 *
 * Problem 4.2.7: Write a program Degrees.java.
 */

public class Degrees {
  private Digraph G;

  public Degrees(Digraph G) {
    this.G = G;
  }

  public int indegree(int v) {
    int cnt = 0;
    for (int e = 0; e < G.V(); e++) {
      if (e != v)
        for (int w : G.adj(e)) {
          if (w == v) cnt++;
        }
    }

    return cnt;
  }

  public int outdegree(int v) {
    int cnt = 0;
    for (int w : G.adj(v)) cnt++;
    return cnt;
  }

  public Iterable<Integer> srcs() {
    BagLL<Integer> bg = new BagLL<>();
    for (int v = 0; v < G.V(); v++) if (indegree(v) == 0) bg.add(v);
    return bg;
  }

  public Iterable<Integer> sinks() {
    BagLL<Integer> bg = new BagLL<>();
    for (int v = 0; v < G.V(); v++) if (outdegree(v) == 0) bg.add(v);
    return bg;
  }

  public boolean isMap() {
    BagLL<Integer> bg = new BagLL<>();
    for (int v = 0; v < G.V(); v++) if (outdegree(v) == 1) bg.add(v);
    return bg.size() == G.V();
  }
}
