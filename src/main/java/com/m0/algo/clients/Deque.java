package com.m0.algo.clients;

/*
 * Sedgewick 4th Edition: S1.3 - Bags, Queues, and Stacks
 *
 * Problem 1.3.33: Deque. A double-ended queue or deque (pronounced “deck”) is
 * like a stack or a queue but supports adding and removing items at both ends.
 *
 * Write a class Deque that uses a doubly-linked list to implement this API and
 * a class ResizingArrayDeque that uses a resizing array.
 */

/* TODO: implement DequeDLL & ResizingArrDeque.
 */

public interface Deque<Item> {
  boolean isEmpty();

  int size();

  void pushLeft(Item item);

  void pushRight(Item item);

  Item popLeft();

  Item popRight();
}
