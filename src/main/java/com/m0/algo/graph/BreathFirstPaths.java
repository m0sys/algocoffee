package com.m0.algo.graph;

import com.m0.algo.collections.QueueLL;
import com.m0.algo.collections.StkLL;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*
 * Sedgewick 4th Edition: S4.1 - Undirected Graphs
 */

/*
 * Find the shortest path from s to v using bfs algorithm.
 */
public class BreathFirstPaths {
  private boolean[] visited;
  private int[] edgeTo; // last vertex on known path to this vertex
  private int[] distTo; // num edges to this vertex
  private final int s;

  public BreathFirstPaths(Graph G, int s) {
    visited = new boolean[G.V()];
    edgeTo = new int[G.V()];
    distTo = new int[G.V()];
    this.s = s;
    bfs(G, s);
  }

  private void bfs(Graph G, int s) {
    QueueLL<Integer> queue = new QueueLL<>();
    visited[s] = true;
    distTo[s] = 0;
    queue.enqueue(s);
    while (!queue.isEmpty()) {
      int v = queue.dequeue();
      var adjlst = G.adj(v);
      /* Goes through all adj vertex before inspecting first neighbor.*/
      for (int w : adjlst)
        if (!visited[w]) {
          edgeTo[w] = v;
          distTo[w] = distTo(v) + 1;
          visited[w] = true;
          queue.enqueue(w);
        }
    }
  }

  /* Return number of edges along shortest path from source to v. */
  public int distTo(int v) {
    if (!hasPathTo(v)) return Integer.MAX_VALUE;
    return distTo[v];
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
    var search = new BreathFirstPaths(G, s);

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
