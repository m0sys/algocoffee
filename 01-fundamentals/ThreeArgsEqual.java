/*
 * Sedgewick 4th Edition: S1.1 - Basic Programming Model
 *
 * Problem 1.1.3: Write a program that takes three integer command-line
 * arguments and prints equal if all three are equal, and not equal otherwise.
 */

public class ThreeArgsEqual {
  /** Must provide 3 int  args to command-line. */
  public static void main(String[] args) {
    if (args.length < 3) {
      System.out.println("Please enter 3 command line arguments.");
      System.out.println("e.g. java ThreeArgsEqual 1 1 1");
      return;
    }

    int a0 = Integer.parseInt(args[0]);
    int a1 = Integer.parseInt(args[1]);
    int a2 = Integer.parseInt(args[2]);

    if (a0 == a1 && a1 == a2) {
      System.out.printf("%d %d %d\n", a0, a1, a2);
      System.out.println("Are equal!");
    } else {
      System.out.printf("%d %d %d\n", a0, a1, a2);
      System.out.println("Are not equal!");
    }
  }
}
