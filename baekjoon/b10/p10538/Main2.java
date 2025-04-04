package baekjoon.b10.p10538;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    static int W_SIZE, A_SIZE = 2; // 아호 코라식 알고리즘
    static int[][] GO; // 아호 코라식 알고리즘
    static int[] FAIL, OUT; // 아호 코라식 알고리즘
    static int[][] found;     // 발견한 행 번호 적기
    static int[] rowNumbers;  // 행번호 수열
    static int PH, PW, MH, MW, answer = 0;

    static void buildMatcher(char[][] words) { // 아호 코라식 알고리즘
        GO = new int[W_SIZE][A_SIZE];
        FAIL = new int[W_SIZE];
        OUT = new int[W_SIZE];
        Arrays.fill(OUT, -1);
        for (var g : GO) Arrays.fill(g, -1);
        int stateCount = 0;
        for (int i = 0; i < words.length; ++i) {
            int state = 0;
            for (char ch : words[i]) {
                int ci = (ch == 'o' ? 0 : 1);
                if (GO[state][ci] == -1) GO[state][ci] = ++stateCount;
                state = GO[state][ci];
            }
            if (OUT[state] == -1) OUT[state] = i;
            rowNumbers[i] = OUT[state]; // 행번호 수열
        }
        for (int ci = 0; ci < A_SIZE; ++ci)
            if (GO[0][ci] == -1) GO[0][ci] = 0;

        var queue = new ArrayDeque<Integer>();
        queue.add(0);
        FAIL[0] = 0;
        while (queue.size() > 0) {
            int state = queue.remove();
            for (int ci = 0; ci < A_SIZE; ++ci)
                if (GO[state][ci] > 0) {
                    int nextState = GO[state][ci];
                    if (state > 0) {
                        int failState = FAIL[state];
                        while (GO[failState][ci] == -1)
                            failState = FAIL[failState];
                        FAIL[nextState] = GO[failState][ci];
                    }
                    queue.add(nextState);
                }
        }
    }

    static int nextState(int state, char ch) { // 아호 코라식 알고리즘
        int ci = (ch == 'o' ? 0 : 1);
        while (GO[state][ci] == -1)
            state = FAIL[state];
        return GO[state][ci];
    }

    static void search(char[] S, int row) {
        int state = 0;
        for (int col = 0; col < S.length; ++col) {
            char ch = S[col];
            state = nextState(state, ch);
            if (OUT[state] != -1) found[row][col] = OUT[state]; // 행 발견
        }
    }

    static int[] kmpPattern(int[] s) {
        int[] p = new int[s.length];
        int J = 0;
        for (int i = 1; i < s.length; ++i) {
            while (J > 0 && s[i] != s[J])
                J = p[J - 1];
            if (s[i] == s[J])
                p[i] = ++J;
        }
        return p;
    }

    static void kmp() {
        int[] p = kmpPattern(rowNumbers);
        for (int col = PW - 1; col < MW; ++col) {
            int J = 0;
            for (int i = 0; i < MH; ++i) {
                while (J > 0 && found[i][col] != rowNumbers[J])
                    J = p[J - 1];
                if (found[i][col] == rowNumbers[J])
                    if (++J == rowNumbers.length) {
                        ++answer; // 행번호 수열 발견
                        J = p[J - 1];
                    }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        PH = Integer.parseInt(tokenizer.nextToken());
        PW = Integer.parseInt(tokenizer.nextToken());
        MH = Integer.parseInt(tokenizer.nextToken());
        MW = Integer.parseInt(tokenizer.nextToken());
        W_SIZE = Math.max(10, PH * PW);
        found = new int[MH][MW];
        for (int[] a : found) Arrays.fill(a, -1);
        rowNumbers = new int[PH];
        char[][] P = new char[PH][];
        for (int i = 0; i < PH; ++i)
            P[i] = reader.readLine().toCharArray();
        buildMatcher(P);
        for (int i = 0; i < MH; ++i) {
            char[] S = reader.readLine().toCharArray();
            search(S, i);
        }
        kmp();
        System.out.println(answer);
    }
}