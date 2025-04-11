package etcc.ebay.e2019;
import java.util.Arrays;
import java.util.Random;

public class Ex1b {

    public static int solution1(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; ++i)
            for (int j = i + 1; j < prices.length; ++j) {
                int value = prices[j] - prices[i];
                if (value > max) max = value;
            }
        return max;
    }

    public static int solution2(int[] prices) {
        if (prices.length <= 1) return 0;
        int minIndex = 0, max = 0;
        for (int i = 1; i < prices.length; ++i) {
            int value = prices[i] - prices[minIndex];
            if (value > max)
                max = value;
            else if (prices[i] < prices[minIndex])
                minIndex = i;
        }
        return max;
    }

    static Random random = new Random();

    public static int[] createArray() {
        int length = random.nextInt(20);
        int[] a = new int[length];
        for (int i = 0; i < a.length; ++i)
            a[i] = random.nextInt(20) + 1;
        return a;
    }

    public static void main(String[] args) {
        System.out.println(solution1(new int[] { 3, 2, 4, 8, 7 }));
        System.out.println(solution2(new int[] { 3, 2, 4, 8, 7 }));
        System.out.println(solution1(new int[] { 3, 4, 1, 5, 4 }));
        System.out.println(solution2(new int[] { 3, 4, 1, 5, 4 }));

        for (int i = 0; i < 10000; ++i) {
            int[] a = createArray();
            int r1 = solution1(a);
            int r2 = solution2(a);
            if (r1 != r2)
                System.out.printf("%s %d %d\n", Arrays.toString(a), r1, r2);
        }
    }
}