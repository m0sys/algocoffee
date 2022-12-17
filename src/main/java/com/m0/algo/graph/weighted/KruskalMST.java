package com.m0.algo.graph.weighted;

import com.m0.algo.collections.MinPQ;
import com.m0.algo.collections.QueueLL;
import edu.princeton.cs.algs4.UF;

/*
 * Sedgewick 4th Edition: S4.3 - Minimum Spanning Trees
 */

public class KruskalMST {
  private QueueLL<Edge> mst;

  public KruskalMST(EdgeWeightedGraph G) {
    mst = new QueueLL<>();
    MinPQ<Edge> pq = new MinPQ<>(G.edges());
    /* TODO: provide own implementation of UF. */
    UF uf = new UF(G.V());

    while (!pq.isEmpty() && mst.size() < G.V() - 1) {
      Edge e = pq.delMin();
      int v = e.either(), w = e.other(v);
      if (uf.connected(v, w)) continue;
      uf.union(v, w);
      mst.enqueue(e);
    }
  }

  public Iterable<Edge> edges() {
    return mst;
  }

  public double weight() {
    /* TODO: see exercise 4.3.31. */
    return -1.0;
  }
}
