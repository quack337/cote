package baekjoon.p01.P1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static void add(char[] word, int[] alphabetValues) { // 알파벳 값 계산
        int value = 1;
        for (int i = word.length-1; i >= 0; --i) {
            char ch = word[i];
            alphabetValues[ch - 'A'] += value;
            value *= 10;
        }
    }

    static int sum(int[] alphabetValues) { // 합계 계산
        int value = 9, result = 0;
        for (int i = alphabetValues.length - 1; i >= 0; --i)
            result += alphabetValues[i] * value--;
        return result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] alphabetValues = new int['Z'-'A'+1];
        for (int i = 0; i < N; ++i) {
            char[] word = reader.readLine().toCharArray();
            add(word, alphabetValues);
        }
        Arrays.sort(alphabetValues);
        System.out.println(sum(alphabetValues));
    }
}