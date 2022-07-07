import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class AListTest {

    @Test
    public void testFor() {
        AList<Integer> a = new AList<>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        int count = 0;
        for (Integer i : a) {
            count += i;
        }
        assertEquals(6, count);


        AList friends = AList.of(5, 23, 42);
        Iterator<Integer> seer = friends.iterator();
        while (seer.hasNext()) {
            int x = seer.next();
            System.out.println(x);
        }
        Iterator<Integer> seer1 = friends.iterator();
        while (seer1.hasNext()) {
            int x = seer1.next();
            System.out.println(x);
        }
    }



}
