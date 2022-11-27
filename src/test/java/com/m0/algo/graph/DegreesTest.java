package com.m0.algo.graph;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.In;
import org.junit.Test;

public class DegreesTest {
  @Test
  public void testIndegree() {
    Digraph g = new Digraph(new In("data/tinyDG.txt"));
    Degrees dg = new Degrees(g);

    assertEquals(3, dg.indegree(4));
    assertEquals(2, dg.indegree(6));
  }

  @Test
  public void testOutdegree() {
    Digraph g = new Digraph(new In("data/tinyDG.txt"));
    Degrees dg = new Degrees(g);

    assertEquals(2, dg.outdegree(4));
    assertEquals(4, dg.outdegree(6));
  }
}
