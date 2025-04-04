package baekjoon.b10.p10538;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main1 {
    static int W_SIZE;
    static int A_SIZE = 2;
    static int[][] GO;
    static int[] FAIL;
    static ArrayList<Integer>[] OUT;
    static int PH, PW, MH, MW, answer = 0;
    static HashSet<Long> match = new HashSet<>();

    static int chToIndex(char ch) {
        return ch == 'o' ? 0 : 1;
    }

    static void buildMatcher(char[][] words) { // 아호 코라식 알고리즘 구현
        GO = new int[W_SIZE][A_SIZE];
        FAIL = new int[W_SIZE];
        OUT = new ArrayList[W_SIZE];
        for (var g : GO)
            Arrays.fill(g, -1);
        int stateCount = 0;
        for (int i = 0; i < words.length; ++i) {
            int state = 0;
            for (char ch : words[i]) {
                int ci = chToIndex(ch);
                if (GO[state][ci] == -1) GO[state][ci] = ++stateCount;
                state = GO[state][ci];
            }
            if (OUT[state] == null) OUT[state] = new ArrayList<>();
            OUT[state].add(i);
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
                        if (OUT[FAIL[nextState]] != null) {
                            if (OUT[nextState] == null) OUT[nextState] = new ArrayList<>();
                            OUT[nextState].addAll(OUT[FAIL[nextState]]);
                        }
                    }
                    queue.add(nextState);
                }
        }
    }

    static int nextState(int state, char ch) { // 아호 코라식 알고리즘 구현
        int ci = chToIndex(ch);
        while (GO[state][ci] == -1)
            state = FAIL[state];
        return GO[state][ci];
    }

    static long key(int row, int col, int no) {
        return (row * 1_000_000L + col) * 10_000L + no;
    }

    static void search(char[] S, int row) {
        int state = 0;
        for (int col = 0; col < S.length; ++col) {
            char ch = S[col];
            state = nextState(state, ch);
            if (OUT[state] != null)
                for (int no : OUT[state]) {
                    if (no == 0 || match.contains(key(row - 1, col, no - 1))) {
                        match.remove(key(row - 1, col, no - 1));
                        if (no == PH - 1) ++answer;
                        else match.add(key(row, col, no));
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
        W_SIZE = PH * PW;
        char[][] P = new char[PH][];
        for (int i = 0; i < PH; ++i)
            P[i] = reader.readLine().toCharArray();
        buildMatcher(P);
        for (int i = 0; i < MH; ++i) {
            char[] S = reader.readLine().toCharArray();
            search(S, i);
        }
        System.out.println(answer);
    }
}