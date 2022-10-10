package com.m0.algo;

import com.m0.algo.misc.commonitems.CommonItemsDoublingTest;
import edu.princeton.cs.algs4.In;

public class Algo {

  public static void testing_alg4jar(String[] args) {

    int a[] = new In(args[0]).readAllInts();
    for (int i = 0; i < 10; i++) {
      System.out.printf("%d: %d\n", i, a[i]);
    }
  }

  public static void main(String[] args) {
    System.out.println("This is a test!!");
    // testing_alg4jar(args);

    // String[] args2 = {"3", "4"};
    // Transpose.main(args2);
    // BetweenZeroOne.main(new String[] {"0.1", "0.9"});
    // BinRepr.main(new String[] {"15"});
    // BinRepr.main(new String[] {"16"});

    // Point2D.main(new String[] {});
    // NearestPoints.main(new String[] {"10"});
    // Intersections.main(new String[] {"10"});
    // BinarySearch.main(new String[] {});
    // CopyStkCli.main(new String[] {});

    // ThreeSum.main(args);
    // Stopwatch.main(args);
    // DoublingTest.main(new String[] {});

    // CntPairsDoublingTest.main(new String[] {});

    CommonItemsDoublingTest.main(new String[] {});
  }
}
