package baekjoon.p02.p2842;

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
                if (i >= 4 && e.equals("c")) continue;
                System.err.println(i + e);
                String s1 = TestUtils.getTextFile(getClass(), "data/postar.in." + i + e);
                String s2 = TestUtils.getTextFile(getClass(), "data/postar.out." + i + e);
                TestUtils.callMain(Main::main, s1, s2.trim());
            }
    }
}