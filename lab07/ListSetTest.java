import org.junit.Test;
import static org.junit.Assert.*;

public class ListSetTest {

    @Test
    public void testBasics() {
        ListSet aSet = new ListSet();
        assertEquals(0, aSet.size());

        for (int i = -50; i < 50; i += 2) {
            aSet.add(i);
            assertTrue(aSet.contains(i));
        }
        assertEquals(50, aSet.size());
        for (int i = -50; i < 50; i += 2) {
            aSet.remove(i);
            assertFalse(aSet.contains(i));
        }
        assertTrue(aSet.isEmpty());
        assertEquals(0, aSet.size());


        ListSet cSet = new ListSet();
        cSet.add(3);
        cSet.add(3);
        cSet.add(3);
        assertEquals(1, cSet.size());

        ListSet dSet = new ListSet();
        dSet.add(4);
        dSet.add(3);
        dSet.remove(3);
        dSet.remove(3);
        assertEquals(1, dSet.size());


        ListSet abSet = new ListSet();
        abSet.add(3);
        abSet.add(4);
        abSet.add(5);
        abSet.add(10);
        abSet.add(4);
        abSet.remove(10);
        int[] x;
        x = abSet.toIntArray();
        assertEquals(3, x.length);

        ListSet abcSet = new ListSet();
        int[] y;
        y = abcSet.toIntArray();
        assertEquals(0, y.length);

    }

}
