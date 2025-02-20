package baekjoon.p16.p16236;

import java.io.IOException;

import org.junit.Test;

import baekjoon.test.MainMethod;
import baekjoon.test.TestUtils;

public class TestMain {

    void testMain(MainMethod mainMethod, String inputData, String outputData) throws IOException {
        TestUtils.callMain(mainMethod, inputData, outputData);
    }

    @Test
    public void test1() throws IOException {
        String s =
                "3\r\n" +
                "0 0 0\r\n" +
                "0 0 0\r\n" +
                "0 9 0";
        testMain(Main::main, s, "0");
    }

    @Test
    public void test2() throws IOException {
        String s =
                "3\r\n" +
                "0 0 1\r\n" +
                "0 0 0\r\n" +
                "0 9 0";
        testMain(Main::main, s, "3");
    }

    @Test
    public void test3() throws IOException {
        String s =
                "4\r\n" +
                "4 3 2 1\r\n" +
                "0 0 0 0\r\n" +
                "0 0 9 0\r\n" +
                "1 2 3 4";
        testMain(Main::main, s, "14");
    }

    @Test
    public void test4() throws IOException {
        String s =
                "6\r\n" +
                "5 4 3 2 3 4\r\n" +
                "4 3 2 3 4 5\r\n" +
                "3 2 9 5 6 6\r\n" +
                "2 1 2 3 4 5\r\n" +
                "3 2 1 6 5 4\r\n" +
                "6 6 6 6 6 6";
        testMain(Main::main, s, "60");
    }

    @Test
    public void test5() throws IOException {
        String s =
                "6\r\n" +
                "6 0 6 0 6 1\r\n" +
                "0 0 0 0 0 2\r\n" +
                "2 3 4 5 6 6\r\n" +
                "0 0 0 0 0 2\r\n" +
                "0 2 0 0 0 0\r\n" +
                "3 9 3 0 0 1";
        testMain(Main::main, s, "48");
    }

    @Test
    public void test6() throws IOException {
        String s =
                "6\r\n" +
                "1 1 1 1 1 1\r\n" +
                "2 2 6 2 2 3\r\n" +
                "2 2 5 2 2 3\r\n" +
                "2 2 2 4 6 3\r\n" +
                "0 0 0 0 0 6\r\n" +
                "0 0 0 0 0 9";
        testMain(Main::main, s, "39");
    }
}
