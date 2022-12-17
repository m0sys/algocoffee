package com.m0.algo.graph.weighted;

import com.m0.algo.collections.StkLL;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

/*
 * Sedgewick 4th Edition: S4.4 - Shortest Paths
 */

public class DijkstraSP {
  private DiEdge[] edgeTo;
  private double[] distTo;
  private IndexMinPQ<Double> pq;

  public DijkstraSP(EdgeWeightedDigraph G, int s) {
    edgeTo = new DiEdge[G.V()];
    distTo = new double[G.V()];
    pq = new IndexMinPQ<>(G.V());

    for (int v = 0; v < G.V(); v++) distTo[v] = Double.POSITIVE_INFINITY;
    distTo[s] = 0.0;

    pq.insert(s, 0.0);
    while (!pq.isEmpty()) relax(G, pq.delMin());
  }

  private void relax(EdgeWeightedDigraph G, int v) {
    for (var e : G.adj(v)) {
      int w = e.to();
      if (distTo[w] > distTo[v] + e.weight()) {
        distTo[w] = distTo[v] + e.weight();
        edgeTo[w] = e;

        if (pq.contains(w)) pq.changeKey(w, distTo[w]);
        else pq.insert(w, distTo[w]);
      }
    }
  }

  public double distTo(int v) {
    return distTo[v];
  }

  public boolean hasPathTo(int v) {
    return distTo[v] < Double.POSITIVE_INFINITY;
  }

  public Iterable<DiEdge> pathTo(int v) {
    if (!hasPathTo(v)) return null;

    StkLL<DiEdge> path = new StkLL<>();

    for (var e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
      path.push(e);
    }

    return path;
  }

  public static void main(String[] args) {
    EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));
    int s = Integer.parseInt(args[1]);
    DijkstraSP sp = new DijkstraSP(G, s);

    for (int t = 0; t < G.V(); t++) {
      StdOut.print(s + " to " + t);
      StdOut.printf(" (%4.2f): ", sp.distTo(t));
      if (sp.hasPathTo(t)) for (var e : sp.pathTo(t)) StdOut.print(e + "  ");
      StdOut.println();
    }
  }
}
