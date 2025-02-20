package baekjoon.p10.p10799;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static int PS(String s) {
        int result = 0;
        int laser = 0;
        char prev = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            switch (c) {
            case '(':
                stack.push(laser);
                laser = 0;
                break;
            case ')':
                if (prev == '(') ++laser;
                else result += (laser + 1);
                laser += stack.pop();
                break;
            }
            prev = c;
        }
        return stack.isEmpty() ? result : 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        System.out.println(PS(s));
    }
}
