//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: DataStructureADT
// Files: DataStructureADT.java
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
 * A data structure that can store at least 500 key,value pairs.
 *
 * May not use any of Java's built-in Java collection types:
 * such as: List, ArrayList, LinkedList, etc...
 * 
 * May not add any public members (fields, methods, inner classes)
 * 
 * @author deppeler
 *
 * @param <K> The key must not be null and must be Comparable.
 * @param <V> The data value associated with a given key.
 */
public interface DataStructureADT<K extends Comparable<K>, V> {

    // Add the key,value pair to the data structure and increases size.
    // If key is null, throws IllegalArgumentException("null key");
    // If key is already in data structure, throws RuntimeException("duplicate key");
    // can accept and insert null values
    void insert(K key, V value);

    // If key is found, Removes the key from the data structure and decreases size
    // If key is null, throws IllegalArgumentException("null key") without decreasing size
    // If key is not found, returns false.
    boolean remove(K key);

    // Returns the value associated with the specified key
    // get - does not remove key or decrease size
    // If key is null, throws IllegalArgumentException("null key") 
    V get(K key);

    // Returns true if the key is in the data structure
    // Returns false if key is null or not present
    boolean contains(K key);

    // Returns the number of elements in the data structure
    int size();

}
