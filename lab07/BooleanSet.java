import java.util.ArrayList;
import java.util.List;

/**
 * Represent a set of nonnegative ints from 0 to maxElement for some initially
 * specified maxElement.
 */
public class BooleanSet implements SimpleSet {

    private boolean[] contains;
    private int size;

    /** Initializes a set of ints from 0 to maxElement. */
    public BooleanSet(int maxElement) {
        contains = new boolean[maxElement + 1];
        size = 0;
    }

    /** Adds k to the set. */
    public void add(int k) {
        size ++;
        if (contains[k]) {
            size --;
        } else {
            contains[k] = true;
        }

    }

    /** Removes k from the set. */
    public void remove(int k) {
        if (contains[k] == false) {
            contains[k] = false;
        } else {
            size --;
            contains[k] = false;
        }

//        size --;
//        contains[k] = false;
    }

    /** Return true if k is in this set, false otherwise. */
    public boolean contains(int k) {
        return contains[k];
    }

    /** Return true if this set is empty, false otherwise. */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /** Returns the number of items in the set. */
    public int size() {
        //TODO
        return size;
    }

    /** Returns an array containing all of the elements in this collection. */
    public int[] toIntArray() {
        int[] arr = new int[size];
        int j = 0;
        for (int i = 0; i < contains.length; i++) {
            if (contains[i]) {
                arr[j] = i;
                j++;
            }
        }
        return arr;
    }
}
