package com.m0.algo.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * Sedgewick 4th Edition: S4.1 - Undirected Graphs
 */

public class SymbolGraph {

  /* TODO: replace with own implementation such as AVL Tree. */
  private ST<String, Integer> st;
  private String[] keys;
  private Graph G;

  public SymbolGraph(String stream, String sp) {
    st = new ST<>();
    In in = new In(stream);
    /* First pass builds the index. */
    while (in.hasNextLine()) {
      String[] a = in.readLine().split(sp);
      for (int i = 0; i < a.length; i++) if (!st.contains(a[i])) st.put(a[i], st.size());
    }
    keys = new String[st.size()];
    for (String name : st.keys()) keys[st.get(name)] = name;

    keys = new String[st.size()];
    for (String name : st.keys()) keys[st.get(name)] = name;

    /* Second pass builds the graph. */
    G = new Graph(st.size());
    in = new In(stream);
    while (in.hasNextLine()) {
      String[] a = in.readLine().split(sp);
      int v = st.get(a[0]);
      for (int i = 1; i < a.length; i++) G.addEdge(v, st.get(a[i]));
    }
  }

  public boolean contains(String s) {
    return st.contains(s);
  }

  public int index(String s) {
    return st.get(s);
  }

  public String name(int v) {
    return keys[v];
  }

  public Graph G() {
    return G;
  }

  public static void main(String[] args) {
    String fname = args[0];
    String delim = args[1];
    SymbolGraph sg = new SymbolGraph(fname, delim);

    Graph G = sg.G();
    while (StdIn.hasNextLine()) {
      String src = StdIn.readLine();
      for (int w : G.adj(sg.index(src))) StdOut.println(" " + sg.name(w));
    }
  }
}
