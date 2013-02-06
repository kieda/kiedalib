/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kieda.search;

import org.kieda.typesafe.AssertionMethod;
import java.util.List;
/**
 * @author kieda
 */
public class Search {
//    @AssertionMethod
//    private static <T extends Comparable> boolean isSorted(List<T> list){
//        //we run through the list of elements
//        for(int i = 0; i < list.size(); i++){
//            if(list.get(i) == null) return false;
//            //we check that the this element is less than or equal to the next
//            //element. We also need to make sure that we're not checking out of 
//            //bounds (first statement)
//            if(i < list.size()-1 && (list.get(i).compareTo(list.get(i+1))<0)) return  false;
//        }
//        return true;
//    }
    
    /**
     * returns the index of the item that you're looking for in a list. The 
     * input list must be sorted, and all of the elements in the list cannot be 
     * null. The list itself cannot be null.
     * 
     * if the element is not in the list, this method returns -1.
     * 
     * Slightly modified from the "traditional" binary search, but works just 
     * the same.
     */
    public static <T extends Comparable<R>, R> int BinarySearch(List<T> list, R item){ 
        assert list != null : ("List cannot be null.");
//        assert isSorted(list) : ("List must be sorted. List: " + list);
        //the lower bound that we're checking
        int lower = -1;

        //the upper bound that we're checking. It starts off with the end of the 
        //list.
        int upper = list.size();
        for(;;){
            if(lower >= upper){return -1;}
            int mid = upper+(lower-upper)/2;
            int val = list.get(mid).compareTo(item);
            if(val<0){
                //if the item is greater than the value in the middle, we will
                //want to search past the middle, or set the new bounds such that
                //the minimum is the old middle, and the maximum remains the same.
                lower = mid;
            } else if(val>0){
                //if the value is less than what we're at, we go lower.
                //we set the new bounds such that the maximum is the old value,
                //and the minimum remains the same.
                upper = mid;
            }
            else{
                //hey! the item IS the middle element! We've found it!
                lower = mid;
                return lower;
            }
            if(upper-lower < 2) {return -1;}
        }
    }
}
