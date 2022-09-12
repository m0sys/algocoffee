package com.m0.algo.clients;

/*
 * Sedgewick 4th Edition: S1.1 - Basic Programming Model
 *
 * Problem 1.1.5: Write a code fragment that prints true if the double variables
 *                x and y are both strictly between 0 and 1 and false otherwise.
 */

public class BetweenZeroOne {
  /** Must provide 2 double args to command-line. */
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Please enter 3 command line arguments.");
      System.out.println("e.g. java Year 2000");
      return;
    }

    double a0 = Double.parseDouble(args[0]);
    double a1 = Double.parseDouble(args[1]);

    if (a0 < 1 && a0 > 0 && a1 < 1 && a0 > 0) {
      System.out.println("True");
    } else {
      System.out.println("False");
    }
  }
}
