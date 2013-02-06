/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kieda.data_structures;

/**
 *
 * @author kieda
 */
public class Stack<T> {
    public Stack(){
        head = new Node();
        head.next = DUMMY;
    }
    protected Node head;
    protected final Node DUMMY = new Node();
    public void push(T item){
        Node n = new Node();
        n.data = item;
        n.next = head.next;
        head.next = n;
    }
    public T pop(){
        if(isEmpty()) return null;
        Node r = head.next;
        head.next = head.next.next;
        T s = (T)r.data;
        r = null;//let GC do its work...
        return s;
    }
    public boolean isEmpty(){
        return head.next == DUMMY;
    }
    protected class Node<T>{
        Node next;
        T data;
    }
}