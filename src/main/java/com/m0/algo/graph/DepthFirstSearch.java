package com.m0.algo.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*
 * Sedgewick 4th Edition: S4.1 - Undirected Graphs
 */

/*
 * Implementation of the Depth First Search algorithm.
 */

public class DepthFirstSearch {
  private boolean[] visited;
  private int count;

  public DepthFirstSearch(Graph G, int s) {
    visited = new boolean[G.V()];
    dfs(G, s);
  }

  private void dfs(Graph G, int v) {
    visited[v] = true;
    count++;
    for (int w : G.adj(v)) if (!visited[w]) dfs(G, w);
  }

  public boolean marked(int w) {
    return visited[w];
  }

  public int count() {
    return count;
  }

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
