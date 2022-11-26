package com.m0.algo.graph;

import com.m0.algo.collections.BagLL;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*
 * Sedgewick 4th Edition: S4.1 - Undirected Graphs
 */

/*
 * Find Connected Components within a given Graph.
 */
public class CC {
  private boolean[] visited;
  private int[] id;
  private int count;

  public CC(Graph G) {
    visited = new boolean[G.V()];
    id = new int[G.V()];
    for (int s = 0; s < G.V(); s++)
      if (!visited[s]) {
        dfs(G, s);
        count++;
      }
  }

  private void dfs(Graph G, int v) {
    visited[v] = true;
    id[v] = count;
    for (int w : G.adj(v)) if (!visited[w]) dfs(G, w);
  }

  public boolean connected(int v, int w) {
    return id[v] == id[w];
  }

  public int id(int v) {
    return id[v];
  }

  public int count() {
    return count;
  }

  public static void main(String[] args) {
    Graph G = new Graph(new In(args[0]));
    CC cc = new CC(G);

    int M = cc.count();
    StdOut.println(M + " components");

    BagLL<Integer>[] comps = (BagLL<Integer>[]) new BagLL[M];
    for (int i = 0; i < M; i++) comps[i] = new BagLL<>();

    for (int v = 0; v < G.V(); v++) comps[cc.id(v)].add(v);

    for (int i = 0; i < M; i++) {
      for (int v : comps[i]) StdOut.print(v + " ");
      StdOut.println();
    }
  }
}
