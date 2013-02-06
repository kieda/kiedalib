package org.kieda.search;

///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.kieda.search;
//
//import java.util.List;
//import test.Testable;
//
///**
// *
// * @author kieda
// */
//public class LinearSearch{
//    private static <T extends Comparable> boolean is_sorted(List<T> s){
//        if(s == null) return false;//nothing is not sorted?
//        //zero elements or one elemant is sorted. Alsoprevents array out of 
//        //bounds exceptions later on...
//        if(s.size()<=1) return true;
//        
//        //go through the elements.
//        for(int i = 1; i < s.size(); i++){
//            if(s.get(i-1).compareTo(s.get(i))>0) return false;
//        }
//        //Concept:
//        //      [0, 1, 2, 3, 4]
//        //compare [0,1]
//        //compare [1,2]
//        //compare [2,3]
//        //compare [3,4]
//        return true;
//    }
//    /**
//     * generic type of comparable values.
//     * 
//     * the boolean signifies if the input is sorted or not.
//     * If you say the list is search is sorted, and it isn't type-checking 
//     * by assertions will f-you up.
//     * 
//     * returns the integer position the element is at in the list.
//     */
//    public static <T extends Comparable> int linSearch(List<T> s, boolean is_sorted){
//        if(is_sorted) { assert is_sorted(s) : "List "+s + " is not sorted!";
//            return search_sorted(s);
//        }   return search_unsorted(s);
//    }
//    private static <T extends Comparable> int search_sorted(List<T> s){
//        
//    }
//    private static <T extends Comparable> int search_unsorted(List<T> s){
//        for(int i = 0; i < ){
//        }
//    }
//}
//
