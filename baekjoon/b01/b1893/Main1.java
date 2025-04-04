package baekjoon.b01.b1893;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main1 {
    static int[] kmpPattern(char[] pattern) {
        int[] table = new int[pattern.length];
        int J = 0;
        for (int i = 1; i < pattern.length; ++i) {
            while (J > 0 && pattern[i] != pattern[J])
                J = table[J - 1];
            if (pattern[i] == pattern[J]) {
                ++J;
                table[i] = J;
            }
        }
        return table;
    }

    static int kmp(char[] T, char[] P) {
        int[] table = kmpPattern(P);
        int J = 0, count = 0;
        for (int i = 0; i < T.length; ++i) {
            while (J > 0 && T[i] != P[J])
                J = table[J - 1];
            if (T[i] == P[J]) {
                ++J;
                if (J == P.length) {
                    ++count;
                    J = table[J - 1];
                }
            }
        }
        return count;
    }

    static HashMap<Character, Character> create시프트맵(char[] A) {
        var map = new HashMap<Character, Character>();
        for (int i = 0; i < A.length - 1; ++i)
            map.put(A[i], A[i + 1]);
        map.put(A[A.length-1], A[0]);
        return map;
    }

    static void 한칸시프트(char[] A, HashMap<Character, Character> 시프트맵) {
        for (int i = 0; i < A.length; ++i)
            A[i] = 시프트맵.get(A[i]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        var builder = new StringBuilder();
        for (int t = 0; t < T; ++t) {
            char[] A = reader.readLine().toCharArray();
            char[] W = reader.readLine().toCharArray();
            char[] S = reader.readLine().toCharArray();
            HashMap<Character, Character> 시프트맵 = create시프트맵(A);
            ArrayList<Integer> 찾은시프트목록 = new ArrayList<>();
            for (int shift = 0; shift < A.length; ++shift) {
                int count = kmp(S, W);
                if (count == 1) 찾은시프트목록.add(shift);
                한칸시프트(W, 시프트맵);
            }
            switch (찾은시프트목록.size()) {
            case 0: builder.append("no solution\n"); break;
            case 1: builder.append("unique: " + 찾은시프트목록.get(0) + "\n"); break;
            default:
                builder.append("ambiguous: ");
                for (int shift : 찾은시프트목록)
                    builder.append(shift + " ");
                builder.append("\n");
                break;
            }
        }
        System.out.println(builder.toString());
    }

}