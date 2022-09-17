package com.m0.algo;

import com.m0.algo.clients.BetweenZeroOne;
import com.m0.algo.clients.BinRepr;
import com.m0.algo.clients.Intersections;
import com.m0.algo.clients.NearestPoints;
import com.m0.algo.clients.Transpose;
import com.m0.algo.graphics.Point2D;
import com.m0.algo.search.BinarySearch;

public class Algo {

    public static void hello() {
        System.out.println("Hello");
    }
  public static void main(String[] args) {
    System.out.println("This is a test!");
    // String[] args2 = {"3", "4"};
    // Transpose.main(args2);
    // BetweenZeroOne.main(new String[] {"0.1", "0.9"});
    // BinRepr.main(new String[] {"15"});
    // BinRepr.main(new String[] {"16"});

    // Point2D.main(new String[] {});
    // NearestPoints.main(new String[] {"10"});
    // Intersections.main(new String[] {"10"});
    BinarySearch.main(new String[] {});
  }
}
