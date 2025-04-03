package baekjoon.p06.p6549;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import baekjoon.test.TestUtils;

public class Test2 {

    static final String FILE_NAME = "d:/temp/t.txt";

    void testData() throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME)));
        Random random = new Random();
        for (int N = 10; N <= 100; ++N) {
            out.printf("%d ", N);
            for (int i = 0; i < N; ++i)
                out.printf("%d ", random.nextInt(10));
            out.println();
        }
        out.println(0);
        out.close();
    }

    @Test
    public void test() throws Exception {
        for (int i = 0; i < 100; ++i) {
            testData();
            String s1 = TestUtils.callMain(getClass(), Main2::main, FILE_NAME);
            String s2 = TestUtils.callMain(getClass(), Main1::main, FILE_NAME);
            Assert.assertEquals(s1, s2);
        }
    }
}