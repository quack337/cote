package programmers.p42891;

import java.util.Arrays;

public class Test3 {

    static void test(int[] a) {
        var s1 = new Test1.Solution();
        var s2 = new Test2.Solution();
        for (int i = 1; i <= 100; ++i) {
            int r1 = s1.solution(Arrays.copyOf(a, a.length), i);
            int r2 = s2.solution(Arrays.copyOf(a, a.length), i);
            if (r1 != r2) {
                System.out.printf("%s %d: %d %d\n",
                        Arrays.toString(a), i, r1, r2);
                return;
            }
        }
    }

    public static void main(String[] args) {
        test(new int[] { 1, 2 });
        test(new int[] { 3, 1, 2 });
        test(new int[] { 3, 1, 4, 2 });
        System.out.println("done");
    }

}