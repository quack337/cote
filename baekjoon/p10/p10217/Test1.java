package baekjoon.p10.p10217;

import org.junit.Assert;
import org.junit.Test;

import baekjoon.test.TestUtils;

public class Test1 {

    @Test
    public void test1() throws Exception {
        test(1);
    }

    @Test
    public void test2() throws Exception {
        test(2);
    }

    @Test
    public void test3() throws Exception {
        test(3);
    }

    @Test
    public void test4() throws Exception {
        test(4);
    }

    @Test
    public void test5() throws Exception {
        test(5);
    }

    public void test(int i) throws Exception {
        String name = "data" + i;
        System.err.println(name);
        String s1 = TestUtils.callMain(getClass(), Main::main, name + ".in");
        String s2 = TestUtils.getTextFile(getClass(), name + ".out");
        s1 = s1.replaceAll("[\r\n ]+", " ").trim();
        s2 = s2.replaceAll("[\r\n ]+", " ").trim();
        Assert.assertEquals(s1, s2);
    }
}
