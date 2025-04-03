package codility.maxcounters;

import java.util.Arrays;

public class Solution1 {

    public static int[] solution(int N, int[] A) {
        int[] counter = new int[N];

        for (int value : A) {
            int index = value - 1;
            if (index < counter.length)
                ++counter[index];
            else {
                int max = 0;
                for (int i = 0; i < counter.length; ++i)
                    if (max < counter[i])
                        max = counter[i];
                for (int i = 0; i < counter.length; ++i)
                    counter[i] = max;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        int[] result = solution(5, A);
        System.out.println(Arrays.toString(result));

    }

}
