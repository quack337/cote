package codility.maxcounters;

import java.util.Arrays;

public class Solution2 {

    public static int[] solution(int N, int[] A) {
        int[] counter = new int[N];
        int max = 0, min = 0;

        for (int value : A) {
            int index = value - 1;
            if (index < counter.length) {
                if (counter[index] < min)
                    counter[index] = min;
                ++counter[index];
                if (max < counter[index])
                    max = counter[index];
            }
            else
                min = max;
        }
        for (int i = 0; i < counter.length; ++i)
            if (counter[i] < min)
                counter[i] = min;
        return counter;
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        int[] result = solution(5, A);
        System.out.println(Arrays.toString(result));

    }

}
