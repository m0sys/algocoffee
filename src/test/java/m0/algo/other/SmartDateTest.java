package com.m0.algo.other;

import static org.junit.Assert.*;

import org.junit.Test;

public class SmartDateTest {
  @Test
  public void testIllegalMonth() {
    assertThrows(IllegalArgumentException.class,
                 () -> { SmartDate sd = new SmartDate(13, 1, 1); });

    assertThrows(IllegalArgumentException.class,
                 () -> { SmartDate sd = new SmartDate(-1, 1, 1); });
  }

  @Test
  public void testIllegalDay() {
    assertThrows(IllegalArgumentException.class,
                 () -> { SmartDate sd = new SmartDate(1, 32, 1); });

    assertThrows(IllegalArgumentException.class,
                 () -> { SmartDate sd = new SmartDate(1, -1, 1); });
  }
}
