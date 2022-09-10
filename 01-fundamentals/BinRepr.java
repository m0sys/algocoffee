/*
 * Sedgewick 4th Edition: S1.1 - Basic Programming Model
 *
 * Problem 1.1.9: Write a code fragment that puts the binary representation
 *                of a positive integer N into a String s.
 */

public class BinRepr {
  /** Must provide int arg to command-line. */
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Please enter 1 int command line argument.");
      System.out.println("e.g. java BinRepr 2000");
      return;
    }
    String bin = "";
    int n = Integer.parseInt(args[0]);
    while (n != 1) {
      int q = n / 2;
      int r = n % 2;
      bin = String.valueOf(r) + bin;
      n = q;
    }
    bin = String.valueOf(n) + bin;

    System.out.printf("Bin: %s\n", bin);
  }
}
