package org.kieda.data_structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * this class offers the versatility of a Stack in that you add and remove 
 * elements by a push and pop sequence, but is different in that you are still
 * able to easily access all of the elements quickly.
 * 
 * this is useful if we want to, for example, keep track of all of the variables
 * used in a syntax block {}. 
 * For such a task, we need to know the names used in the syntax blocks which 
 * contain that syntax block, in order to avoid conflict, but we want an easy 
 * way to dispose of all of the names used once exiting a syntax block.
 * 
 * Example: 
 * 
 * {
 *      //current StackPool : []
 *      //current Queue     : []
 * 
 *      int hello1; //queue hello1
 *      int hello2; //queue hello2
 * 
 *      //current StackPool : []
 *      //current Queue     : [hello1, hello2]      
 * 
 *      {//pushQueue hello1 and hello2 onto the stackframe
 * 
 *          //current StackPool : [hello1, hello2]
 *          //current Queue     : []
 * 
 *          int no_way; //queue no_way
 *          int bro;    //queue bro
 * 
 *          //current StackPool : [hello1, hello2]
 *          //current Queue     : [no_way, bro]
 *          
 *          {//pushQueue no_way, bro
 *              //current StackPool : [hello1, hello2, no_way, bro]
 *              //current Queue     : []
 * 
 *          }//dump nothing (nothing added to queue)
 * 
 *      }//dump no_way, bro
 *      
 *      //current StackPool : [hello1, hello2]
 *      //current Queue     : []
 * 
 * }//dump hello1, hello2
 *
 * //current StackPool : []
 * //current Queue     : [] 
 */
public class StackSet <T> {
//    private ArrayList<T> elements; //our unbounded array
    private Queue<T> current_queue;    //the current queue
    private Stack<Queue<T>> frames;    //the position of the things that we have 
                                       //pushed or popped
    private HashSet<T> elements;       //our set of elements
    private HashSet<T> current_frame;  //current frame
    //our max is elements.size, and the position to pop till is pos.pop()
    
    public StackSet(){
        elements = new HashSet<T>();
        frames = new Stack<Queue<T>>();
        current_queue = new Queue<T>();
        current_frame = new HashSet<T>();
    }
    
    /**
     * "queues up" a single element, but does not add it to the stack-frame.
     * 
     * Returns whether or not the element is already in the StackSet.
     */
    public boolean queueElement(T elem){
        boolean ret = contains(elem);
        current_queue.enq(elem);
        current_frame.add(elem);
//        System.out.println("ENQU:: "+ this + "; queue " + elem + " " + ret + ".");
        return ret;
    }
    /**
     * return true if the given element is in this StackSet.
     */
    public boolean contains(T elem){
        return elements.contains(elem)|| current_frame.contains(elem);
            //it will either be in the larger frame or in the current frame
    }
    /**
     * pushes all of the Queue-d up elements onto the stack
     */
    public void pushQueue(){
        Queue<T> push_queue = new Queue<T>();//the queue to push onto the stack
        while(!current_queue.isEmpty()){
            T elem = current_queue.deq();//dequeue an element
            {   
                //all of the elements added to this frame's queue should also be
                //in the current frame's set
                boolean b = current_frame.remove(elem);
                assert b : "problem with adding to the current frame";
            }
            
            elements.add(elem);//add to the larger set
            push_queue.enq(elem);//push onto the new queue
            
        }
        frames.push(push_queue);//add on the frame
        
        //current queue should be empty and ready for a new frame
        
//        System.out.println("PUSH:: "+this);
    }
    /**
     * dumps the last frame.
     * 
     * (reverts to the previous frame)
     * 
     * @return 
     */
    public void dump(){
        while(!current_queue.isEmpty()){
            //remove all of the data from the current frame
            current_frame.remove(current_queue.deq());
        }
        if(frames.isEmpty()) return;
            //we're on the lowest level, so we can't go down any further
        
        
        Queue<T> frame = frames.pop();
            //take off the top frame
        //we then restore to the previous frame, or add all of the elements from
        //frame to current_queue and current_frame. In addtion, we remove the
        //elements that frame contains from elements
        
        while(!frame.isEmpty()){
            T elem = frame.deq();//remove all elements from the frame
            
            current_frame.add(elem);
            current_queue.enq(elem);
            
            elements.remove(elem);
        }
//        System.out.println("DUMP:: "+this);
    }
    @Override
    public String toString(){
        return "elements: "+elements + ", current: " +current_frame;
    }
}