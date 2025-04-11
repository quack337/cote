package etcc.net.skhu.boostcamp2019;
public class Example2a {
    static final int MAX = 13;

    static int value(int[] a) {
        int[] counts = new int[MAX + 1];
        for (int i : a)
            ++counts[i];
        int max = 0;
        for (int i = 0; i < counts.length; ++i) {
            int value = i + Math.min(counts[i], 4) * 100;
            if (value > max) max = value;
        }
        return max < 200 ? 0 : max;
    }

    static int solution(int[] arr1, int[] arr2) {
        int r = value(arr1) - value(arr2);
        if (r == 0) return 0;
        return r > 0 ? 1 : 2;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 5, 7, 2, 9, 13, 10}, {2, 3, 9, 10, 4, 8, 11},
                {1, 4, 1, 3, 5, 6, 10}, {9, 2, 3, 1, 3, 4, 10},
                {1, 1, 9, 4, 1, 3, 11}, {2, 3, 3, 13, 12, 9, 9},
                {1, 4, 9, 4, 1, 10, 13}, {11, 13, 9, 3, 1, 9, 1},
                {1, 4, 4, 4, 1, 10, 4}, {11, 13, 11, 3, 11, 9, 1},
                {1, 2, 2, 3, 2, 2, 2}, {4, 5, 4, 5, 4, 5, 4}
            };
        for (int i = 0; i < a.length; i += 2)
            System.out.println(solution(a[i], a[i + 1]));
    }
}