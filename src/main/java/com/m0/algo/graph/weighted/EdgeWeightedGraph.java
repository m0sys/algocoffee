package com.m0.algo.graph.weighted;

import com.m0.algo.collections.BagLL;
import edu.princeton.cs.algs4.In;

/*
 * Sedgewick 4th Edition: S4.3 - Minimum Spanning Trees
 */

public class EdgeWeightedGraph {
  private final int V;
  private int E;
  private BagLL<Edge>[] adj;

  public EdgeWeightedGraph(int V) {
    this.V = V;
    this.E = 0;
    adj = (BagLL<Edge>[]) new BagLL[V];
    for (int v = 0; v < V; v++) adj[v] = new BagLL<>();
  }

  public EdgeWeightedGraph(In in) {
    this(in.readInt());
    int E = in.readInt();
    for (int i = 0; i < E; i++) {
      /* Add a weighted edge. */
      int v = in.readInt();
      int w = in.readInt();
      double weight = in.readDouble();
      var e = new Edge(v, w, weight);
      addEdge(e);
    }
  }

  public int V() {
    return V;
  }

  public int E() {
    return E;
  }

  public void addEdge(Edge e) {
    int v = e.either(), w = e.other(v);
    adj[v].add(e);
    adj[w].add(e);
    E++;
  }

  public Iterable<Edge> adj(int v) {
    return adj[v];
  }

  public Iterable<Edge> edges() {
    BagLL<Edge> b = new BagLL<>();
    for (int v = 0; v < V; v++) for (Edge e : adj[v]) if (e.other(v) > v) b.add(e);
    return b;
  }
}
