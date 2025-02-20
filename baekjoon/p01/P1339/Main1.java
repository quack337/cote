package baekjoon.p01.P1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main1 {

    static char[] getAlphabets(char[][] words) {
        Set<Character> set = new HashSet<>();
        for (char[] word : words)
            for (char c : word)
                set.add(c);
        char[] alphabets = new char[set.size()];
        int index = 0;
        for (char c : set)
            alphabets[index++] = c;
        return alphabets;
    }

    static int sum(char[][] words, char[] alphabets, int[] numbers) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < alphabets.length; ++i)
            map.put(alphabets[i], numbers[i]);
        for (char[] word : words) {
            int temp = 0;
            for (char c : word)
                temp = temp * 10 + map.get(c);
            result += temp;
        }
        return result;
    }

    static int DFS(char[][] words, char[] alphabets, int[] numbers, boolean[] selected, int index) {
        if (index >= alphabets.length) return sum(words, alphabets, numbers);
        int max = 0;
        for (int i = 0; i <= 9; ++i) {
            if (selected[i]) continue;
            selected[i] = true;
            numbers[index] = i;
            int temp = DFS(words, alphabets, numbers, selected, index + 1);
            selected[i] = false;
            if (temp > max) max = temp;
        }
        return max;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        char[][] words = new char[N][];
        for (int i = 0; i < N; ++i)
            words[i] = reader.readLine().toCharArray();
        char[] alphabets = getAlphabets(words);
        System.out.println(DFS(words, alphabets, new int[alphabets.length], new boolean[10], 0));
    }
}
