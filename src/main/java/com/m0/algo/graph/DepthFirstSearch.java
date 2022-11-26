package com.m0.algo.graph;

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
}
