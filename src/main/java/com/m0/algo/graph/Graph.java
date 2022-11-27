package com.m0.algo.graph;

import com.m0.algo.collections.BagLL;
import com.m0.algo.collections.StkLL;
import edu.princeton.cs.algs4.In;

/*
 * Sedgewick 4th Edition: S4.1 - Undirected Graphs
 */

/*
 * Implementation of AdjLst representation of an Undirected Graph.
 */
public class Graph {

  private final int V; // num vertices
  private int E; // num edges
  private BagLL<Integer>[] adj;

  public Graph(int V) {
    this.V = V;
    this.E = 0;
    adj = (BagLL<Integer>[]) new BagLL[V];

    for (int v = 0; v < V; v++) adj[v] = new BagLL<Integer>();
  }

  public Graph(Graph g) {
    this.V = g.V;
    this.E = g.E;

    this.adj = (BagLL<Integer>[]) new BagLL[V];
    for (int v = 0; v < V; v++) adj[v] = new BagLL<>();

    /* Add edges. */
    for (int v = 0; v < V; v++) {
      StkLL<Integer> stk = new StkLL<>();
      /* NOTE: bag inserts in rev order so have to rev order to get match. */
      for (int w : g.adj(v)) {
        stk.push(w);
      }
      while (!stk.isEmpty()) {
        adj[v].add(stk.pop());
      }
    }
  }

  public Graph(In in) {
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
    /* Don't allow self loops and parallel edges. */
    if (v == w) return;
    /* NOTE: this makes addEdge O(E) instead of O(1). */
    for (int e : adj[v]) {
      if (w == e) return;
    }

    adj[v].add(w);
    adj[w].add(v);
    E++;
  }

  public boolean hasEdge(int v, int w) {
    boolean found = false;
    var adjlst = adj[v];
    for (int e : adjlst) if (w == e) found = true;
    return found;
  }

  public int degree(int v) {
    int deg = 0;
    var adjlst = adj[v];
    for (int w : adjlst) deg++;
    return deg;
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

  public Iterable<Integer> adj(int v) {
    return adj[v];
  }
}
