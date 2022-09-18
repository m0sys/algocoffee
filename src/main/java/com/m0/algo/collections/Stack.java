package com.m0.algo.collections;

/*
 * Sedgewick 4th Edition: S1.3 - Bags, Queues, and Stacks
 *
 * Problem 1.3.7: Add a method peek() to Stack that returns the most recently
 * inserted item on the stack (without popping it).
 */

/*
 * Iterface for a generic Stack datastructure.
 */
public interface Stack<Item> {
  public void push(Item item);

  public Item pop();

  public Item peek();

  public boolean isEmpty();

  public int size();
}
