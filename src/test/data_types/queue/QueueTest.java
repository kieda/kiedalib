/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.data_types.queue;

import org.kieda.data_structures.Queue;

/**
 *
 * @author kieda
 */
public class QueueTest {
    public static void main(String[] args){
        Queue<Integer> p = new Queue<Integer>();
        p.enq(1);
        p.enq(2);
        p.enq(3);
        p.enq(4);
        p.enq(5);
        
        System.out.println(p.peek());
        while(!p.isEmpty())
            System.out.println(p.deq());
    }
}
