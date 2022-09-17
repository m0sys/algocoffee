package com.m0.algo.collections;

import java.util.Iterator;

/*
 * Sedgewick 4th Edition: S1.3 - Bags, Queues, and Stacks
 */

/*
 * Implementation for a generic linked-lst queue.
 */

public class QueueLL<Item> implements Queue<Item>, Iterable<Item> {
  private Node first; /* link to least recently used node */
  private Node last; /* link to most recently used node */
  private int N; /* num items in queue */

  private class Node {
    Item item;
    Node nxt;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return N;
  }

  /* Add item to the end of the queue. */
  public void enqueue(Item item) {
    Node oldlast = last;
    last = new Node();
    last.item = item;
    last.nxt = null;
    if (isEmpty()) first = last;
    else oldlast.nxt = last;
    N++;
  }

  /* Remove item from the beginning of  the queue. */
  public Item dequeue() {
    Item item = first.item;
    first = first.nxt;
    if (isEmpty()) last = null;
    N--;
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
