package com.m0.algo.graph;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.In;
import org.junit.Test;

public class BreathFirstPathsTest {

  @Test
  public void testDistTo() {

    Graph G = new Graph(new In("data/tinyG.txt"));
    var search = new BreathFirstPaths(G, 0);
    assertEquals(2, search.distTo(4));
    assertEquals(Integer.MAX_VALUE, search.distTo(10));
  }
}
