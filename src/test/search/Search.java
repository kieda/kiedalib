/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.search;

import test.Testable;

/**
 *
 * @author kieda
 */
public abstract class Search extends Testable {
    @Override protected Object return_o(){
        return (Integer)ret();
    }
    protected int sid = 0;
    @Override protected void step(int step_id){
//        step(); sid++;
    }
    public abstract void step();
    public abstract int ret();
}
