package com.m0.algo.graph;

/*
 * Sedgewick 4th Edition: S4.1 - Undirected Graphs
 */

/*
 * Check if Graph is Bipartite i.e. it is possible to color the graph into to
 * disjoint sets.
 */
public class TwoColor {
  private boolean[] visited;
  private boolean[] color;
  private boolean isTwoColorable = true;

  public TwoColor(Graph G) {
    visited = new boolean[G.V()];
    color = new boolean[G.V()];
    for (int s = 0; s < G.V(); s++) if (!visited[s]) dfs(G, s);
  }

  private void dfs(Graph G, int v) {
    visited[v] = true;
    for (int w : G.adj(v))
      if (!visited[w]) {
        color[w] = !color[v];
        dfs(G, w);
        /*
         * If already visited and has the same color it means that graph is not
         * bipartite i.e. there is an internal link in one of the disjoint sets.
         */
      } else if (color[w] == color[v]) isTwoColorable = false;
  }

  public boolean isBipartite() {
    return isTwoColorable;
  }
}
