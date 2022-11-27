package com.m0.algo;

import com.m0.algo.graph.BreathFirstPaths;
import com.m0.algo.graph.CC;
import com.m0.algo.graph.DepthFirstPaths;
import com.m0.algo.graph.DepthFirstSearch;
import com.m0.algo.graph.DiBFSPaths;
import com.m0.algo.graph.DiDFSIterPaths;
import com.m0.algo.graph.DiDFSPaths;
import com.m0.algo.graph.Topological;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

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

    // CommonItemsDoublingTest.main(new String[] {});

    /*
     * ********************
     * Section 2 - Sorting
     * ********************
     */

    // System.out.print("Selling out:   ");
    // Selection.main(new String[] {});
    // System.out.print("Inserting out: ");
    // Insertion.main(new String[] {});
    // System.out.print("Bubbling out:  ");
    // Bubble.main(new String[] {});
    // System.out.print("Shelling out:  ");
    // ShellSort.main(new String[] {});
    // System.out.print("Shelling out:  ");
    // ShellSortArr.main(new String[] {});
    // System.out.print("Merging out:  ");
    // Merge.main(new String[] {});
    // System.out.print("Merging out:  ");
    // MergeBU.main(new String[] {});
    // System.out.print("Merging out:  ");
    // ImprovedMerge.main(new String[] {});
    // System.out.print("Quick out: ");
    // Quick.main(new String[] {});
    // System.out.print("Heap out: ");
    // HeapSort.main(new String[] {});
    // System.out.print("Merging out:  ");
    // FastMerge.main(new String[] {});

    // System.out.println("\n\nSpeed testing Shelly vs Insertion/Selection/Merge
    // sort:\n"); ShellCompare.main(new String[] {});

    // System.out.println("\n\nSpeed testing Vanilla Merge with Other Merges:
    // \n"); MergeCompare.main(new String[] {});

    // System.out.println("\n\n Testing Num CMPs for Shell Sort:\n\n");
    // ShellSortApproxCmp.main(new String[] {});

    /* Testing some draw methods. */
    // StdDraw.setPenRadius(0.05);
    // StdDraw.setPenColor(StdDraw.BLUE);
    // StdDraw.point(0.5, 0.5);
    // int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    // int N = arr.length;
    // Double[] arrNorm = normalize(arr);
    // StdDraw.setPenColor(StdDraw.BLUE);

    // for (int i = 0; i < N; i++) {
    //   StdOut.printf("arrNorm[%d] = %.1f\n", i, arrNorm[i]);
    //   StdDraw.line(i / N, 0.0, i / N, arr[i] / 15);
    // }
    //
    // System.out.println("\n\nSpeed testing Vanilla Quick with Vanilla Merge
    // othe Quicks: \n"); QuickCompare.main(new String[] {});

    /*
     * *******************
     * Section 4 - Graphs
     * *******************
     */

    /* ----------- 4.1: Graphs ------------ */
    StdOut.println("DFS: ");
    DepthFirstSearch.main(new String[] {"data/tinyG.txt", "0"});
    StdOut.println("\nDFS Paths: ");
    DepthFirstPaths.main(new String[] {"data/tinyCG.txt", "0"});
    StdOut.println("\nBFS Paths: ");
    BreathFirstPaths.main(new String[] {"data/tinyG.txt", "0"});
    StdOut.println("\nCC: ");
    CC.main(new String[] {"data/tinyG.txt"});
    StdOut.println("\nSymbol Graph: ");
    // SymbolGraph.main(new String[] {"data/movies.txt", "/"});

    /* ------------ 4.2: Digraphs ------------ */
    StdOut.println("\nTopological Sort: ");
    Topological.main(new String[] {"data/jobs.txt", "/"});
    StdOut.println("\nDi DFS Paths: ");
    DiDFSPaths.main(new String[] {"data/mediumDG.txt", "0"});
    StdOut.println("\nDi DFS Iter Paths: ");
    DiDFSIterPaths.main(new String[] {"data/mediumDG.txt", "0"});
    StdOut.println("\nDi BFS Paths: ");
    DiBFSPaths.main(new String[] {"data/mediumDG.txt", "0"});
  }

  /* Array Normalization inspired by BatchNorm. */
  private static Double[] normalize(int[] a) {
    int N = a.length;
    Double[] arr = new Double[N];
    double mean = mean(a);
    double varr = variance(a);
    double epsilon = 0.000001;
    for (int i = 0; i < N; i++) arr[i] = ((int) a[i] - mean) / java.lang.Math.sqrt(varr + epsilon);

    return arr;
  }

  private static double mean(int[] a) {
    int N = a.length;
    double sum = 0.0;
    for (int i = 0; i < N; i++) sum += (int) a[i];

    return sum / N;
  }

  private static double variance(int[] a) {
    int N = a.length;
    double mean = mean(a);
    double sum = 0.0;

    for (int i = 0; i < N; i++) sum += ((int) a[i] - mean) * ((int) a[i] - mean);

    return sum / N;
  }
}
