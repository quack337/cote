package baekjoon.p02.p2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main4 {
    static class Tower {
        int no, height;
        public Tower(int no, int height) {
            this.no = no;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        ArrayDeque<Tower> stack = new ArrayDeque<>(); // 왼쪽 탑 목록
        for (int i = 0; i < N; ++i) {
            int height = Integer.parseInt(tokenizer.nextToken());
            int no = 0; // 신호를 수신할 탑 번호
            while (stack.size() > 0) {
                if (stack.peek().height >= height) { // 신호를 수신할 탑 발견
                    no = stack.peek().no;
                    break;
                }
                stack.pop(); // 현재 탑보다 작거나 같은 탑들은 목록에서 제거
            }
            System.out.print(no); // 수신 탑 번호 출력
            System.out.print(" ");
            stack.push(new Tower(i + 1, height));   // 현재 탑을 목록에 추가
        }
    }
}
