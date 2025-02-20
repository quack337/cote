package baekjoon.p05.p5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

    static String toString(Iterator<Integer> iterator) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        while (iterator.hasNext())
            builder.append(iterator.next()).append(",");
        if (builder.length() > 1) builder.deleteCharAt(builder.length() - 1); // 마지막 , 삭제
        return builder.append("]").toString();
    }

    static void solution(ArrayDeque<Integer> queue, char[] 명령) {
        boolean 뒤집힘 = false;
        for (char c : 명령) {
            if (c == 'R') 뒤집힘 = !뒤집힘;
            else if (c == 'D') {
                if (queue.isEmpty()) {
                    System.out.println("error");
                    return;
                }
                if (뒤집힘) queue.removeLast();
                else queue.removeFirst();
            }
        }
        Iterator<Integer> iterator = (뒤집힘 ? queue.descendingIterator() : queue.iterator());
        String s = toString(iterator);
        System.out.println(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int T = Integer.parseInt(tokenizer.nextToken());
        for (int t = 0; t < T; ++t) {
            char[] 명령 = reader.readLine().toCharArray();
            int n = Integer.parseInt(reader.readLine());
            ArrayDeque<Integer> queue = new ArrayDeque<>(n);
            tokenizer = new StringTokenizer(reader.readLine(), " ,[]");
            for (int i = 0; i < n; ++i) {
                int value = Integer.parseInt(tokenizer.nextToken());
                queue.addLast(value);
            }
            solution(queue, 명령);
        }
    }
}
