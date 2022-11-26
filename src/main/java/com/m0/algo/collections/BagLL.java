package com.m0.algo.collections;

import java.util.Iterator;

/*
 * Sedgewick 4th Edition: S1.3 - Bags, Queues, and Stacks
 */

/*
 * Implementation of a linked list based Bag collection.
 */

public class BagLL<Item> implements Bag<Item> {
  private Node first; // head of ll
  private int sz = 0;

  private class Node {
    Item itm;
    Node nxt;
  }

  /* Add new item to head of ll in O(1) time. */
  public void add(Item item) {
    Node old = first;
    first = new Node();
    first.itm = item;
    first.nxt = old;
    sz++;
  }

  public boolean isEmpty() {
    return sz == 0;
  }

  public int size() {
    return sz;
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
      Item item = curr.itm;
      curr = curr.nxt;
      return item;
    }

    public void remove() {}
  }
}
