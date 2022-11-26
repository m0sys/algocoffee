package com.m0.algo.clients;
/*
 * Sedgewick 4th Edition: S4.1 - Undirected Graphs
 */

import com.m0.algo.graph.DepthFirstSearch;
import com.m0.algo.graph.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*
 * Test client for testing graph search.
 */

public class TestSearch {
  public static void main(String[] args) {
    Graph graph = new Graph(new In(args[0]));
    int s = Integer.parseInt(args[1]);
    DepthFirstSearch search = new DepthFirstSearch(graph, s);

    for (int v = 0; v < graph.V(); v++) {
      if (search.marked(v)) StdOut.print(v + " ");
    }
    StdOut.println();

    if (search.count() != graph.V()) StdOut.print("NOT ");
    StdOut.println("connected");
  }
}
