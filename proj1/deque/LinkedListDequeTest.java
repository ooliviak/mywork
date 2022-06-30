package deque;

import org.junit.Test;
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

    }
    /** Make sure that removing from an empty LinkedListDeque does nothing */
    @Test
    public void removeEmptyTest() {
        lld.removeFirst();
        assertTrue(lld.isEmpty());


    }
    /** Make sure your LinkedListDeque also works on non-Integer types */
    @Test
    public void multipleParamsTest() {
        lld = new LinkedListDeque<String>();
        lld.addFirst(1);
        lld.removeFirst();
        assertTrue("lld should be empty", lld.isEmpty());
        lld = new LinkedListDeque<Double>();
        lld.addFirst(1);
        lld.removeFirst();
        assertTrue("lld should be empty", lld.isEmpty());

    }
    /** Make sure that removing from an empty LinkedListDeque returns null */
    @Test
    public void emptyNullReturn() {
        lld.removeFirst();
        assertNull("it should return null", lld);


    }
    /** TODO: Write tests to ensure that your implementation works for really large
     * numbers of elements, and test any other methods you haven't yet tested!
     */
    @Test
    public void size() {


    }

    @Test
    public void get() {

    }

//    @Test
//    public void addFirst() {
//
//    }
//
//    @Test
//    public void addLast() {
//
//    }
//
//    @Test
//    public void isEmpty() {
//
//    }
//
//    @Test
//    public void removeFirst() {
//
//    }
//
//    @Test
//    public void removeLast() {
//
//    }

}