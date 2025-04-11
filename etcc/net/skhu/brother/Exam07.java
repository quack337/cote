package etcc.net.skhu.brother;
import java.util.Arrays;

public class Exam07 {

    public static String solution(String s) {
        char[] a = new char[10];
                int count = 0;
        for (char c : s.toCharArray())
            if (count > 0 && a[count - 1] == c)
                --count;
            else {
                if (count >= a.length)
                    Arrays.copyOf(a, a.length * 2);
                a[count++] = c;
            }
        return new String(a, 0, count);
    }

    public static void main(String[] args) {
        System.out.println(solution("browoanoommnaon"));
    }

}