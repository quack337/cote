package baekjoon.p09.p9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main1 {
    static String S, bomb;
    static char lastChar;
    static boolean[] bombChar;
    static ArrayList<Character> stack = new ArrayList<>();

    static boolean stackContainsBomb() {
        int i1 = bomb.length() - 1, i2 = stack.size() - 1;
        while (i1 >= 0) {
            if (bomb.charAt(i1) != stack.get(i2)) return false;
            --i1; --i2;
        }
        return true;
    }

    static void removeBombFromStack() {
        while (stack.size() >= bomb.length())  {
            if (stackContainsBomb())
                for (int i = 0; i < bomb.length(); ++i)
                    stack.remove(stack.size() - 1);
        }
    }

    static String solution() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            if (bombChar[c]) {
                stack.add(c);
                if (c == lastChar) removeBombFromStack();
            } else {
                if (stack.size() > 0) {
                    for (char ch : stack)
                        builder.append(ch);
                    stack.clear();
                }
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        S = reader.readLine();
        bomb = reader.readLine();
        lastChar = bomb.charAt(bomb.length() - 1);
        bombChar = new boolean[256];
        for (char c : bomb.toCharArray())
            bombChar[c] = true;
        String s = solution();
        System.out.println(s.length() > 0 ? s : "FRULA");
    }
}