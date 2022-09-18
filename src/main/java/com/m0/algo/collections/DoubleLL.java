package com.m0.algo.collections;

/*
 * Sedgewick 4th Edition: S1.3 - Bags, Queues, and Stacks
 *
 * Problem 1.3.31: Implement a nested class DoubleNode for building
 * doubly-linked lists, where each node contains a reference to the item
 * preceding it and the item following it in the list (null if there is no such
 * item). Then implement static methods for the following tasks: insert at the
 * beginning, insert at the end, remove from the beginning, remove from the end,
 * insert before a given node, insert after a given node, and remove a given
 * node.
 */

/* TODO: implement it.
 *
 * Make it static?
 */
public class DoubleLL<Item> {
  private DoubleNode head;

  private class DoubleNode {
    Item item;
    DoubleNode nxt;
    DoubleNode prev;
  }

  public void insertFront(Item itm) {}

  public void insertBack(Item itm) {}

  public Item removeeFront() {
    return null;
  }

  public Item removeBack() {
    return null;
  }

  public void insertBefore(Item item) {}

  public void insertAfter(Item item) {}

  public void remove(Item item) {}
}
