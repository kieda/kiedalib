/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.search.fx;

import org.kieda.util.console.Console;
import test.search.SortedSearch;

/**
 * a basic linear search. Assumes the list is sorted.
 * @author kieda
 */
public class Sorted_Linear<T extends Comparable> extends SortedSearch{
    private boolean exit_flag = false;//has the element been found yet?
    private int ret_index = -1;
    @Override public void step() {
        Console.print("L[" + sid + "] = " +list.get(sid) + ", search for " + item + " ");
        //the item we're looking for is greater than our current item, so we 
        //must have passed it.
        if(item.compareTo(list.get(sid)) < 0){
            exit_flag = true; 
            Console.print("FALSE, item not found.\n");
            return; //ret index does not change.
        }
        if(list.get(sid).equals(item)){ //we've found the element!
            exit_flag = true; ret_index = sid;
            Console.print("TRUE, item found at index " + sid+".\n");
            return;
        }
        sid ++;
        Console.print((sid == list.size())?"FALSE, item not found\n":"not at current index.\n");
    }
    @Override public boolean exit() {
        //we've reached the end if we've gone through all of the elements in the
        //search.
        return exit_flag||(sid == list.size());
        //exit flag if we've found the element, otherwise we check if we're at 
        //the end of the list.
    }
    //assume that the function has exited when it returns.
    //returns -1 if the element is not in the list
    @Override
    public int ret() {
        return ret_index;
    }
}