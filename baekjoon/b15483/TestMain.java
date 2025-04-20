package baekjoon.b15483;
import java.io.IOException;

import org.junit.Test;

import baekjoon.test.TestUtils;

public class TestMain {

    @Test
    public void test1() throws IOException {
        String[][] A = {
                {"abc\r\nab\r\n", "1"},
                {"ca\r\nabc\r\n", "3"},
                {"abc\r\ncba\r\n", "2"},
                {"abcd\r\nbcde\r\n", "2"},
                {"abababababa\r\naaaaaaaaaaa\r\n", "5"},
                {"for\r\nwhileforif\r\n", "7"},
                {"whilewhile\r\nwhalewhale\r\n", "2"},
                {"aaabaaa\r\nacacaca\r\n", "3"},
                {"qwerty\r\ndvorak\r\n", "5"},
                {"asdf\r\nasdf\r\n", "0"}
        };
        for (String[] a : A) {
            System.err.println(a[0]);
            TestUtils.callMain(Main::main, a[0], a[1]);
        }
    }
}