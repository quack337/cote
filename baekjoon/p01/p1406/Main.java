package baekjoon.p01.p1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) // 링크드 리스트에 문자 하나씩 넣는다.
            list.add(c);
        int N = Integer.parseInt(reader.readLine());
        ListIterator<Character> iterator = list.listIterator(list.size());
        for (int i = 0; i < N; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String cmd = tokenizer.nextToken();
            switch (cmd) {
            case "L": if (iterator.hasPrevious()) iterator.previous(); break; // 완쪽 이동
            case "D": if (iterator.hasNext()) iterator.next(); break; // 오른쪽 이동
            case "B":
                if (iterator.hasPrevious()) {
                    iterator.previous(); // 먼저 왼쪽으로 이동 후
                    iterator.remove();   // 오른쪽 항목 삭제
                }
                break;
            case "P":
                iterator.add(tokenizer.nextToken().charAt(0)); // 오른쪽에 문자 추가
                break;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (char c : list)
            builder.append(c);
        System.out.println(builder.toString());
    }
}
