package com.m0.algo.graph;

import com.m0.algo.collections.BagLL;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*
 * Sedgewick 4th Edition: S4.2 - Directed Graphs
 */

/*
 * Implement solution to the reachability problem by using dfs based algorithm.
 */
public class DiDFS {
  private boolean[] visited;

  public DiDFS(Digraph G, int s) {
    visited = new boolean[G.V()];
    dfs(G, s);
  }

  public DiDFS(Digraph G, Iterable<Integer> srcs) {
    visited = new boolean[G.V()];
    for (int s : srcs) if (!visited[s]) dfs(G, s);
  }

  private void dfs(Digraph G, int v) {
    visited[v] = true;
    for (int w : G.adj(v)) if (!visited[w]) dfs(G, w);
  }

  public boolean marked(int v) {
    return visited[v];
  }

  public static void main(String[] args) {
    Digraph G = new Digraph(new In(args[0]));
    BagLL<Integer> srcs = new BagLL<>();
    for (int i = 1; i < args.length; i++) srcs.add(Integer.parseInt(args[i]));

    DiDFS reachable = new DiDFS(G, srcs);

    for (int v = 0; v < G.V(); v++) if (reachable.marked(v)) StdOut.print(v + " ");
    StdOut.println();
  }
}
