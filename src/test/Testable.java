/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author kieda
 */
public abstract class Testable extends BigO{
//    protected void pause(){}
    
    //process the next step in the algorithm
    protected abstract void step(int step_id);
    
    //is the algorithm ready to exit?
    public abstract boolean exit();
    
    
    //if we should exit, return whatever data.
    protected abstract Object return_o();
    
    //the input args for the function. The client should parse these args 
    //accordingly
    protected abstract void input(Object args);
}
/**
 * example case: testing an algo for searching.
 * 
 * What I want to happen:
 * 
 * input args. The user parses them and checks that they're correct.
 *      EX: input args is a list that has comparable elements.
 *          the client class then makes a local variable based on the inputs.
 * 
 * function call:
 *      
 * 
 */