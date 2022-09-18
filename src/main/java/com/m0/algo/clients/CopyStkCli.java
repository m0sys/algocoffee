package com.m0.algo.clients;

import com.m0.algo.collections.ResizingArrStk;
import com.m0.algo.collections.Stack;
import com.m0.algo.collections.StkLL;

/*
 * Sedgewick 4th Edition: S1.3 - Bags, Queues, and Stacks
 *
 * Problem 1.3.12: Write an iterable Stack client that has a static method
 * copy() that takes a stack of strings as argument and returns a copy of the
 * stack.
 */

/*
 * Reflectively copy any concrete type of stack.
 *
 * See for details: https://www.geeksforgeeks.org/reflection-in-java/
 */
public class CopyStkCli {

  public static Stack<String> copy(Stack<String> stk) {
    try {

      /* Reflect upon thy class. */
      @SuppressWarnings("unchecked") /* FIXME: find better way */
      Stack<String> cpy = stk.getClass().getDeclaredConstructor().newInstance();

      for (String s : stk) {
        cpy.push(s);
      }
      return cpy;
    } catch (ReflectiveOperationException ignored) {
      System.out.println("error: reflection didn't work!");
    }
    return null;
  }

  public static void main(String[] args) {
    System.out.println("Hello, World!");

    /* Try reflection with ResizingArrStk. */
    System.out.println("\nReflect on ResizingArrStk: ");
    Stack<String> stk = new ResizingArrStk<>();
    for (int i = 0; i < 20; i++) stk.push(String.valueOf(i));
    Stack<String> cpy = copy(stk);

    for (String s : cpy) {
      System.out.println(s);
    }

    /* Try reflection with StkLL. */
    System.out.println("\nReflect on StkLL: ");
    stk = new StkLL<>();
    for (int i = 0; i < 20; i++) stk.push(String.valueOf(i));
    cpy = copy(stk);

    for (String s : cpy) {
      System.out.println(s);
    }
  }
}
