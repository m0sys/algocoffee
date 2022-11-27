package com.m0.algo.graph;

import com.m0.algo.collections.QueueLL;
import com.m0.algo.collections.StkLL;

/*
 * Sedgewick 4th Edition: S4.2 - Directed Graphs
 */

/*
 * Find preorder/postorder/reverse-postorder paths.
 */
public class DepthFirstOrder {
  private boolean[] visited;
  private QueueLL<Integer> pre;
  private QueueLL<Integer> post;
  private StkLL<Integer> revPost;

  public DepthFirstOrder(Digraph G) {
    pre = new QueueLL<>();
    post = new QueueLL<>();
    revPost = new StkLL<>();
    visited = new boolean[G.V()];

    for (int v = 0; v < G.V(); v++) if (!visited[v]) dfs(G, v);
  }

  private void dfs(Digraph G, int v) {
    pre.enqueue(v);
    visited[v] = true;
    for (int w : G.adj(v)) if (!visited[w]) dfs(G, w);

    post.enqueue(v);
    revPost.push(v);
  }

  public Iterable<Integer> pre() {
    return pre;
  }

  public Iterable<Integer> post() {
    return post;
  }

  public Iterable<Integer> revPost() {
    return revPost;
  }
}
