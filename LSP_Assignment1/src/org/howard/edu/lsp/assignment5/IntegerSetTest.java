package org.howard.edu.lsp.assignment5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class IntegerSetTest {
    private IntegerSet integerSet;

    @BeforeEach
    public void setUp() {
        integerSet = new IntegerSet();
    }

    @Test
    @DisplayName("Test case for clear")
    public void testClear() {
        integerSet.add(5);
        integerSet.add(10);
        integerSet.clear();
        assertEquals(0, integerSet.length());
    }

    @Test
    @DisplayName("Test case for length")
    public void testLength() {
        assertEquals(0, integerSet.length());
        integerSet.add(5);
        assertEquals(1, integerSet.length());
    }

    @Test
    @DisplayName("Test case for equals")
    public void testEquals() {
        IntegerSet otherSet = new IntegerSet();
        otherSet.add(5);
        otherSet.add(10);
        integerSet.add(10);
        integerSet.add(5);
        assertTrue(integerSet.equals(otherSet));
    }

    @Test
    @DisplayName("Test case for contains")
    public void testContains() {
        integerSet.add(5);
        assertTrue(integerSet.contains(5));
        assertFalse(integerSet.contains(10));
    }

    @Test
    @DisplayName("Test case for largest")
    public void testLargest() {
        assertThrows(Exception.class, () -> integerSet.largest());
        integerSet.add(5);
        integerSet.add(10);
        assertEquals(10, integerSet.largest());
    }

    @Test
    @DisplayName("Test case for smallest")
    public void testSmallest() {
        assertThrows(Exception.class, () -> integerSet.smallest());
        integerSet.add(5);
        integerSet.add(10);
        assertEquals(5, integerSet.smallest());
    }

    @Test
    @DisplayName("Test case for add")
    public void testAdd() {
        integerSet.add(5);
        assertTrue(integerSet.contains(5));
    }

    @Test
    @DisplayName("Test case for remove")
    public void testRemove() {
        integerSet.add(5);
        integerSet.remove(5);
        assertFalse(integerSet.contains(5));
    }

    @Test
    @DisplayName("Test case for union")
    public void testUnion() {
        IntegerSet otherSet = new IntegerSet();
        otherSet.add(5);
        otherSet.add(10);
        integerSet.add(5);
        integerSet.union(otherSet);
        assertTrue(integerSet.contains(10));
    }

    @Test
    @DisplayName("Test case for intersect")
    public void testIntersect() {
        IntegerSet otherSet = new IntegerSet();
        otherSet.add(5);
        otherSet.add(10);
        integerSet.add(5);
        integerSet.add(10);
        integerSet.intersect(otherSet);
        assertTrue(integerSet.contains(5));
        assertTrue(integerSet.contains(10));
    }

    @Test
    @DisplayName("Test case for diff")
    public void testDiff() {
        IntegerSet otherSet = new IntegerSet();
        otherSet.add(5);
        otherSet.add(10);
        integerSet.add(5);
        integerSet.add(10);
        integerSet.diff(otherSet);
        assertFalse(integerSet.contains(5));
        assertFalse(integerSet.contains(10));
    }
}
