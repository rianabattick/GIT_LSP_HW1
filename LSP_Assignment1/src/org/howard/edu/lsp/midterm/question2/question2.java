/**
 * The IntegerRange class implements the Range interface, providing functionality
 * to work with a range of integers, including checking containment, overlap, and size.
 */
public class IntegerRange implements Range {
    private int lowerBound;
    private int upperBound;

    /**
     * Constructs an IntegerRange with specified lower and upper bounds.
     *
     * @param lowerBound the lowest integer in the range
     * @param upperBound the highest integer in the range
     */
    public IntegerRange(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    /**
     * Checks if the given value is within the range.
     *
     * @param value the value to check
     * @return true if the value is within the range, false otherwise
     */
    @Override
    public boolean contains(int value) {
        return value >= lowerBound && value <= upperBound;
    }

    /**
     * Checks if this range overlaps with another range.
     *
     * @param other the other range to check against
     * @return true if there is any overlap, false otherwise
     */
    @Override
    public boolean overlaps(Range other) {
        if (other instanceof IntegerRange) {
            IntegerRange otherRange = (IntegerRange) other;
            return this.lowerBound <= otherRange.upperBound && this.upperBound >= otherRange.lowerBound;
        }
        return false;
    }

    /**
     * Returns the size of the range, inclusive.
     *
     * @return the number of integers within the range
     */
    @Override
    public int size() {
        return upperBound - lowerBound + 1;
    }

    /**
     * Checks if this range is equal to another object.
     *
     * @param obj the object to compare with
     * @return true if the object is a range with the same lower and upper bounds, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof IntegerRange)) return false;
        IntegerRange other = (IntegerRange) obj;
        return this.lowerBound == other.lowerBound && this.upperBound == other.upperBound;
    }
}

/**
 * The RangeTester class is used to demonstrate and test the functionality of the IntegerRange class.
 */
public class RangeTester {
    /**
     * Main method to test the IntegerRange class methods.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        IntegerRange range1 = new IntegerRange(1, 10);
        IntegerRange range2 = new IntegerRange(5, 15);
        IntegerRange range3 = new IntegerRange(11, 20);

        System.out.println("Range1 contains 5: " + range1.contains(5)); // true
        System.out.println("Range1 overlaps with Range2: " + range1.overlaps(range2)); // true
        System.out.println("Range1 overlaps with Range3: " + range1.overlaps(range3)); // false
        System.out.println("Size of Range1: " + range1.size()); // 10
        System.out.println("Range1 equals Range2: " + range1.equals(range2)); // false
        System.out.println("Range2 equals Range3: " + range2.equals(range3)); // false
    }
}
