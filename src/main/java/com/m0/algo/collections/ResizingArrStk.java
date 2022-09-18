package com.m0.algo.collections;

import java.util.Iterator;

/*
 * Sedgewick 4th Edition: S1.3 - Bags, Queues, and Stacks
 */

/*
 * Implementation for a generic resizing array stack.
 */

public class ResizingArrStk<Item> implements Stack<Item> {
  private Item[] a = (Item[]) new Object[1]; /* stack of items */
  private int sp = 0; /* the stack pointer */

  public boolean isEmpty() {
    return sp == 0;
  }

  public int size() {
    return sp;
  }

  private void resize(int max) {
    Item[] tmp = (Item[]) new Object[max];
    for (int i = 0; i < sp; i++) tmp[i] = a[i];
    a = tmp;
  }

  /* Add item to the top of stack. */
  public void push(Item item) {
    if (sp == a.length) resize(2 * a.length);
    a[sp++] = item;
  }

  /* Remove item from the top of stack. */
  public Item pop() {
    Item item = a[--sp];
    a[sp] = null; /* avoid loitering */
    if (sp > 0 && sp == a.length / 4) resize(a.length / 2);
    return item;
  }

  @Override
  public Item peek() {
    return a[sp - 1];
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
