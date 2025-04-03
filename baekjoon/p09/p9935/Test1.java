package baekjoon.p09.p9935;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

import baekjoon.test.TestUtils;

public class Test1 {

    @Test
    public void test() throws IOException, URISyntaxException {
        String[] a = { "a", "b", "c" };
        for (int i = 1; i <= 10; ++i)
            for (String e : a) {
                System.err.println(i + e);
                String s1 = TestUtils.getTextFile(getClass(), "data/eksplozija.in." + i + e);
                String s2 = TestUtils.getTextFile(getClass(), "data/eksplozija.out." + i + e);
                TestUtils.callMain(Main::main, s1, s2.trim());
            }
    }
}