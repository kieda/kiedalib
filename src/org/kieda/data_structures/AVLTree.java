/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kieda.data_structures;

public class AVLTree <T extends Comparable> {
    private enum EQUALITY{EQUAL_TO, LESS_THAN, GREATER_THAN}
    private static final int EQUAL_TO = 0;
    private static final int LESS_THAN = 1;
    private static final int GREATER_THAN = 2;
    private Node head;//the root. Initially NULL.
    private int min_depth = 0;
        //the minimum depth of the AVL tree (what's the minimum number of nodes
        //we have to traverse to get to a leaf?)
    public AVLTree(){
        head  = null;
    }
    //adds on an elem of type T
    public void add(T elem){
        //initialize new node
        Node<T> n = new Node<T>();
        n.data = elem;
        //find out where to put the node
        Node curr = head;//we start searching at the head and work our way down.
        int num_traversals = 0;
        beaker:for(;;){
            if(curr == null){//we arrive at the leaf we're looking for.
                //place the node
                curr = n;
                //something about minimum vs. maximum depth.
                break beaker;
            }
            int compy = compare(n, curr);
            swapsy:switch(compy){
                case EQUAL_TO:
                case LESS_THAN://n is less than or equal to the current node.
                    curr = curr.lchild; break swapsy;
                case GREATER_THAN://n is greater than or equal to the current node.
                    curr = curr.rchild; break swapsy;
            }
            num_traversals++;//we went down the tree once...
            //continue on our placement search...
        }
        //find out if this causes an imbalance in the AVL tree.
        if(Math.abs(num_traversals - min_depth)>1){
            System.out.println("hey!");
            //rotate left or right?
        }
    }
    //node on the tree
    private class Node<T extends Comparable>{
        Node<T> lchild;//left child le to top
        Node<T> rchild;//right child g to top
        T data;//data being stored. Implements comparable.
    }
    public void rotate_right(Node pos){
        
    }
    public void rotate_left(Node pos){
    }
    private int compare(Node n1, Node n2){
        int cc = n1.data.compareTo(n2.data);
        if(cc>0) return GREATER_THAN;
        else if(cc==0) return EQUAL_TO;
        else return LESS_THAN;
    }
}
