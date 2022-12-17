package com.m0.algo.graph.weighted;

import com.m0.algo.collections.QueueLL;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

/*
 * Sedgewick 4th Edition: S4.3 - Minimum Spanning Trees
 */

/* Implement of eager version of Prim's MST algorithm. */
public class PrimMST {
  private Edge[] edgeTo;
  private double[] distTo;
  private boolean[] marked;
  /* TODO: provide own implementation of IndexMinPQ. */
  private IndexMinPQ<Double> pq;
  private QueueLL<Edge> mst;
  private double totalWeight = 0.0;

  public PrimMST(EdgeWeightedGraph G) {
    edgeTo = new Edge[G.V()];
    distTo = new double[G.V()];
    marked = new boolean[G.V()];
    mst = new QueueLL<>();
    for (int v = 0; v < G.V(); v++)
      distTo[v] = Double.POSITIVE_INFINITY; // no path eq. high impedence.
    pq = new IndexMinPQ<>(G.V());
    distTo[0] = 0.0;
    pq.insert(0, 0.0);
    while (!pq.isEmpty()) {
      int w = pq.delMin();
      if (w != 0) {

        mst.enqueue(edgeTo[w]);
        totalWeight += distTo[w];
      }
      visit(G, w); // add closest vertex to tree
    }
  }

  private void visit(EdgeWeightedGraph G, int v) {
    marked[v] = true;
    for (Edge e : G.adj(v)) {
      int w = e.other(v);
      if (marked[w]) continue; // v-w is ineligible
      if (e.weight() < distTo[w]) {
        /* Edge e is the new best connection from tree to w. */
        edgeTo[w] = e;
        distTo[w] = e.weight();
        if (pq.contains(w)) pq.changeKey(w, distTo[w]);
        else pq.insert(w, distTo[w]);
      }
    }
  }

  public Iterable<Edge> edges() {
    return mst;
  }

  public double weight() {
    return totalWeight;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    EdgeWeightedGraph G = new EdgeWeightedGraph(in);

    PrimMST mst = new PrimMST(G);
    for (Edge e : mst.edges()) StdOut.println(e);
    StdOut.println(mst.weight());
  }
}
