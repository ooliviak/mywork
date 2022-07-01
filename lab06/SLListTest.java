import org.junit.Test;
import static org.junit.Assert.*;

public class SLListTest {

    @Test
    public void testSLListAdd() {
        SLList test1 = SLList.of(1, 3, 5);
        SLList test2 = new SLList();

        test1.add(1, 2);
        test1.add(3, 4);
        assertEquals(5, test1.size());
        assertEquals(3, test1.get(2));
        assertEquals(4, test1.get(3));

        test2.add(1, 1);
        assertEquals(1, test2.get(0));
        assertEquals(1, test2.size());

        test2.add(10, 10);
        assertEquals(10, test2.get(1));
        test1.add(0, 0);
        assertEquals(SLList.of(0, 1, 2, 3, 4, 5), test1);
    }

    @Test
    public void testReverse() {

//        general case  (size >= 2)
        SLList test1 = SLList.of(1, 3, 5, 6);
        test1.reverse();
        assertEquals(6, test1.get(0));
        assertEquals(3, test1.get(2));


//        base case 1   (size = 1)
        SLList test3 = new SLList(2);
        test3.reverse();
        assertEquals(2, test3.get(0));


//        base case 2   (size = 0)
        SLList test4 = new SLList();
        test4.reverse();
        assertEquals(null, test4.get(0));



    }
}
