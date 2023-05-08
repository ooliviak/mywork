package deque;

import org.junit.Test;

import java.util.Iterator;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ArrayDequeTest {

    @Test
    public void getTest() {
        ArrayDeque<String> lld = new ArrayDeque<String>();
        lld.addLast("a");
        lld.addLast("b");
        lld.addFirst("c");
        lld.addLast("d");
        lld.addLast("e");
        lld.addFirst("f");
        lld.printDeque();
        lld.get(0);
        lld.get(1);
        lld.get(5);
    }


    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {
        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());

        lld1.addFirst(20);
        lld1.addFirst(30);
        lld1.removeFirst();
    }


    @Test
    public void randomTest(){
        ArrayDeque<Integer> lld = new ArrayDeque<Integer>();
        lld.addFirst(0);
        lld.addFirst(1);
        lld.removeLast();
        lld.addFirst(3);
        int x = lld.removeLast();
        assertEquals(1, x);
        lld.addFirst(3);
        lld.removeLast();

        ArrayDeque<Integer> lld2 = new ArrayDeque<Integer>();
        lld2.addFirst(0);
        lld2.addFirst(1);
        lld2.addLast(2);
        int a = lld2.removeFirst();
        assertEquals(1, a);
        lld2.removeLast();
        lld2.removeFirst();

    }
    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    public void resizeTest() {
        ArrayDeque<Integer> lld = new ArrayDeque<>();
        lld.addFirst(0);
        lld.addLast(1);
        lld.addFirst(2);
        lld.addFirst(3);
        lld.addLast(4);
        lld.addLast(5);
        lld.addFirst(6);
        lld.addLast(7);
        lld.addFirst(8);
        lld.addFirst(9);
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {
        ArrayDeque<Integer> lld = new ArrayDeque<Integer>();
        for (int i = 0; i < 40; i++) {
            lld.addLast(i);
        }
        for (int i = 0; i < 24; i++) {
            lld.removeLast();
        }
    }

    @Test
    public void iteratorTest() {
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
        Iterator<Integer> x = ad.iterator();
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addLast(3);
        while (x.hasNext()) {
            int y = x.next();
            System.out.println(y);
        }
    }
    @Test
    public void getSampleTest() {
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
        ad.addLast(0);
        int ab = ad.get(0);
        assertEquals(0, ab);
        ad.addLast(2);
        ad.addLast(3);
        int abc = ad.get(2);
        assertEquals(3, abc);
        ad.addLast(5);
        ad.addLast(6);
        ad.removeFirst();
        ad.addLast(8);
        ad.addFirst(9);
        int g = ad.get(5);
        assertEquals(8, g);
        ad.addFirst(11);
        ad.removeFirst();
        ad.removeLast();
        ad.addLast(14);
        ad.addFirst(15);
        int h = ad.get(3);
        assertEquals(3, h);
        ad.addLast(17);
        ad.addLast(18);
        ad.addFirst(19);
        int d = ad.get(1);
        assertEquals(15, d);
    }
    @Test
    public void equals() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<Integer>();
        lld.addFirst(1);
        lld.addFirst(2);
        lld.addLast(3);
        lld.addFirst(4);

        ArrayDeque<Integer> lld2 = new ArrayDeque<Integer>();
        lld2.addFirst(1);
        lld2.addFirst(2);
        lld2.addLast(3);
        lld2.addFirst(4);
        lld.equals(lld2);
        lld2.equals(lld);
        lld.equals(lld);
        lld2.equals(lld2);


        Deque<Integer> lld3 = new LinkedListDeque<Integer>();
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
        lld3.addFirst(1);
        lld3.addLast(2);
        lld3.addLast(3);
        lld3.addLast(4);

        ad.addFirst(1);
        ad.addLast(2);
        ad.addLast(3);
        ad.addLast(4);
        lld3.equals(ad);
        assertTrue(lld3.equals(ad));


    }


}
