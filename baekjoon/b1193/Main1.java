package baekjoon.b1193;
public class Main1 {

    static int sum(int n) {
        return n * (n + 1) / 2;
    }

    static int depth(int x) {
        int sum = 0;
        for (int n = 1; n <= 1000000; ++n) {
            sum += n;
            if (sum >= x) return n;
        }
        return -1;
    }

    static int depth2(int x) {
        return (int)Math.round(Math.sqrt(2 * x));
    }

    public static void main(String[] args) {
        for (int x = 1; x <= 10000000; ++x) {
            /*
            int 열 = x - sum(depth - 1);
            int 행 = depth - 열 + 1;
            System.out.printf("%d = %d/%d\n", x, (depth % 2 == 1) ? 행 : 열, (depth % 2 == 1) ? 열 : 행);
            */
            if (depth(x) != depth2(x)) System.out.println("error");
        }
        System.out.println("ok");
    }
}