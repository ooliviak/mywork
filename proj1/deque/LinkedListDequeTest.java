package deque;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;


/** Performs some basic linked list deque tests. */
public class LinkedListDequeTest {

    /** You MUST use the variable below for all of your tests. If you test
     * using a local variable, and not this static variable below, the
     * autograder will not grade that test. If you would like to test
     * LinkedListDeques with types other than Integer (and you should),
     * you can define a new local variable. However, the autograder will
     * not grade that test. Please do not import java.util.Deque here!*/

    public static Deque<Integer> lld = new LinkedListDeque<Integer>();

    @Test
    /** Adds a few things to the list, checks that isEmpty() is correct.
     * This is one simple test to remind you how junit tests work. You
     * should write more tests of your own.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {
		assertTrue("A newly initialized LLDeque should be empty", lld.isEmpty());
		lld.addFirst(0);
        lld.addFirst(3);
        assertFalse("lld1 should now contain 1 item", lld.isEmpty());

        lld = new LinkedListDeque<Integer>(); //Assigns lld equal to a new, clean LinkedListDeque!

        lld.addFirst(3);
        lld.addFirst(1);
        assertFalse("11d2 should now contain 2 items", lld.isEmpty());
        lld = new LinkedListDeque<Integer>();
        assertTrue("A newly initialized LLDeque should be empty", lld.isEmpty());


    }

    /** Adds an item, removes an item, and ensures that dll is empty afterwards. */
    @Test
    public void addRemoveTest() {
        lld.addFirst(1);
        lld.removeFirst();
        assertTrue("lld should be empty", lld.isEmpty());

        lld = new LinkedListDeque<Integer>();
        lld.addFirst(1);
        lld.addFirst(2);
        lld.removeFirst();
        assertFalse(lld.isEmpty());

        lld = new LinkedListDeque<Integer>();
        lld.addFirst(1);
        lld.addFirst(2);
        lld.removeFirst();
        lld.removeFirst();
        assertTrue(lld.isEmpty());

        lld.addLast(1);
        lld.removeLast();
        assertTrue("lld should be empty", lld.isEmpty());

        lld = new LinkedListDeque<Integer>();
        lld.addFirst(1);
        lld.addFirst(2);
        lld.removeFirst();
        int y = lld.get(0);
        assertEquals(1, y);

        lld = new LinkedListDeque<Integer>();
        lld.addFirst(0);
        lld.addLast(1);
        lld.removeFirst();
        lld.removeLast();
        lld.isEmpty();
        lld.addLast(5);
        lld.addLast(6);
        lld.size();
        lld.removeLast();
        lld.addFirst(9);
        lld.removeLast();

    }
    /** Make sure that removing from an empty LinkedListDeque does nothing */
    @Test
    public void removeEmptyTest() {
        lld = new LinkedListDeque<Integer>();
        lld.removeFirst();
        assertTrue(lld.isEmpty());


    }
    /** Make sure your LinkedListDeque also works on non-Integer types */
    @Test
    public void printDeque() {
        lld = new LinkedListDeque<Integer>();
        lld.addFirst(1);
        lld.addFirst(2);
        lld.addFirst(2);
        lld.removeFirst();
        lld.printDeque();


    }
    @Test
//    public static Deque<String> lld2 = new LinkedListDeque<String>();
//    public static Deque<Double> lld3 = new LinkedListDeque<Integer>();

    public void multipleParamsTest() {
        Deque<String> lld2 = new LinkedListDeque<String>();
        lld2.addFirst("cat");
        lld2.addFirst("dog");
        lld2.addFirst("cow");
        lld2.addLast("duck");
        lld2.addLast("bear");
        lld2.removeFirst();
        assertFalse(lld2.isEmpty());
        assertEquals(4, lld2.size());
        String y = lld2.get(1);
        assertEquals("cat", y);
        String x = lld2.get(3);
        assertEquals("bear", x);

        Deque<Double>  lld3 = new LinkedListDeque<Double>();
        lld3.addFirst(1.0);
        lld3.addFirst(2.0);
        lld3.removeLast();
        lld3.removeLast();
        assertTrue("lld3 should be empty", lld3.isEmpty());

    }
    /** Make sure that removing from an empty LinkedListDeque returns null */
    @Test
    public void emptyNullReturn() {
        lld = new LinkedListDeque<Integer>();
        lld.removeFirst();
        assertNull("it should return null", lld.removeFirst());


    }
    /** TODO: Write tests to ensure that your implementation works for really large
     * numbers of elements, and test any other methods you haven't yet tested!
     */

    @Test
    public void get() {
        lld = new LinkedListDeque<Integer>();
        lld.addFirst(1);
        lld.addFirst(2);
        lld.addLast(2);
        lld.addLast(4);
        lld.removeFirst();
        assertEquals(3, lld.size());
        assertEquals(null, lld.get(5));
        assertEquals(null, ((LinkedListDeque<Integer>)lld).getRecursive(5));
        int y = lld.get(1);
        assertEquals(2, y);
        ((LinkedListDeque<Integer>)lld).getRecursive(1);
        int x = ((LinkedListDeque<Integer>)lld).getRecursive(1);
        ((LinkedListDeque<Integer>)lld).getRecursive(2);
        int z = ((LinkedListDeque<Integer>)lld).getRecursive(2);
        assertEquals(4, z);

    }

    @Test
    public void equals() {
        lld = new LinkedListDeque<Integer>();
        lld.addFirst(1);
        lld.addFirst(2);

        Deque<Integer> lld2 = new LinkedListDeque<Integer>();
        lld2.addFirst(1);
        lld2.addFirst(2);

        assertTrue("List should equal itself.", lld.equals(lld));
        assertTrue("List should equal itself.", lld2.equals(lld2));
        assertTrue("lld should equal lld2.", lld.equals(lld2));
        assertTrue("lld2 should equal lld.", lld2.equals(lld));

        Deque<Integer> lld3 = new LinkedListDeque<Integer>();
        lld3.addFirst(1);
        assertFalse("lld should not equal lld3.", lld.equals(lld3));

    }


}
