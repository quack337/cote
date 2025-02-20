package baekjoon.p02.p2346;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        var scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        var deque = new ArrayDeque<int[]>();
        for (int i = 0; i < N; ++i) {
            int value = scanner.nextInt();
            int no = i + 1;
            deque.addLast(new int[] { no, value });
        }
        while (true) {
            int[] a = deque.remove();
            int no = a[0], value = a[1];
            if (value > 0) --value;
            System.out.print(no + (deque.size() > 0 ? " " : "\n"));
            if (deque.size() == 0) break;
            for (int i = 0; i < Math.abs(value); ++i)
                if (value > 0)
                    deque.addLast(deque.removeFirst());
                else
                    deque.addFirst(deque.removeLast());
        }
    }

}
