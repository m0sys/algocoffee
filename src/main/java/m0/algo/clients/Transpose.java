package com.m0.algo.clients;

/*
 * Sedgewick 4th Edition: S1.1 - Basic Programming Model
 *
 * Problem 1.1.13: Write a code fragment to print the transposition (rows and
 *                 columns changed) of a two-dimensional array with M rows and N
 *                 columns.
 */

public class Transpose {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Please enter 2 int command line argument.");
      System.out.println("e.g. java MatrixStar 2000");
      return;
    }

    int M = Integer.parseInt(args[0]);
    int N = Integer.parseInt(args[1]);

    Boolean[][] truth = new Boolean[M][N];

    // Fill up the array randomly.
    for (int i = 0; i < M; i++)
      for (int j = 0; j < N; j++)
        if (Math.random() < 0.5)
          truth[i][j] = false;
        else
          truth[i][j] = true;

    // Transpose the stuff.
    Boolean[][] ttruth = new Boolean[N][M];
    for (int i = 0; i < M; i++)
      for (int j = 0; j < N; j++)
        ttruth[j][i] = truth[i][j];

    // Print the old stuff.
    System.out.printf("\n\n");
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++)
        if (truth[i][j])
          System.out.printf("O");
        else
          System.out.printf("0");
      System.out.println();
    }

    // Print the new stuff.
    System.out.printf("\n\n");
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++)
        if (ttruth[i][j])
          System.out.printf("O");
        else
          System.out.printf("0");
      System.out.println();
    }
  }
}
