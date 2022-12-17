package com.m0.algo.graph.weighted;

import com.m0.algo.collections.BagLL;
import edu.princeton.cs.algs4.In;

/*
 * Sedgewick 4th Edition: S4.4 - Shortest Paths
 */

public class EdgeWeightedDigraph {
  private final int V;
  private int E;
  private BagLL<DiEdge>[] adj;

  public EdgeWeightedDigraph(int V) {
    this.V = V;
    this.E = 0;
    adj = (BagLL<DiEdge>[]) new BagLL[V];
    for (int v = 0; v < V; v++) adj[v] = new BagLL<>();
  }

  public EdgeWeightedDigraph(In in) {
    this(in.readInt());
    int E = in.readInt();
    for (int i = 0; i < E; i++) {
      /* Add a weighted edge. */
      int v = in.readInt();
      int w = in.readInt();
      double weight = in.readDouble();
      var e = new DiEdge(v, w, weight);
      addEdge(e);
    }
  }

  public int V() {
    return V;
  }

  public int E() {
    return E;
  }

  public void addEdge(DiEdge e) {
    adj[e.from()].add(e);
    E++;
  }

  public Iterable<DiEdge> adj(int v) {
    return adj[v];
  }

  public Iterable<DiEdge> edges() {
    BagLL<DiEdge> b = new BagLL<>();
    for (int v = 0; v < V; v++) for (DiEdge e : adj[v]) b.add(e);
    return b;
  }
}
