package net.skhu.st11;

// 2020-09-29

import java.util.Arrays;

public class Exam2 {

    // O(N^2 * M)
    public static int[] solution1(String[] S) {
        int N = S.length, M = S[0].length();
        for (int i = 0; i < N; ++i)
            for (int j = i + 1; j < N; ++j)
                for (int k = 0; k < M; ++k)
                    if (S[i].charAt(k) == S[j].charAt(k))
                        return new int[] { i, j, k };
        return new int[] {};
    }

    // O(N * M)
    public static int[] solution2(String[] S) {
        int N = S.length, M = S[0].length(), 알파벳수 = 'z' - 'a' + 1;
        int[][] A = new int[M][알파벳수]; // 이 위치에 이 알파벳이 등장한 문자열은 누구인지 기록
                                      // 문자열의 인덱스+1 값을 기록
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < M; ++j) {
                char ch = S[i].charAt(j);
                if (A[j][ch - 'a'] > 0) // 이 위치에 이 알파벳이 등장한 문자열이 있다
                    // 그 문자열의 인덱스, 현재 문자열의 인덱스, 문자 위치 리턴
                    return new int[] { A[j][ch - 'a'] - 1, i, j };
                else
                    A[j][ch - 'a'] = i + 1; // 이 위치에 이 알파벳이 등장했다고 기록함
                                            // 현재 문자열의 인덱스+1 값을 기록함
            }
        return new int[] {};
    }

    public static void main(String[] args) {
        String[] s1 = new String[] { "abc", "bca", "dbe" };
        String[] s2 = new String[] { "zzzz", "ferz", "fgtd" };
        String[] s3 = new String[] { "gr", "sd", "rg" };

        System.out.println(Arrays.toString(solution1(s1)));
        System.out.println(Arrays.toString(solution1(s2)));
        System.out.println(Arrays.toString(solution1(s3)));

        System.out.println(Arrays.toString(solution2(s1)));
        System.out.println(Arrays.toString(solution2(s2)));
        System.out.println(Arrays.toString(solution2(s3)));

    }

}