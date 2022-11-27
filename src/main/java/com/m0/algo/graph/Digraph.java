package com.m0.algo.graph;

import com.m0.algo.collections.BagLL;
import com.m0.algo.collections.StkLL;
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

  public Digraph(Digraph g) {
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

  public boolean hasEdge(int v, int w) {
    boolean found = false;
    var adjlst = adj[v];
    for (int e : adjlst) if (w == e) found = true;
    return found;
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
