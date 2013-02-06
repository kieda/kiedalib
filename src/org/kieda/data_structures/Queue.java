package org.kieda.data_structures;

/**
 * the default for a queue.
 * @author kieda
 */
public class Queue <T> extends AbstractQueue<T>{
    private Node DUMMY = new Node();
    public Queue(){
        head = new Node();
        tail = new Node();
        
        tail.next = DUMMY;
        head.next = DUMMY;
    }
    /**
     * pop off at head, insert at tail.
     */
    private Node head;
    private Node tail;
    
    /**
     * enqueue an item
     * inserts it at the head.
     * @param item 
     */
    public void enq(T item){
        Node r = new Node();
        tail.next.data = item;
        tail.next.next = r;
        tail.next = r;
    }
    /**
     * returns the head item of this queue.
     * returns null if the queue is empty.
     */
    public T peek(){
        if(!isEmpty())
            return head.next.data;
        return null;
    }
    /**
     * dequeue an item.
     * 
     * returns the item, or if the queue is empty return NULL
     * @return 
     */
    public T deq(){
        if(!isEmpty()){
            Node rem = head.next;//the last item
            head.next = rem.next;//next item
            T s = rem.data;
            rem = null;//let GC do its work.
            return s;
        }
        return null;//can't remove an element.
    }
    public boolean isEmpty(){
        return head.next == tail.next;//point to the same thing
    }
    private class Node{
        Node next;
        T data;
    }
}
