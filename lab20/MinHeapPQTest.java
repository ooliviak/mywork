import org.junit.Test;
import static org.junit.Assert.*;

public class MinHeapPQTest {

    @Test
    public void test1() {
        MinHeapPQ<String> test = new MinHeapPQ<String>();
        test.insert("a", 1);
        test.insert("b", 2);
        test.insert("c", 3);
        test.insert("d", 4);
        test.insert("e", 5);
        assertEquals("a", test.peek());
        assertEquals("a", test.peek());
    }

    @Test
    public void poll() {
        MinHeapPQ<String> test1 = new MinHeapPQ<String>();
        test1.insert("e", 5);
        test1.insert("d", 4);
        test1.insert("f", 6);
        test1.insert("g", 7);
        test1.insert("a", 1);
        test1.insert("c", 3);
        assertEquals("a", test1.peek());
        assertEquals("a", test1.poll());
        test1.poll();
        assertEquals("d", test1.poll());


        MinHeapPQ<String> test2 = new MinHeapPQ<String>();
        test2.insert("e", 5);
        test2.insert("d", 4);
        // throw IllegalArgumentException
//        test2.insert("d", 4);
    }

    @Test
    public void changePriority() {
        MinHeapPQ<String> test1 = new MinHeapPQ<String>();
        test1.insert("e", 5);
        test1.insert("d", 4);
        test1.insert("f", 6);
        test1.insert("g", 7);
        test1.insert("b", 2);
        test1.changePriority("b", 5);
        test1.changePriority("e", 2);
    }
}
