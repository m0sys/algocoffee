package com.m0.algo.graph;

import edu.princeton.cs.algs4.StdOut;

/*
 * Sedgewick 4th Edition: S4.2 - Directed Graphs
 */

/*
 * Solves the constrain scheduling problem by giving an order sequence of verts.
 */
public class Topological {
  private Iterable<Integer> order;

  public Topological(Digraph G) {
    DiCycle cyclefinder = new DiCycle(G);
    if (!cyclefinder.hasCycle()) {
      DepthFirstOrder dfs = new DepthFirstOrder(G);
      order = dfs.revPost();
    }
  }

  public Iterable<Integer> order() {
    return order;
  }

  public boolean isDAG() {
    return order == null;
  }

  public static void main(String[] args) {
    String fname = args[0];
    String delim = args[1];
    SymbolDigraph sg = new SymbolDigraph(fname, delim);
    Topological top = new Topological(sg.G());
    for (int v : top.order()) StdOut.println(sg.name(v));
  }
}
