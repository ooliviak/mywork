public class ArrayOperations {
    /**
     * Delete the value at the given position in the argument array, shifting
     * all the subsequent elements down, and storing a 0 as the last element of
     * the array.
     */
    public static void delete(int[] values, int pos) {
        if (pos < 0 || pos >= values.length) {
            return;
        }
        // TODO: YOUR CODE HERE
        for (pos = 0; pos < values.length; pos += 1) {
            values[pos] = values[pos+1];
            if (pos == (values.length - 1)) {
                values[pos] = 0;
            }
        }

    }

    /**
     * Insert newInt at the given position in the argument array, shifting all
     * the subsequent elements up to make room for it. The last element in the
     * argument array is lost.
     */
    public static void insert(int[] values, int pos, int newInt) {
        if (pos < 0 || pos >= values.length) {
            return;
        }
        values[pos] = newInt;
        for (pos = 0; pos < values.length; pos += 1) {
            values[pos];

            if (pos )
                values[pos + 1] = values[pos + 2];
        }
    }

    /** 
     * Returns a new array consisting of the elements of A followed by the
     *  the elements of B. 
     */
    public static int[] catenate(int[] A, int[] B) {
        // TODO: YOUR CODE HERE
        return null;
    }

}