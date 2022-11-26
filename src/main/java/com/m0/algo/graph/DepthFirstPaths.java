package com.m0.algo.graph;

import com.m0.algo.collections.StkLL;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*
 * Sedgewick 4th Edition: S4.1 - Undirected Graphs
 */

/*
 * Find all paths rooted at s using dfs algorithm.
 */

public class DepthFirstPaths {
  private boolean[] visited;
  private int[] edgeTo; // last vertex on known path to this vertex
  private final int s;

  public DepthFirstPaths(Graph G, int s) {
    visited = new boolean[G.V()];
    edgeTo = new int[G.V()];
    this.s = s;
    dfs(G, s);
  }

  private void dfs(Graph G, int v) {
    visited[v] = true;
    for (int w : G.adj(v))
      if (!visited[w]) {
        edgeTo[w] = v;
        dfs(G, w);
      }
  }

  public boolean hasPathTo(int v) {
    return visited[v];
  }

  public Iterable<Integer> pathTo(int v) {
    if (!hasPathTo(v)) return null;

    StkLL<Integer> path = new StkLL<>();
    /* Back-track from v to source s. */
    for (int x = v; x != s; x = edgeTo[x]) path.push(x);

    path.push(s);
    return path;
  }

  public static void main(String[] args) {
    Graph G = new Graph(new In(args[0]));
    int s = Integer.parseInt(args[1]);
    var search = new DepthFirstPaths(G, s);

    for (int v = 0; v < G.V(); v++) {
      StdOut.print(s + " to " + v + ": ");
      if (search.hasPathTo(v))
        for (int x : search.pathTo(v))
          if (x == s) StdOut.print(x);
          else StdOut.print("-" + x);
      StdOut.println();
    }
  }
}
