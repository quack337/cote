package etcc.codility.minavgtwoslice;
import java.util.Arrays;
import java.util.Random;

public class Solution2 {

    static double average(int[] A, int start, int end) {
        double sum = 0;
        for (int i = start; i <= end; ++i)
            sum += A[i];
        return sum / (end - start + 1);
    }

    public static int solution2(int[] A) {
        double minAvg = (A[0] + A[1]) / 2.0;
        int minStart = 0;
        int minEnd = 1;
        double temp;

        for (int i = 2; i < A.length; ++i) {
            temp = average(A, minStart, i);
            if (temp <= minAvg) {
                minEnd = i;
                minAvg = temp;
                for (int j = minStart + 1; j < minEnd; ++j) {
                    temp = average(A, j, minEnd);
                    if (temp < minAvg) {
                        minAvg = temp;
                        minStart = j;
                    }
                }
            }
            System.out.printf("     %d: %d %d %.2f\n", i, minStart, minEnd, minAvg);
        }
        return minStart;
    }

    public static int solution1(int[] A) {
        double minAvg = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < A.length; ++i)
            for (int j = i + 1; j < A.length; ++j) {
                double avg = average(A, i, j);
                if (avg < minAvg) {
                    minAvg = avg;
                    start = i;
                }
            }
        return start;
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        int[] A1 = {4, 2, 2, 5, 1, 5, 8};
        int[] A2 = { 8, 4, 4, 5, 1, 2, 3, 4 };
        //System.out.println(solution2(A1));
        //System.out.println(solution2(A2));

        int value1, value2;
        int[] A;

        /*
        A = new int[] {1, -3, 4, -4}
        value1 = solution1(A);
        value2 = solution2(A);
        if (value1 != value2) {
            System.out.printf("%d %d %s\n", value1, value2, Arrays.toString(A));
        }
        */

        Random random = new Random();
        for (int i = 0; i < 100; ++i) {
            int length = random.nextInt(3) + 2;
            A = new int[length];
            for (int j = 0; j < length; ++j)
                A[j] = random.nextInt(10) - 5;
            value1 = solution1(A);
            value2 = solution2(A);
            if (value1 != value2)
                System.out.printf("%d %d %s\n", value1, value2, Arrays.toString(A));
        }
    }

}