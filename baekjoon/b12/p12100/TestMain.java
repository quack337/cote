package baekjoon.b12.p12100;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestMain {

    @Test
    public void testUp1() {
        int[][] a1 = {{2, 4, 16, 8}, {8, 4, 0, 0}, {16, 8, 2, 0}, {2, 8, 2, 0}};
        int[][] a2 = {{2, 8, 16, 8}, {8, 16, 4, 0}, {16, 0, 0, 0}, {2, 0, 0, 0}};
        Board b = new Board(a1);
        b.moveUp();
        Assert.assertTrue(Arrays.deepEquals(a1, a2));
    }

    @Test
    public void testUp2() {
        int[][] a1 = {{2, 4, 8, 2}, {2, 4, 0, 0}, {2, 0, 0, 0}, {2, 0, 2, 0}};
        int[][] a2 = {{4, 8, 8, 2}, {4, 0, 2, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        Board b = new Board(a1);
        b.moveUp();
        Assert.assertTrue(Arrays.deepEquals(a1, a2));
    }

    @Test
    public void testUp3() {
        int[][] a1 = {{2, 0, 0, 0}, {2, 2, 0, 0}, {2, 0, 0, 0}, {0, 0, 0, 0}};
        int[][] a2 = {{4, 2, 0, 0}, {2, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        Board b = new Board(a1);
        b.moveUp();
        Assert.assertTrue(Arrays.deepEquals(a1, a2));
    }

    @Test
    public void testLeft0() {
        int[][] a1 = {{2, 0, 2, 8}, {0, 0, 2, 2}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        int[][] a2 = {{4, 8, 0, 0}, {4, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        Board b = new Board(a1);
        b.moveLeft();
        Assert.assertTrue(Arrays.deepEquals(a1, a2));
    }

    @Test
    public void testLeft1() {
        int[][] a1 = {{8, 0, 0, 0}, {16, 0, 2, 2}, {4, 4, 8, 8}, {2, 8, 16, 2}};
        int[][] a2 = {{8, 0, 0, 0}, {16, 4, 0, 0}, {8, 16, 0, 0}, {2, 8, 16, 2}};
        Board b = new Board(a1);
        b.moveLeft();
        Assert.assertTrue(Arrays.deepEquals(a1, a2));
    }

    @Test
    public void testLeft2() {
        int[][] a1 = {{2, 0, 0, 0}, {8, 0, 0, 2}, {4, 4, 0, 0}, {2, 2, 2, 2}};
        int[][] a2 = {{2, 0, 0, 0}, {8, 2, 0, 0}, {8, 0, 0, 0}, {4, 4, 0, 0}};
        Board b = new Board(a1);
        b.moveLeft();
        Assert.assertTrue(Arrays.deepEquals(a1, a2));
    }

    @Test
    public void testRight() {
        int[][] a1 = {{0, 0, 0, 8}, {2, 2, 0, 16}, {8, 8, 4, 4}, {2, 16, 8, 2}};
        int[][] a2 = {{0, 0, 0, 8}, {0, 0, 4, 16}, {0, 0, 16, 8}, {2, 16, 8, 2}};
        Board b = new Board(a1);
        b.moveRight();
        // System.out.println(Arrays.deepToString(a1));
        Assert.assertTrue(Arrays.deepEquals(a1, a2));
    }

    @Test
    public void testRight2() {
        int[][] a1 = {{0, 0, 0, 2}, {2, 0, 0, 8}, {0, 0, 4, 4}, {2, 2, 2, 2}};
        int[][] a2 = {{0, 0, 0, 2}, {0, 0, 2, 8}, {0, 0, 0, 8}, {0, 0, 4, 4}};
        Board b = new Board(a1);
        b.moveRight();
        Assert.assertTrue(Arrays.deepEquals(a1, a2));
    }

    @Test
    public void testDown() {
        int[][] a1 = {{2, 8, 2, 0}, {16, 8, 2, 0}, {8, 4, 0, 0}, {2, 4, 16, 8}};
        int[][] a2 = {{2, 0, 0, 0}, {16, 0, 0, 0}, {8, 16, 4, 0}, {2, 8, 16, 8}};
        Board b = new Board(a1);
        b.moveDown();
        Assert.assertTrue(Arrays.deepEquals(a1, a2));
    }

    @Test
    public void testDown2() {
        int[][] a1 = {{2, 0, 2, 0}, {2, 0, 0, 0}, {2, 4, 0, 0}, {2, 4, 8, 2}};
        int[][] a2 = {{0, 0, 0, 0}, {0, 0, 0, 0}, {4, 0, 2, 0}, {4, 8, 8, 2}};
        Board b = new Board(a1);
        b.moveDown();
        Assert.assertTrue(Arrays.deepEquals(a1, a2));
    }

}