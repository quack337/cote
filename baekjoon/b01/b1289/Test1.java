package baekjoon.b01.b1289;

public class Test1 {

    static int solution1(int[] a) {
        int total = 0;
        for (int i = 0; i < a.length - 1; ++i)
            for (int j = i + 1; j < a.length; ++j)
                total += a[i] * a[j];
        return total;
    }

    static int solution2(int[] a) {
        int total = 0, sum = 0;
        for (int i = 0; i < a.length; ++i) {
            int r = a[i];
            total += r * sum;
            sum += r;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 2, 3, 4, 5 };
        System.out.println(solution1(a));
        System.out.println(solution2(a));
    }
}