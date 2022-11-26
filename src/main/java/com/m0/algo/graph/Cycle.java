package com.m0.algo.graph;

/*
 * Sedgewick 4th Edition: S4.1 - Undirected Graphs
 */

/*
 * Check if Graph is Acyclic.
 */
public class Cycle {
  private boolean[] visited;
  private boolean hasCycle;

  public Cycle(Graph G) {
    visited = new boolean[G.V()];
    for (int s = 0; s < G.V(); s++) if (!visited[s]) dfs(G, s, s);
  }

  private void dfs(Graph G, int v, int u) {
    visited[v] = true;
    for (int w : G.adj(v))
      if (!visited[w]) dfs(G, w, v);
      /*
       * If its already visited and is not a self loop it means there's a cycle.
       */
      else if (w != u) hasCycle = true;
  }

  public boolean hasCycle() {
    return hasCycle;
  }
}
