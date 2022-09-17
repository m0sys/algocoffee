package com.m0.algo.collections;

/*
 * Sedgewick 4th Edition: S1.3 - Bags, Queues, and Stacks
 */

/*
 * Iterface for a generic Queue datastructure.
 */
public interface Queue<Item> {
  public void enqueue(Item item);
  public Item dequeue();
  public boolean isEmpty();
  public int size();
}
