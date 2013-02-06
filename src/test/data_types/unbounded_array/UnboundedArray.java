/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.data_types.unbounded_array;

import org.kieda.data_structures.Queue;
import java.lang.reflect.Array;

/**
 * just a typical unbounded array in java..
 * @author kieda
 */
public class UnboundedArray <T>{
    protected Object[] info;
    protected final float THRESH_HOLD_MAX = .75f;
    protected final float THRESH_HOLD_MIN = .25f;
    protected int pos;//the pos where we're adding on the next element
    
    //length of this array given by info.length
    
//    {
//        assert THRESH_HOLD_MAX > THRESH_HOLD_MIN && THRESH_HOLD_MIN>0;
//        assert THRESH_HOLD_MAX <=1;
//    }
    
    //get the elemnt at the given index
    public T get(int index){
        assert index >= 0 && index < pos;
        return (T)info[index];//the elem on the given index.
    }
    //add an elem on to the end of the array. resizes if necessary
    public void add(T elem){}
    //put the elem on top of the given index. Does not resize if the index is 
    //out of bounds.
    public void put(T elem, int index){
        assert index >= 0 && index < pos;
        info[index] = elem;
    }
    //put the elem on top of the given index. resizes if the index is greater 
    //than the current max.
    public void put_res(T elem, int index){
        assert index > 0;
        if(index>=pos){//we're inserting outside of the position
            
        }
        else{//we just insert it normally.
            info[index] = elem;
        }
    }
    //removes the item at the given index
//    public T remove(int index){
//        //need to figure out how to use this damn thing...
////        System.arraycopy(pos, pos, pos, pos, index);
//    }
    //removes the elemet from the array. Checks by elem.equals(array[index]);
    //returns the element to the user.
    public T remove(T elem){
        //tag!
        tag:for(int i = 0; i < pos; i++){
            //goes through the elements till we find a match
            if(elem.equals(info[i])){
//                return remove(i);//remove at the index
            }
        }
        return null;
    }
    //removes all of the elemes in the array that equal the elem
    public T[] remove_all(T elems){
        Queue<T> w = new Queue<T>();//wow I didn't think I needed this!
        int queue_size = 0;
       
        //goes through all of the elements 
        for(int i = 0; i < pos; i++){
            if(elems.equals(i)){
//                w.enq(remove(i));//enqueue a the index removad at i
                i--;//we step backwards for removing an element.
                queue_size++;//we increment the size of the queue
            }
        }
        if(queue_size == 0) return null;//nothing to add.
        T head = w.deq();//dequeue the top elem
        
        //bug alert! dosen't work if the head was set to null, I'd have to 
        //figure out a work-around in that case. Mabye we just won't let the
        //user input null.
        T[] a = (T[])Array.newInstance(head.getClass(), queue_size);
        //creates a new instanced based on the fact that we know the head exists.
        a[0] = head;
        //adds elems
        int i = 1; while(!w.isEmpty())
            a[i++] = w.deq();
        return a;
    }
    //shrinks the array to the given size
//    protected shrink(int size){
//        if(pos == 0) return;
//        //bug alert! dosen't work if the head was set to null, I'd have to 
//        //figure out a work-around in that case. Mabye we just won't let the
//        //user input null.
//        Object[] nn = new Object[size];//resized size
//        
//        pos = size;
//    }
//    //grows the array to the given size.
//    protected grow(int size){
//        
//    }
}
