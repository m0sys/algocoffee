package com.m0.algo.graphics;

// import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

import java.lang.Math;
import org.junit.Test;

public class Point2DTest {
  @Test
  public void verifyNoExceptionThrownOnMain() {
    Point2D.main(new String[] {});
  }

  @Test
  public void verifyNoExceptionThrownOnInit() {
    Point2D p = new Point2D(0, 0);
  }

  @Test
  public void testXAndY() {
    Point2D p = new Point2D(0, 0);
    Point2D p2 = new Point2D(1, 2);

    /* Test values. */
    assertEquals(0, p.x(), 0);
    assertEquals(0, p.y(), 0);
    assertEquals(1, p2.x(), 0);
    assertEquals(2, p2.y(), 0);
  }

  @Test
  public void testRadius() {
    Point2D p = new Point2D(0, 0);
    Point2D p2 = new Point2D(1, 2);

    /* Test values.
     * Values calculated using Wolfram Alpha.
     */
    assertEquals(0, p.r(), 0);
    assertEquals(2.23606797, p2.r(), 0.1);
  }

  @Test
  public void testTheta() {
    Point2D p = new Point2D(0, 0);
    Point2D p2 = new Point2D(2, 1);
    Point2D p3 = new Point2D(1, 2);

    /* Test values.
     * Values calculated using Wolfram Alpha.
     */
    assertEquals(Double.NaN, p.theta(), 0);
    assertEquals(0.463648, p2.theta(), 0.1);
    assertEquals(1.10714871779409, p3.theta(), 0.1);
  }

  @Test
  public void testDistTo() {
    Point2D p = new Point2D(0, 0);
    Point2D p2 = new Point2D(1, 2);
    /* Test values.
     * Values calculated using Wolfram Alpha.
     */
    assertEquals(2.23606797, p.distTo(p2), 0.01);
    assertEquals(2.23606797, p2.distTo(p), 0.01);
  }
}
