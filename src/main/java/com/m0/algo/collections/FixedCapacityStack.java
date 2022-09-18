package com.m0.algo.collections;

import java.util.Iterator;

/*
 * Sedgewick 4th Edition: S1.3 - Bags, Queues, and Stacks
 */

/*
 * Implementation for a fixed capacity stack.
 */

public class FixedCapacityStack<Item> implements Stack<Item> {
  private Item[] a; /* the stack */
  private int sp; /* the stack pointer */

  public FixedCapacityStack(int cap) {
    a = (Item[]) new Object[cap];
  }

  @Override
  public void push(Item item) {
    a[sp++] = item;
  }

  @Override
  public Item pop() {
    return a[--sp];
  }

  @Override
  public Item peek() {
    return a[sp - 1];
  }

  @Override
  public boolean isEmpty() {
    return sp == 0;
  }

  @Override
  public int size() {
    return sp;
  }

  public Iterator<Item> iterator() {
    return new ReverseArrIterator();
  }

  private class ReverseArrIterator implements Iterator<Item> {
    private int isp = sp;

    public boolean hasNext() {
      return isp > 0;
    }

    public Item next() {
      return a[--isp];
    }

    public void remove() {}
  }
}
