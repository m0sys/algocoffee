package com.m0.algo.graph.weighted;

import com.m0.algo.collections.MinPQ;
import com.m0.algo.collections.QueueLL;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*
 * Sedgewick 4th Edition: S4.3 - Minimum Spanning Trees
 */

public class LazyPrimMST {
  private boolean[] marked;
  private QueueLL<Edge> mst;
  private MinPQ<Edge> pq;

  public LazyPrimMST(EdgeWeightedGraph G) {
    pq = new MinPQ<>();
    marked = new boolean[G.V()];
    mst = new QueueLL<>();
    visit(G, 0);

    while (!pq.isEmpty()) {
      Edge e = pq.delMin();
      int v = e.either(), w = e.other(v);
      if (marked[v] && marked[w]) continue; // skip ineligible edges
      mst.enqueue(e);
      if (!marked[v]) visit(G, v);
      if (!marked[w]) visit(G, w);
    }
  }

  private void visit(EdgeWeightedGraph G, int v) {
    /* Mark v and add to pq all edges from v to unmarked vertices. */
    marked[v] = true;
    for (Edge e : G.adj(v)) if (!marked[e.other(v)]) pq.insert(e);
  }

  public Iterable<Edge> edges() {
    return mst;
  }

  public double weight() {
    double total = 0.0;
    for (Edge e : mst) total += e.weight();
    return total;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    EdgeWeightedGraph G = new EdgeWeightedGraph(in);

    LazyPrimMST mst = new LazyPrimMST(G);
    for (Edge e : mst.edges()) StdOut.println(e);
    StdOut.println(mst.weight());
  }
}
