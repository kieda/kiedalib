/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.search;

import org.kieda.util.error.InvalidInputException;
import java.util.Arrays;
import java.util.List;

public abstract class UnsortedSearch<T> extends Search{
    protected List<T> list;
    protected T item;
    @Override protected void input(Object args){
//        list = (List<T>)  args;//convert types. Might throw error if not tested properly
        //we don't need no stinking methods here.\
        try{
        if(!(args instanceof Object[])){
            throw new InvalidInputException("this input is of type of Object[]");
        }
            Object[] b = (Object[])args;
            if(!(b[0] instanceof List))
                throw new InvalidInputException("args[0] is of List<? extends Comparable> and args[1] is of Integer");
            else if(!((List)b[0]).isEmpty()||((List)b[0]).get(0) instanceof Comparable)
                throw new InvalidInputException("args[0] is of List<? extends Comparable> and args[1] is of Integer");
            else if(!(b[1] instanceof Integer))
                throw new InvalidInputException("args[1] should be of type Integer");
        }
        catch(Exception e){e.printStackTrace();}        
    }
    public void input(List<T> args, T item){
        list = args;
        this.item = item;
    }
    public void input(T item, T... list){
        this.list = Arrays.asList(list);
        this.item = item;
    }
}
