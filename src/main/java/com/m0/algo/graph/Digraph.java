package com.m0.algo.graph;

import com.m0.algo.collections.BagLL;
import edu.princeton.cs.algs4.In;

/*
 * Sedgewick 4th Edition: S4.2 - Directed Graphs
 */

/*
 * Implementation of AdjLst representation of a Directed Graph.
 */
public class Digraph {
  private final int V;
  private int E;
  private BagLL<Integer>[] adj;

  public Digraph(int V) {
    this.V = V;
    this.E = 0;
    adj = (BagLL<Integer>[]) new BagLL[V];

    for (int v = 0; v < V; v++) adj[v] = new BagLL<Integer>();
  }

  public Digraph(In in) {
    this(in.readInt()); // read V and construct this graph.
    int E = in.readInt();
    for (int i = 0; i < E; i++) {
      /* Add an edge. */
      int v = in.readInt();
      int w = in.readInt();
      addEdge(v, w);
    }
  }

  public int V() {
    return V;
  }

  public int E() {
    return E;
  }

  public void addEdge(int v, int w) {
    adj[v].add(w);
    E++;
  }

  public String toString() {
    String s = V + " vertices, " + E + " edges\n";

    for (int v = 0; v < V; v++) {
      s += v + ": ";
      var lst = adj[v];
      for (int w : lst) s += w + " ";
      s += "\n";
    }

    return s;
  }

  public Digraph reverse() {
    Digraph R = new Digraph(V);
    for (int v = 0; v < V; v++) for (int w : adj(v)) R.addEdge(w, v);
    return R;
  }

  public Iterable<Integer> adj(int v) {
    return adj[v];
  }
}
