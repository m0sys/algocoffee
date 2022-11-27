package com.m0.algo.graph;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.In;
import org.junit.Test;

public class DigraphTest {

  @Test
  public void testCopyConstr() {
    Digraph g = new Digraph(new In("data/tinyG.txt"));

    var g2 = new Digraph(g);
    assertEquals(g.toString(), g2.toString());
    g2.addEdge(0, 3);
    assertNotEquals(g.toString(), g2.toString());
  }

  @Test
  public void testHasEdge() {
    Digraph g = new Digraph(new In("data/tinyG.txt"));
    assertTrue(g.hasEdge(4, 3));
    assertFalse(g.hasEdge(3, 4));
  }
}
