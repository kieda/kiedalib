/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.search.fx;

import java.util.Arrays;
import java.util.List;
import test.search.SortedSearch;

/**
 *
 * @author kieda
 */
public class BinarySearch<T extends Comparable> extends SortedSearch {
    private boolean exit_flag = false;
    //the lower bound that we're checking
    private int lower = -1;
    
    //the upper bound that we're checking. It starts off with the end of the 
    //list.
    private int upper;
    
    
    @Override
    public void step() {
        if(lower >= upper){ exit_flag = true; lower = -1; return;}
        int mid = upper+(lower-upper)/2;
        int val = item.compareTo(list.get(mid));
        if(val>0){
            //if the item is greater than the value in the middle, we will
            //want to search past the middle, or set the new bounds such that
            //the minimum is the old middle, and the maximum remains the same.
            lower = mid;
        } else if(val<0){
            //if the value is less than what we're at, we go lower.
            //we set the new bounds such that the maximum is the old value,
            //and the minimum remains the same.
            upper = mid;
        }
        else{
            //hey! the item IS the middle element! We've found it!
            lower = mid; exit_flag = true; return;
        }
        if(upper-lower < 2) {exit_flag = true; lower = -1;}
    }
    @Override
    public int ret() {
        return lower;
    }
    @Override
    public boolean exit() {
        return exit_flag;
    }
    @Override protected void input(Object args){
        super.input(args);
        upper = list.size();
    }
}

















/**
 * 
  int lower = 0;
  int upper = n;
  while (lower < upper)
    //@loop_invariant 0 <= lower && lower <= upper && upper <= n;
    //@loop_invariant lower == 0 || A[lower-1] < x;
    //@loop_invariant upper == n || A[upper] > x;
    {
      int mid = lower + (upper-lower)/2;
      if (A[mid] < x)
	lower = mid+1;
      else if (A[mid] > x)
	upper = mid;
      else //@assert A[mid] == x;
	return mid;
    }
  //@assert lower == upper;
  return -1;
 */