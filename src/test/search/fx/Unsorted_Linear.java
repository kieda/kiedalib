/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.search.fx;

import org.kieda.util.console.Console;
import test.search.UnsortedSearch;

/**
 *
 * @author kieda
 */
public class Unsorted_Linear <T> extends UnsortedSearch{
    private int ret_index = -1;
    @Override public void step() {
        Console.print("L[" + sid + "] = " +list.get(sid) + ", search for " + item + " ");
        //the item we're looking for is greater than our current item, so we 
        //must have passed it.
        if(list.get(sid).equals(item)){ //we've found the element!
            ret_index = sid;
            Console.print("TRUE, item found at index " + sid+".\n");
            return;
        }
        sid++;
        Console.print((sid == list.size())?"FALSE, item not found\n":"not at current index.\n");
    }
    @Override public boolean exit() {
        //we've reached the end if we've gone through all of the elements in the
        //search.
        return (ret_index != -1)||(sid == list.size());
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
