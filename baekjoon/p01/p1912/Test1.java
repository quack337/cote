package baekjoon.p01.p1912;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import baekjoon.test.TestUtils;

public class Test1 {

    static final String FILE_NAME = "d:/temp/t.txt";

    void testData() throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME)));
        Random random = new Random();
        int N = 1000;
        out.printf("%d\n", N);
        for (int i = 0; i < N; ++i)
            out.printf("%d ", random.nextInt(2000) - 10000);
        out.println();
        out.close();
    }

    @Test
    public void test() throws Exception {
        for (int i = 0; i < 100; ++i) {
            testData();
            String s1 = TestUtils.callMain(getClass(), Main::main, FILE_NAME);
            String s2 = TestUtils.callMain(getClass(), Main2::main, FILE_NAME);
            Assert.assertEquals(s1, s2);
        }
    }
}
