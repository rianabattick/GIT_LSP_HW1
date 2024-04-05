package org.howard.edu.lsp.assignment4;

import java.util.ArrayList;
import java.util.List;

/**
 * The IntegerSet class represents a collection of unique integers.
 * This class provides methods to perform set operations such as add, remove,
 * union, intersection, and difference, as well as utility functions like checking
 * if the set contains a specific value, finding the largest or smallest value, and
 * checking if the set is empty.
 */
public class IntegerSet {
    private List<Integer> set;

    /**
     * Default constructor that initializes the set as an empty ArrayList of Integers.
     */
    public IntegerSet() {
        this.set = new ArrayList<>();
    }

    /**
     * Constructor that initializes the set with a given ArrayList of Integers.
     * Duplicates in the provided list will not be removed.
     * @param set an ArrayList of Integers to initialize the set
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = new ArrayList<>(set);
    }

    /**
     * Clears the set, removing all elements.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     * @return the size of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Compares the current set with another object for equality.
     * Two sets are considered equal if they contain the same elements, regardless of order.
     * @param o the object to be compared for equality with this set
     * @return true if the specified object is equal to this set
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntegerSet)) return false;
        IntegerSet that = (IntegerSet) o;
        return this.set.size() == that.set.size() && this.set.containsAll(that.set);
    }

    /**
     * Checks if the set contains a specific integer value.
     * @param value the value to search for in the set
     * @return true if the set contains the specified value
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Finds and returns the largest element in the set.
     * @return the largest element in the set
     * @throws Exception 
     * @throws IntegerSetException if the set is empty
     */
    public int largest() throws Exception {
        if (set.isEmpty()) {
            throw new Exception("The set is empty.");
        }
        return set.stream().max(Integer::compare).orElseThrow();
    }

    /**
     * Finds and returns the smallest element in the set.
     * @return the smallest element in the set
     * @throws Exception 
     * @throws IntegerSetException if the set is empty
     */
    public int smallest() throws Exception {
        if (set.isEmpty()) {
            throw new Exception("The set is empty.");
        }
        return set.stream().min(Integer::compare).orElseThrow();
    }

    /**
     * Adds a new element to the set if it is not already present.
     * @param item the integer value to be added to the set
     */
    public void add(int item) {
        if (!contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an element from the set if it is present.
     * @param item the integer value to be removed from the set
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Updates this set to be the union of itself and another set.
     * After this operation, it will contain all elements that are in either set.
     * @param intSetb another IntegerSet to perform the union with
     */
    public void union(IntegerSet intSetb) {
        intSetb.set.forEach(this::add);
    }

    /**
     * Updates this set to be the intersection of itself and another set.
     * After this operation, it will only contain elements that are in both sets.
     * @param intSetb another IntegerSet to perform the intersection with
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /**
     * Updates this set to be the difference of itself and another set.
     * After this operation, it will only contain elements that are in this set but not in the other.
     * @param intSetb another IntegerSet to perform the difference with
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }
}
   
