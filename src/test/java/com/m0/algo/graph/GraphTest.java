package com.m0.algo.graph;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.In;
import org.junit.Test;

public class GraphTest {
  @Test
  public void testCopyConstr() {
    Graph g = new Graph(new In("data/tinyG.txt"));

    var g2 = new Graph(g);
    assertEquals(g.toString(), g2.toString());
    g2.addEdge(0, 3);
    assertNotEquals(g.toString(), g2.toString());
  }

  @Test
  public void testHasEdge() {
    Graph g = new Graph(new In("data/tinyG.txt"));
    assertTrue(g.hasEdge(0, 5));
    assertFalse(g.hasEdge(5, 7));
  }
}
