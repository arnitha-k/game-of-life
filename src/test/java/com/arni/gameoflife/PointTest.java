package com.arni.gameoflife;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PointTest {

    @Test
    public void testEqualsAndHashCode() {
        Point p1 = new Point(11, 10);
        Point p2 = new Point(11, 10);
        Point p3 = new Point(12, 10);

        assertEquals(p1, p2, "Points with same coordinates should be equal");
        assertEquals(p1.hashCode(), p2.hashCode(), "Hashcodes should be same for points with same coordinates");
        assertNotEquals(p1, p3, "Points with different coordinates should not be equal");
    }

    @Test
    public void testToString() {
        Point p = new Point(11, 10);

        assertEquals("(11, 10)", p.toString(), "toString should be of format (x,y)");
    }

    @Test
    public void testNotEqualsAndHashCode() {
        Point p = new Point(11, 10);

        assertNotEquals(null, p, "Point should not be equal null");
        assertNotEquals("string", p, "Point should not be equal to different type");

    }
}
