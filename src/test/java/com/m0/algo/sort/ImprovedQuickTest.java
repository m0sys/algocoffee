package com.m0.algo.sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImprovedQuickTest {
  @Test
  public void testSort() {
    String[] a = {
      "Q", "U", "I", "C", "K", "S", "O", "R",
      "T", "E", "X", "A", "M", "P", "L", "E"
    };
    ImprovedQuick.sort(a);
    assert ImprovedQuick.isSorted(a);
  }
}
