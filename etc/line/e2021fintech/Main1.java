package net.skhu.line.e2021fintech;

public class Main1 {

    static int solution(int[] a) {
        final int N = a.length;

        int[] left = new int[N];
        int prev = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < N; ++i) {
            if (a[i] > prev) ++count;
            else count = 0;
            left[i] = count;
            prev = a[i];
        }

        int[] right = new int[N];
        count = 0;
        prev = Integer.MAX_VALUE;
        for (int i = N-1; i >=0; --i) {
            if (a[i] > prev) ++count;
            else count = 0;
            right[i] = count;
            prev = a[i];
        }

        count = 0;
        for (int i = 0; i < N; ++i)
            count += left[i] * right[i];
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {0,1,2,5,3,7}));
        System.out.println(solution(new int[] {1,2,3,2,1}));
        System.out.println(solution(new int[] {1,2,3,2,1,4,3,2,2,1}));
        System.out.println(solution(new int[] {1,2,1,2,1}));
    }
}
