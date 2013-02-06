/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kieda.data_structures;

/**
 *
 * @author kieda
 */
public abstract class AbstractQueue <T> {
    public AbstractQueue(){
        head = new Node();
        tail = new Node();
        Node DUMMY = new Node();
        tail.next = DUMMY;
        head.next = DUMMY;
    }
    /**
     * pop off at head, insert at tail.
     */
    protected Node head;
    protected Node tail;
    
    /**
     * enqueue an item
     * inserts it at the head.
     * @param item 
     */
    public abstract void enq(T item);
    
    /**
     * returns the head item of this queue.
     * returns null if the queue is empty.
     */
    public abstract T peek();
    
    /**
     * dequeue an item.
     * 
     * returns the item, or if the queue is empty return NULL
     * @return 
     */
    public abstract T deq();
    public abstract boolean isEmpty();
    protected class Node{
        public Node next;
        public T data;
    }
}
