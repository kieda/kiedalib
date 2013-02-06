/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kieda.data_structures.character;

import java.util.EmptyStackException;

/**
 *
 * @author kieda
 */
public class CharStack {
    public CharStack(){
        head = new Node();
        head.next = DUMMY;
    }
    protected Node head;
    protected final Node DUMMY = new Node();
    public void push(char item){
        Node n = new Node();
        n.data = item;
        n.next = head.next;
        head.next = n;
    }
    public char pop(){
        if(isEmpty()) throw new EmptyStackException();
        Node r = head.next;
        head.next = head.next.next;
        char s = r.data;
        r = null;//let GC do its work...
        return s;
    }
    public boolean isEmpty(){
        return head.next == DUMMY;
    }
    protected class Node<T>{
        Node next;
        char data;
    }
}