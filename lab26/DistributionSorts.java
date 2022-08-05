import java.util.Arrays;

public class DistributionSorts {

    /* Destructively sorts ARR using counting sort. Assumes that ARR contains
       only 0, 1, ..., 9. */
    public static void countingSort(int[] arr) {
        // TODO: YOUR CODE HERE
        int[] count = new int[10];
        int[] starts = new int[10];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]] ++;
        }

//        for (int i = 0; i < count.length; i++) {
//            starts[i] = count[i];
//        }
//
//        for (int i = 0; i < count.length; i++) {
//            if (i == 0) {
//                starts[i] = 0;
//            } else if (i == 1) {
//                starts[i] = count[0];
//            } else {
//                starts[i] = count[i-1] + starts[i-1];
//            }
//        }

        int k = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[k] = i;
                k++;
            }
        }
    }

    /* Destructively sorts ARR using LSD radix sort. */
    public static void lsdRadixSort(int[] arr) {
        int maxDigit = mostDigitsIn(arr);
        for (int d = 0; d < maxDigit; d++) {
            countingSortOnDigit(arr, d);
        }
    }

    /* A helper method for radix sort. Modifies ARR to be sorted according to
       DIGIT-th digit. When DIGIT is equal to 0, sort the numbers by the
       rightmost digit of each number. */
    private static void countingSortOnDigit(int[] arr, int digit) {
        // TODO: YOUR CODE HERE
        int[] count = new int[10];
        int range = 10;
        int[] sorted = new int[arr.length];
        int num = 0;

        if (digit == 0) {
            digit = digit + 1;
        } else {
            int temp = digit;
            double x = (double) 1 / digit;
            digit = (int) (digit * x);
            int c = 0;
            while (c < temp) {
                digit = digit * 10;
                c++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            num = (arr[i] / digit) % range;
            count[num] ++;
        }

        for (int i = 1; i < range; i++) {
            count[i] = count[i] + count[i-1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            num = (arr[i] / digit) % range;
            sorted[count[num] - 1] = arr[i];
            count[num]--;
        }

        System.arraycopy(sorted, 0, arr, 0, arr.length);

    }

    /* Returns the largest number of digits that any integer in ARR has. */
    private static int mostDigitsIn(int[] arr) {
        int maxDigitsSoFar = 0;
        for (int num : arr) {
            int numDigits = (int) (Math.log10(num) + 1);
            if (numDigits > maxDigitsSoFar) {
                maxDigitsSoFar = numDigits;
            }
        }
        return maxDigitsSoFar;
    }

    /* Returns a random integer between 0 and 9999. */
    private static int randomInt() {
        return (int) (10000 * Math.random());
    }

    /* Returns a random integer between 0 and 9. */
    private static int randomDigit() {
        return (int) (10 * Math.random());
    }

    private static void runCountingSort(int len) {
        int[] arr1 = new int[len];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = randomDigit();
        }
        System.out.println("Original array: " + Arrays.toString(arr1));
        countingSort(arr1);
        if (arr1 != null) {
            System.out.println("Should be sorted: " + Arrays.toString(arr1));
        }
    }

    private static void runLSDRadixSort(int len) {
        int[] arr2 = new int[len];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = randomInt();
        }
        System.out.println("Original array: " + Arrays.toString(arr2));
        lsdRadixSort(arr2);
        System.out.println("Should be sorted: " + Arrays.toString(arr2));

    }

    public static void main(String[] args) {
//        runCountingSort(20);
        runLSDRadixSort(3);
//        runLSDRadixSort(30);
    }
}