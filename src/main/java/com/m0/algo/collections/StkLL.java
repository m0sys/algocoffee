package com.m0.algo.collections;

import java.util.Iterator;

/*
 * Sedgewick 4th Edition: S1.3 - Bags, Queues, and Stacks
 */

/*
 * Implementation for a generic linked-lst stack.
 */

public class StkLL<Item> implements Stack<Item>, Iterable<Item> {
  private Node first; /* top of the stack */
  private int sp; /* the stack pointer */

  private class Node {
    Item item;
    Node nxt;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return sp;
  }

  /* Add item at the top of stack. */
  public void push(Item item) {
    Node old_fst = first;
    first = new Node();
    first.item = item;
    first.nxt = old_fst;
    sp++;
  }

  /* Remove item from the stop of stack. */
  public Item pop() {
    Item item = first.item;
    first = first.nxt;
    sp--;
    return item;
  }

  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {
    private Node curr = first;

    public boolean hasNext() {
      return curr != null;
    }

    public Item next() {
      Item item = curr.item;
      curr = curr.nxt;
      return item;
    }

    public void remove() {}
  }
}
