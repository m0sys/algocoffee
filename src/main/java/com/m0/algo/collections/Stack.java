package com.m0.algo.collections;

/*
 * Sedgewick 4th Edition: S1.3 - Bags, Queues, and Stacks
 */

/*
 * Iterface for a generic Stack datastructure.
 */
public interface Stack<Item> {
  public void push(Item item);
  public Item pop();
  public boolean isEmpty();
  public int size();
}
