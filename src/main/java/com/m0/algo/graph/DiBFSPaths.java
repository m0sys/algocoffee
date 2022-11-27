package com.m0.algo.graph;

import com.m0.algo.collections.QueueLL;
import com.m0.algo.collections.StkLL;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*
 * Sedgewick 4th Edition: S4.2 - Directed Graphs
 */

/*
 * Find shortest paths from source to all reachable vertices.
 */
public class DiBFSPaths {
  private boolean[] visited;
  private int edgeTo[];
  private final int s;

  public DiBFSPaths(Digraph G, int s) {
    visited = new boolean[G.V()];
    edgeTo = new int[G.V()];
    this.s = s;
    bfs(G, s);
  }

  private void bfs(Digraph G, int s) {
    visited[s] = true;
    QueueLL<Integer> queue = new QueueLL<>();
    queue.enqueue(s);
    while (!queue.isEmpty()) {
      int v = queue.dequeue();
      for (int w : G.adj(v)) {
        if (!visited[w]) {
          visited[w] = true;
          edgeTo[w] = v;
          queue.enqueue(w);
        }
      }
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
    Digraph G = new Digraph(new In(args[0]));
    int s = Integer.parseInt(args[1]);
    var search = new DiBFSPaths(G, s);

    for (int v = 0; v < G.V(); v++) {
      StdOut.print(s + " to " + v + ": ");
      if (search.hasPathTo(v))
        for (int x : search.pathTo(v))
          if (x == s) StdOut.print(x);
          else StdOut.print(" -> " + x);
      StdOut.println();
    }
  }
}
