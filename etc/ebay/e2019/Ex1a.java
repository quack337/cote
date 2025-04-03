package ebay.e2019;

public class Ex1a {

    public static int solution1(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; ++i)
            for (int j = i + 1; j < prices.length; ++j) {
                int value = prices[j] - prices[i];
                if (value > max) max = value;
            }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(solution1(new int[] { 3, 2, 4, 8, 7 }));
        System.out.println(solution1(new int[] { 3, 4, 1, 5, 4 }));
    }
}