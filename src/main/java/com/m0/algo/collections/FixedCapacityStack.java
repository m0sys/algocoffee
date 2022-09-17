package com.m0.algo.collections;

/*
 * Sedgewick 4th Edition: S1.3 - Bags, Queues, and Stacks
 */

/*
 * Implementation for a fixed capacity stack.
 */

public class FixedCapacityStack<Item> implements Stack<Item>, Iterable<Item> {
  private Item[] a; /* the stack */
  private int sp;   /* the stack pointer */

  public FixedCapacityStack(int cap) { a = (Item[]) new Object[cap]; }

  @Override
  public void push(Item item) {
    a[sp++] = item;
  }

  @Override
  public Item pop() {
    return a[--sp];
  }

  @Override
  public boolean isEmpty() {
    return sp == 0;
  }

  @Override
  public int size() {
    return sp;
  }
}
