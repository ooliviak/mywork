package deque;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/* Performs some basic array deque tests. */
public class ArrayDequeTest {

    /** You MUST use the variable below for all of your tests. If you test
     * using a local variable, and not this static variable below, the
     * autograder will not grade that test. If you would like to test
     * ArrayDeques with types other than Integer (and you should),
     * you can define a new local variable. However, the autograder will
     * not grade that test. */

    public static Deque<Integer> ad = new ArrayDeque<Integer>();
    @Test
    /** Adds a few things to the list, checks that isEmpty() is correct.
     * This is one simple test to remind you how junit tests work. You
     * should write more tests of your own.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        assertTrue("A newly initialized LLDeque should be empty", ad.isEmpty());
        ad.addFirst(0);
        ad.addFirst(3);
        assertFalse("lld1 should now contain 1 item", ad.isEmpty());

        ad = new ArrayDeque<Integer>();

        ad.addFirst(3);
        ad.addFirst(1);
        assertFalse("11d2 should now contain 2 items", ad.isEmpty());
        ad = new ArrayDeque<Integer>();
        assertTrue("A newly initialized LLDeque should be empty", ad.isEmpty());


    }

    /** Adds an item, removes an item, and ensures that dll is empty afterwards. */
    @Test
    public void addRemoveTest() {
        ad.addFirst(1);
        ad.removeFirst();
        assertTrue("lld should be empty", ad.isEmpty());

        ad = new ArrayDeque<Integer>();
        ad.addFirst(1);
        ad.addFirst(2);
        ad.removeFirst();
        assertFalse(ad.isEmpty());

        ad = new ArrayDeque<Integer>();
        ad.addFirst(1);
        ad.addFirst(2);
        ad.removeFirst();
        ad.removeFirst();
        assertTrue(ad.isEmpty());

        ad.addLast(1);
        ad.removeLast();
        assertTrue("lld should be empty", ad.isEmpty());

        ad = new ArrayDeque<Integer>();
        ad.addFirst(1);
        ad.addFirst(2);
        int x = ad.get(0);
        assertEquals(2, x);


        ad = new ArrayDeque<Integer>();
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addLast(3);
        ad.addFirst(4);
        ad.removeLast();
        ad.addLast(5);
        ad.addLast(6);
        ad.removeLast();
        int z = ad.get(0);
        assertEquals(4, z);


    }
    /** Make sure that removing from an empty LinkedListDeque does nothing */
    @Test
    public void removeEmptyTest() {
        ad = new ArrayDeque<Integer>();
        ad.removeFirst();
        assertTrue(ad.isEmpty());


    }
    /** Make sure your LinkedListDeque also works on non-Integer types */
    @Test
    public void printDeque() {
        ad = new ArrayDeque<Integer>();
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addFirst(2);
        ad.removeFirst();
        ad.printDeque();
    }
    @Test
    public void multipleParamsTest() {

        Deque<String> ad2 = new ArrayDeque<String>();
        ad2.addFirst("cat");
        ad2.addFirst("dog");
        ad2.addFirst("cow");
        ad2.addLast("duck");
        ad2.addLast("bear");
        ad2.removeFirst();
        assertFalse(ad2.isEmpty());
        assertEquals(4, ad2.size());
        String y = ad2.get(1);
        assertEquals("cat", y);
        String x = ad2.get(3);
        assertEquals("bear", x);

        ArrayDeque<Double> ad3 = new ArrayDeque<Double>();
        ad3.addFirst(1.0);
        ad3.addFirst(2.0);
        ad3.removeLast();

    }
    /** Make sure that removing from an empty LinkedListDeque returns null */
    @Test
    public void emptyNullReturn() {

        ad = new ArrayDeque<Integer>();
        ad.removeFirst();
        assertEquals(0, ad.size());
        assertNull("it should return null", ad.removeFirst());


    }
    /** TODO: Write tests to ensure that your implementation works for really large
     * numbers of elements, and test any other methods you haven't yet tested!
     */

    @Test
    public void get() {
        ad = new ArrayDeque<Integer>();
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addLast(2);
        ad.addLast(4);
        ad.removeFirst();
        assertEquals(3, ad.size());
//        int y = ad.get(1);
//        assertEquals(2, y);

        Deque<String> ad3 = new ArrayDeque<String>();
        ad3.addLast(String.valueOf('a'));
        ad3.addLast(String.valueOf('b'));
        ad3.addFirst(String.valueOf('c'));
        ad3.addLast(String.valueOf('d'));
        ad3.addLast(String.valueOf('e'));
        ad3.addFirst(String.valueOf('f'));
        assertEquals(6, ad3.size());
        ad3.get(4);
        assertEquals(String.valueOf('d'), ad3.get(4));

    }

    @Test
    public void equals() {
        ad = new ArrayDeque<Integer>();
        ad.addFirst(1);
        ad.addFirst(2);

        Deque<Integer> ad2 = new ArrayDeque<Integer>();
        ad2.addFirst(1);
        ad2.addFirst(2);

        assertTrue("List should equal itself.", ad.equals(ad));
        assertTrue("List should equal itself.", ad2.equals(ad2));
        assertTrue("ad should equal ad2.", ad.equals(ad2));
        assertTrue("ad2 should equal ad.", ad2.equals(ad));

        Deque<Integer> ad3 = new ArrayDeque<Integer>();
        ad3.addFirst(1);
        assertFalse("ad should not equal ad3.", ad.equals(ad3));


    }
}
