//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: DS_My
// Files: DS_My.java
// Course: CS400 fall 2019
//
// Author: Kunlun Wang
// Email: kwang358@wisc.edu
// Lecturer's Name: Deb Deppeler
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NONE
// Partner Email: N/A
// Partner Lecturer's Name: NONE
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * The class mainly serves as a practice of how to design the basic function for a linked-list-
 * like data structure. 
 * 
 * @author Kunlun Wang & Deb Deppeler
 *
 */

public class DS_My <K extends Comparable <K>, V>implements DataStructureADT {

  /**
   * This is an inner class of the outer class, it serves to define the blue print or 
   * configuration of data structure that we will use in the outer class.
   * 
   * @author Kunlun Wang 
   *
   */
  private class dataStructureNode <K extends Comparable<K>,V> {
    private dataStructureNode<K,V> nextNode;
    private dataStructureNode<K,V> previousNode;
    private K key;
    private V value;
    
    /**
     * Constructor that set the default setting of the DS
     */
    private dataStructureNode(K key, V value) throws IllegalArgumentException {
      if (key == null) {
        throw new IllegalArgumentException("null key exception");
      }
      this.key = key;
      this.value = value;
      this.previousNode = null;
      this.nextNode = null;
    }
    /**
     * getter to get key
     */
    private K getKey() {
      return this.key;
    }
    
    /**
     * getter to get value
     */
    private V getValue() {
      return this.value;
    }
    
    /**
     * getter to get next node 
     */
    private dataStructureNode<K,V> getNextNode() {
      return this.nextNode;
    }
    
    /**
     * setter to set next node
     */
    private void setNextNode(dataStructureNode<K,V> newNextNode) {
      this.nextNode=newNextNode;
    }
    
    /**
     * determine if next node exists 
     */
    private boolean hasNextNode() {
      if (this.nextNode == null) {
        return false;
    }
      else {
        return true;
      }
    }
  }
  // end of inner class
  private dataStructureNode<K,V> rootNode;
  private int sizeOfDS;
  
  /**
   * constructor of outer class
   */
    public DS_My() {
      rootNode=null;
      sizeOfDS=0;
    }

    /**
     * insert a key-value pair at the tail of the DS
     * 
     * @param k, the key. v, the value 
     */
    @Override
    public void insert(Comparable k, Object v) throws IllegalArgumentException,RuntimeException {
      if (k == null) {
        throw new IllegalArgumentException("Attempt to insert null key");
    }
      if (this.contains(k)) {
        throw new RuntimeException("duplicate key exception");
      }
      
      if (rootNode == null) {
        rootNode = new dataStructureNode(k,v);
      }
      else {
        dataStructureNode currentNode = rootNode;
        while(currentNode.hasNextNode()) {
          currentNode = currentNode.getNextNode();
        }
          currentNode.setNextNode(new dataStructureNode(k,v));
        }
      sizeOfDS ++;
        
      }
    
    /**
     * remove method that will search for the key and remove it 
     * 
     * @param k, the key to remove
     */
    @Override
    public boolean remove(Comparable k) throws IllegalArgumentException  {
      if (k == null) {
        throw new IllegalArgumentException("Attempt to remove null key");
      }
      if (rootNode == null) {
        return false;
      }
      
      if (rootNode.getKey().equals(k)) {
        rootNode = rootNode.getNextNode();
        sizeOfDS--;
        return true;
      }
      
       if (rootNode.hasNextNode()) {
         dataStructureNode currentNode = rootNode.getNextNode();
         dataStructureNode previousNode = rootNode;
         
         while (currentNode != null) {
           previousNode = currentNode;
           currentNode = currentNode.getNextNode();
           
           if (previousNode.getKey().equals(k)) {
             previousNode.setNextNode(previousNode.getNextNode());
             sizeOfDS--;
             return true;
           }
           }
         }

        return false;
    }

    /**
     * contains method to detect of DS contains certain key
     * 
     * @param k, the key to detect
     */
    @Override
    public boolean contains(Comparable k) {
      if(k == null || rootNode == null) {
        return false;
      }
      
      if(rootNode.getKey().equals(k)) {
        return true;
      }
      
      dataStructureNode currentNode = rootNode;
      
      while (currentNode.hasNextNode()) {
        currentNode = currentNode.getNextNode();
        if (currentNode.getKey().equals(k)) {
          return true;
        }
      }
        return false;
    }

    /**
     * get method to get the value of the key
     * 
     * @param k, the key
     */
    @Override
    public Object get(Comparable k) {
      if (k == null) {
        throw new IllegalArgumentException("Attempting to get a null key");
      }
      if(rootNode == null) {
        return null;
      }
      if(rootNode.getKey().equals(k)) {
        return rootNode.getValue();
      }
      dataStructureNode currentNode = rootNode;
      while (currentNode.hasNextNode()) {
        if (currentNode.getKey().equals(k)) {
          return currentNode.getValue();
        }
      }
        return null;
    }

    /**
     * size method, return the size of DS
     */
    @Override
    public int size() {
        return sizeOfDS; 
        
    }

}
