package baekjoon.b13460;
import java.io.IOException;

import org.junit.Test;

import baekjoon.test.TestUtils;

public class TestMain {

    @Test
    public void test1() throws IOException {
        String s =
                "5 5\r\n" +
                "#####\r\n" +
                "#..B#\r\n" +
                "#.#.#\r\n" +
                "#RO.#\r\n" +
                "#####\r\n";
        TestUtils.callMain(Main::main, s, "1");
    }

    @Test
    public void test2() throws IOException {
        String s =
                "7 7\r\n" +
                "#######\r\n" +
                "#...RB#\r\n" +
                "#.#####\r\n" +
                "#.....#\r\n" +
                "#####.#\r\n" +
                "#O....#\r\n" +
                "#######";
        TestUtils.callMain(Main::main, s, "5");
    }

    @Test
    public void test3() throws IOException {
        String s =
                "7 7\r\n" +
                "#######\r\n" +
                "#..R#B#\r\n" +
                "#.#####\r\n" +
                "#.....#\r\n" +
                "#####.#\r\n" +
                "#O....#\r\n" +
                "#######";
        TestUtils.callMain(Main::main, s, "5");
    }

    @Test
    public void test4() throws IOException {
        String s =
                "10 10\r\n" +
                "##########\r\n" +
                "#R#...##B#\r\n" +
                "#...#.##.#\r\n" +
                "#####.##.#\r\n" +
                "#......#.#\r\n" +
                "#.######.#\r\n" +
                "#.#....#.#\r\n" +
                "#.#.#.#..#\r\n" +
                "#...#.O#.#\r\n" +
                "##########\r\n";
        TestUtils.callMain(Main::main, s, "-1");
    }

    @Test
    public void test5() throws IOException {
        String s =
                "3 7\r\n" +
                "#######\r\n" +
                "#R.O.B#\r\n" +
                "#######\r\n";
        TestUtils.callMain(Main::main, s, "1");
    }

    @Test
    public void test6() throws IOException {
        String s =
                "10 10\r\n" +
                "##########\r\n" +
                "#R#...##B#\r\n" +
                "#...#.##.#\r\n" +
                "#####.##.#\r\n" +
                "#......#.#\r\n" +
                "#.######.#\r\n" +
                "#.#....#.#\r\n" +
                "#.#.##...#\r\n" +
                "#O..#....#\r\n" +
                "##########\r\n";
        TestUtils.callMain(Main::main, s, "7");
    }

    @Test
    public void test7() throws IOException {
        String s =
                "3 10\r\n" +
                "##########\r\n" +
                "#.O....RB#\r\n" +
                "##########\r\n";
        TestUtils.callMain(Main::main, s, "-1");
    }
}