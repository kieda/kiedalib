/**
 * NOT by be. Shamelessly stolen from oracle...
 */
package org.kieda.data_structures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Trie<T> {
  /** Size of the m_nextChar array.  */
  public static final int ALPHA_SIZE = 128;

  /** The root node of the tree.    */
  Node m_Root;

  /** helper buffer to convert Strings to char arrays */
  private char[] m_charBuffer = new char[0];

  /**
   * Construct the trie.
   */
  public Trie() {
    m_Root = new Node();
  }
  private Set<String> items = new HashSet<String>();
  /**
   * Put an object into the trie for lookup.
   *
   * @param key must be a 7-bit ASCII string
   * @param value any java object.
   *
   * @return The old object that matched key, or null.
   * 
   */
  public T put(String key, T value){
    final int len = key.length();
    if (len > m_charBuffer.length) {
        // make the biggest buffer ever needed in get(String)
        m_charBuffer = new char[len];
    }

    Node<T> node = m_Root;

    for (int i = 0; i < len; i++) {
      Node nextNode = node.m_nextChar[Character.toUpperCase(key.charAt(i))];

      if (nextNode != null) {
        node = nextNode;
      }
      else {
        for (; i < len; i++) {
          Node newNode = new Node();
          // put this value into the tree with a case insensitive key
          node.m_nextChar[Character.toUpperCase(key.charAt(i))] = newNode;
          node.m_nextChar[Character.toLowerCase(key.charAt(i))] = newNode;
          node = newNode;
        }
        break;
      }
    }
    items.add(key);
    T ret = node.m_Value;

    node.m_Value = value;
    
    return ret;
  }

  /**
   * Get an object that matches the key.
   *
   * @param key must be a 7-bit ASCII string
   *
   * @return The object that matches the key, or null.
   */
    public T get(final String key) {

        final int len = key.length();

        /* If the name is too long, we won't find it, this also keeps us
        * from overflowing m_charBuffer
        */
        if (m_charBuffer.length < len)
            return null;
        Node<T> node = m_Root;
        // optimize the look up based on the number of chars
        switch (len) {
            // case 0 looks silly, but the generated bytecode runs
            // faster for lookup of elements of length 2 with this in
            // and a fair bit faster.  Don't know why.
            case 0 : {
                    return null;
                }
            case 1 : {
                    final char ch = key.charAt(0);
                    if (ch < ALPHA_SIZE)
                    {
                        node = node.m_nextChar[ch];
                        if (node != null)
                            return node.m_Value;
                    }
                    return null;
                }
            default : {
                    key.getChars(0, len, m_charBuffer, 0);
                    // copy string into array
                    for (int i = 0; i < len; i++) {
                        final char ch = m_charBuffer[i];
                        if (ALPHA_SIZE <= ch) {
                            // the key is not 7-bit ASCII so we won't find it here
                            return null;
                        }

                        node = node.m_nextChar[ch];
                        if (node == null)
                            return null;
                    }

                    return node.m_Value;
                }
        }
    }

    public List<T> list(){
        List<T> ret = new ArrayList<T>();
        for(String i : items){
            ret.add(get(i));
        }
        return ret;
    }
    public boolean isEmpty(){
        return items.isEmpty();
    }
    @Override public String toString(){
        String s = "{";
        for(String i: items){
            s += i+ "="+ get(i) + ",";
        }
        if(items.size() > 0)
            s += "\b";
        s+="}";
        return s;
    }
    /**
    * The node representation for the trie.
    */
    class Node<T> {
        /**
        * Constructor, creates a Node[ALPHA_SIZE].
        */
        Node() {
        m_nextChar = new Node[ALPHA_SIZE];
        m_Value = null;
        }
        /** The next nodes.   */
        Node m_nextChar[];
        /** The value.   */
        T m_Value;
    }
}
