package net.skhu.nhn.e1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class QuizTest {

    // overlap
    @Test
    void testOverlaps1() {
        Circle c1 = new Circle(0, 10, 0, 5);
        Circle c2 = new Circle(0, 20, 0, 5);
        assertTrue(c1.overlaps(c2));
    }

    @Test
    void testOverlaps2() {
        Circle c1 = new Circle(0, 10, 0, 5);
        Circle c2 = new Circle(0, 20, 0, 6);
        assertTrue(c1.overlaps(c2));
    }

    @Test
    void testOverlaps3() {
        Circle c1 = new Circle(0, 10, 0, 5);
        Circle c2 = new Circle(0, 20, 0, 4);
        assertTrue(c1.overlaps(c2) == false);
    }

    // contains
    @Test
    void testOverlaps4() {
        Circle c1 = new Circle(0, 20, 0, 10);
        Circle c2 = new Circle(0, 20, 0, 10);
        assertTrue(c1.contains(c2) == false); // 경계선이 곂치면 false
    }

    @Test
    void testOverlaps6() {
        Circle c1 = new Circle(0, 20, 0, 10);
        Circle c2 = new Circle(0, 20, 0, 8);
        assertTrue(c1.contains(c2));
    }

    // test1
    @Test
    void testOverlaps7() {
        Circle c1 = new Circle(7, 30, 74, 20);
        Circle c2 = new Circle(10, 42, 77, 7);
        assertTrue(c1.contains(c2));
    }
}
