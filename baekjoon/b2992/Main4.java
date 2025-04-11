package baekjoon.b2992;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main4 {

    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    static void 완전탐색(int[] digits, boolean[] selected, int selectCount, int result, int X) {
        if (selectCount == selected.length) {
            if (result > X) queue.add(result);
            return;
        }
        for (int i = 0; i < selected.length; ++i)
            if (selected[i] == false) {
                selected[i] = true;
                완전탐색(digits, selected, selectCount + 1, result * 10 + digits[i], X);
                selected[i] = false;
            }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        String s = String.valueOf(X);
        int N = s.length();
        int[] digits = new int[N];
        for (int i = 0; i < N; ++i)
            digits[i] = s.charAt(i) - '0';
        완전탐색(digits, new boolean[N], 0, 0, X);
        System.out.println(queue.size() > 0 ? queue.peek() : 0);
        scanner.close();
    }
}