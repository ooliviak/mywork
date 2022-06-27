import org.junit.Test;

import static org.junit.Assert.*;

public class MeasurementTest {
    @Test
    public void test1() {
        // TODO: stub for first test
        Measurement m1 = new Measurement(1, 6);
        Measurement m2 = new Measurement(1, 8);
        m1.plus(m2);
//        3ft 2 in
        assertEquals(2, m1.getInches());
        m1.minus(m2);
//        1ft 6 in
        assertEquals(6, m1.getInches());
        Measurement m3 = new Measurement(0,7 );
        m3.multiple(3);
        assertEquals(9, m3.getInches());

    }
    // TODO: Add additional JUnit tests for Measurement.java here.
    @Test
    public void plus() {
        Measurement m1 = new Measurement(1, 6);
        Measurement m2 = new Measurement(1, 8);
        m1.plus(m2);
//        3ft 2 in
        assertEquals(2, m1.getInches());
        m1.plus(m2);
        //        4ft 10 in
        assertEquals(10, m1.getInches());

    }
    @Test
    public void minus() {
        Measurement m1 = new Measurement(3, 6);
        Measurement m2 = new Measurement(1, 7);
        m1.minus(m2);
//        1ft 11in
        assertEquals(11, m1.getInches());
        assertEquals(1, m1.getFeet());
        m1.minus(m2);
//        0ft 4in
        assertEquals(4, m1.getInches());

    }
    @Test
    public void multiple() {
        Measurement m1 = new Measurement(1, 6);
        m1.multiple(3);
//        4ft 6 in
        assertEquals(6, m1.getInches());
        assertEquals(4, m1.getFeet());
        m1.multiple(3);
//      13ft 6in
        assertEquals(6, m1.getInches());
        assertEquals(13, m1.getFeet());

    }

    @Test
    public void testToString() {
        Measurement m1 = new Measurement(1, 6);
        System.out.println(m1.toString());
        assertEquals("1\'6\"", m1.toString());
    }

}