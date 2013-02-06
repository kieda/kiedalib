/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.tests;

import org.kieda.util.console.Console;
import java.util.ArrayList;
import java.util.Scanner;
import test.search.fx.BinarySearch;
import test.search.fx.Sorted_Linear;
import test.search.fx.Unsorted_Linear;

public class SearchTest {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args){
        BinarySearch tsl = new BinarySearch();
        ArrayList<Integer> ai = new ArrayList<>();
        ai.add(0);
        ai.add(1);
        ai.add(2);
        ai.add(3);
        ai.add(5);
        ai.add(6);
        ai.add(7);
        tsl.input(ai, 3);//input some arraylist, and the value you're searching 
                         //for
        
        
        //complete test. There are also tests that also depend on user input. 
        //i.e. we call tsl.step() if a user does an action, like pressing a 
        //button
        abc:while(!tsl.exit()){
//            String ss = s.nextLine();
//            Console.pushTab();
//            if(ss.equals("step"))
                tsl.step();//step through the data.
//            else if(ss.equals("exit")) break abc;
//            Console.popTab();
        }
        //grab the return value
        System.out.println("result: "+tsl.ret());
        
    }
}
