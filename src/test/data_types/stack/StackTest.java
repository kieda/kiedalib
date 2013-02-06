/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.data_types.stack;

import org.kieda.data_structures.Stack;


/**
 *
 * @author kieda
 */
public class StackTest {
    public static void main(String[] args){
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        int i = 0;
        while(i++<2) System.out.println(s.pop());
        s.push(123);
        s.push(456);
        while(!s.isEmpty()) System.out.println(s.pop());
    }
}
