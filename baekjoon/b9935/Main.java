package baekjoon.b9935;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static String S, bomb;

    static String solution() {
        StringBuilder builder = new StringBuilder();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int matchCount = 0;
        for (char c : S.toCharArray()) {
            if (c == bomb.charAt(matchCount)) {
                ++matchCount;
                if (matchCount == bomb.length())
                    matchCount = deque.size() > 0 ? deque.removeLast() : 0;
            } else {
                if (c == bomb.charAt(0)) {
                    deque.addLast(matchCount);
                    matchCount = 1;
                } else {
                    append(builder, deque, matchCount);
                    matchCount = 0;
                    builder.append(c);
                }
            }
        }
        append(builder, deque, matchCount);
        return builder.toString();
    }

    static void append(StringBuilder builder, ArrayDeque<Integer> deque, int matchCount) {
        while (deque.size() > 0)
            builder.append(bomb.substring(0, deque.removeFirst()));
        builder.append(bomb.substring(0, matchCount));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        S = reader.readLine();
        bomb = reader.readLine();
        String s = solution();
        System.out.println(s.length() > 0 ? s : "FRULA");
    }
}