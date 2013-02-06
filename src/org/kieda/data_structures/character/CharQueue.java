/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kieda.data_structures.character;

import org.kieda.util.error.EmptyQueueException;
import java.util.EmptyStackException;


/**
 * the default for a queue.
 * @author kieda
 */
public class CharQueue{ //extends AbstractQueue<T>{
    private Node DUMMY = new Node();
    public CharQueue(){
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
    public void enq(char c){
        Node r = new Node();
        tail.next.data = c;
        tail.next.next = r;
        tail.next = r;
    }
    /**
     * returns the head item of this queue.
     * throws error if the queue is empty.
     */
    public char peek(){
        if(!isEmpty())
            return head.next.data;
        throw new EmptyQueueException();
    }
    /**
     * dequeue an item.
     * 
     * returns the item, or if the queue is empty return NULL
     * @return 
     */
    public char deq(){
        if(!isEmpty()){
            Node rem = head.next;//the last item
            head.next = rem.next;//next item
            char s = rem.data;
            rem = null;//let GC do its work.
            return s;
        }
        throw new EmptyQueueException();
//        return null;//can't remove an element.
    }
    public boolean isEmpty(){
        return head.next == tail.next;//point to the same thing
    }
    private class Node{
        Node next;
        char data;
    }
}
