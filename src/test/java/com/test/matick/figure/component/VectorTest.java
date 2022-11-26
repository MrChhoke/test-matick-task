package com.test.matick.figure.component;

import com.test.matick.model.figure.component.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    public void testIsParallel() {
        Vector a = new Vector(1, 2);
        Vector b = new Vector(4, 8);
        Vector c = new Vector(5, 9);

        assertTrue(a.isParallel(b));
        assertTrue(b.isParallel(a));

        assertFalse(a.isParallel(c));
        assertFalse(c.isParallel(b));
    }

}