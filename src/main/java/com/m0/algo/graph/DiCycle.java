package com.m0.algo.graph;

import com.m0.algo.collections.StkLL;

/*
 * Sedgewick 4th Edition: S4.2 - Directed Graphs
 */

/*
 * Check whether a Digraph contains a cycle.
 */
public class DiCycle {
  private boolean[] visited;
  private int[] edgeTo;
  private StkLL<Integer> cycle;
  private boolean[] onStk;

  public DiCycle(Digraph G) {
    onStk = new boolean[G.V()];
    edgeTo = new int[G.V()];
    visited = new boolean[G.V()];
    for (int v = 0; v < G.V(); v++) if (!visited[v]) dfs(G, v);
  }

  private void dfs(Digraph G, int v) {
    onStk[v] = true;
    visited[v] = true;
    for (int w : G.adj(v))
      if (this.hasCycle()) return;
      else if (!visited[w]) {
        edgeTo[w] = v;
        dfs(G, w);
      } else if (onStk[w]) {
        /* Create the cycle by back-tracking through edgeTo to find path. */
        cycle = new StkLL<>();
        for (int x = v; x != w; x = edgeTo[x]) cycle.push(x);
        cycle.push(w);
        cycle.push(v);
      }
    onStk[v] = false;
  }

  public boolean hasCycle() {
    return cycle != null;
  }

  public Iterable<Integer> cycle() {
    return cycle;
  }
}
