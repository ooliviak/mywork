import org.junit.Test;

import static org.junit.Assert.*;

public class MinHeapTest {

//    public static MinHeap<Integer> test = new MinHeap<Integer>();

    @Test
    public void test1() {
        MinHeap<Integer> test = new MinHeap<Integer>();
        test.insert(1);
        test.insert(2);
        test.insert(3);
        test.insert(4);
        test.insert(5);
        test.removeMin();
        test.removeMin();
        int x = test.removeMin();
        assertEquals(3, x);

    }

    @Test
    public void findMin() {
        MinHeap<Integer> test1 = new MinHeap<Integer>();
        test1.insert(5);
        test1.insert(4);
        test1.insert(6);
        test1.insert(7);
        test1.insert(1);
        test1.insert(3);
        int x = test1.findMin();
        assertEquals(1, x);
        int xy = test1.removeMin();
        assertEquals(1, x);
        test1.removeMin();
        int xyz = test1.removeMin();
        assertEquals(4, xyz);


        MinHeap<Integer> test2 = new MinHeap<Integer>();
        test2.insert(5);
        test2.insert(4);
        // throw IllegalArgumentException
//        test2.insert(4);
    }

    @Test
    public void containsTest() {
        MinHeap<Integer> test1 = new MinHeap<Integer>();
        test1.insert(5);
        test1.insert(4);
        test1.insert(6);
        test1.insert(7);
        assertTrue(test1.contains(4));
        assertTrue(test1.contains(7));
        assertFalse(test1.contains(1));
        assertTrue(test1.contains(4));
    }


    @Test
    public void updateTest() {
        MinHeap<Integer> test1 = new MinHeap<Integer>();
        test1.insert(5);
        test1.insert(4);
        test1.insert(6);
        test1.insert(7);
        test1.update(7);

    }

}
