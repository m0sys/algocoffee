package com.m0.algo.collections;

/*
 * Sedgewick 4th Edition: S1.3 - Bags, Queues, and Stacks
 */

/*
 * Iterface for a generic Bag datastructure.
 */
public interface Bag<Item> {
  public void add(Item item);

  public boolean isEmpty();

  public int size();
}
