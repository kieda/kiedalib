/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.search;

import org.kieda.util.error.InvalidInputException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import test.Testable;

/**
 * Searches a list and returns the index it should be at.
 * @author kieda
 */
public abstract class SortedSearch<T extends Comparable> extends Search{
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
//            else if(!((List)b[0]).isEmpty()||((List)b[0]).get(0) instanceof Comparable)
//                throw new InvalidInputException("args[0] is of List<? extends Comparable> and args[1] is of Integer");
            else if(!(b[1] instanceof Integer))
                throw new InvalidInputException("args[1] should be of type Integer");
        }
        catch(Exception e){e.printStackTrace();}
        list = (List<T>)(((Object[])args)[0]);
        this.item = (T)(((Object[])args)[1]);
    }
    public void input(List<T> args, T item){
        input((Object)(new Object[]{args, item}));
    }
    public void input(T item, T... list){
        input((Object)(new Object[]{Arrays.asList(list), item}));
    }
}
