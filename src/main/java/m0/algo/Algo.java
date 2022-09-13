package com.m0.algo;

import com.m0.algo.clients.BetweenZeroOne;
import com.m0.algo.clients.BinRepr;
import com.m0.algo.clients.Transpose;

public class Algo {
  public static void main(String[] args) {
    System.out.println("This is a test!");
    String[] args2 = {"3", "4"};
    Transpose.main(args2);

    BetweenZeroOne.main(new String[] {"0.1", "0.9"});
    BinRepr.main(new String[] {"15"});
    BinRepr.main(new String[] {"16"});
  }
}
