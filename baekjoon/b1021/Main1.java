package baekjoon.b1021;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;

public class Main1 {

    static final int 왼쪽 = 0, 오른쪽 = 1;

    @SuppressWarnings("serial")
    static class RotatingQueue extends ArrayDeque<Integer> {

        public RotatingQueue(int size) {
            super(size);
        }

        public void 회전(int 방향) {
            if (방향 == 왼쪽) {
                int value = super.removeFirst();
                super.addLast(value);
            } else {
                int value = super.removeLast();
                super.addFirst(value);
            }
        }

        public int 꺼내기() {
            return super.removeFirst();
        }

        private int findIndex(int value) {
            Iterator<Integer> it = super.iterator();
            int index = 0;
            while (it.hasNext()) {
                if (it.next() == value) return index;
                ++index;
            }
            return -1;
        }

        public int 가까운쪽(int value) {
            int index = findIndex(value);
            return (index <= super.size() / 2) ? 왼쪽 : 오른쪽;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            RotatingQueue queue = new RotatingQueue(N);
            for (int i = 0; i < N; ++i)
                queue.addLast(i + 1);
            int 회전수 = 0;
            for (int i = 0; i < M; ++i) {
                int value = scanner.nextInt();
                int 방향 = queue.가까운쪽(value);
                while (queue.peek() != value) {
                    queue.회전(방향);
                    ++회전수;
                }
                queue.꺼내기();
            }
            System.out.println(회전수);
        }
    }
}