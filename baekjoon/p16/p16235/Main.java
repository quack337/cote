package baekjoon.p16.p16235;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Tree {
        int 나이;
        boolean 사망 = false;

        public Tree(int 나이) {
            this.나이 = 나이;
        }
    }

    static class Cell {
        int 양분 = 5;
        List<Tree> 나무목록 = new ArrayList<>();

        public void 나무심기(Tree 나무) { // 나이 순서 기준으로 끼워 넣는다
            for (int i = 0; i < 나무목록.size(); ++i)
                if (나무목록.get(i).나이 >= 나무.나이) {
                    나무목록.add(i, 나무);
                    return;
                }
            나무목록.add(나무);
        }
    }

    static void 봄(Cell[][] 땅) {
        for (int 행 = 0; 행 < 땅.length; ++행)
            for (int 열 = 0; 열 < 땅.length; ++열)
                for (Tree 나무 : 땅[행][열].나무목록) {
                    if (땅[행][열].양분 >= 나무.나이) {
                        땅[행][열].양분 -= 나무.나이;
                        나무.나이++;
                    } else
                        나무.사망 = true;
                }
    }

    static void 여름(Cell[][] 땅) {
        for (int 행 = 0; 행 < 땅.length; ++행)
            for (int 열 = 0; 열 < 땅.length; ++열) {
                Iterator<Tree> it = 땅[행][열].나무목록.iterator();
                while (it.hasNext()) {
                    Tree 나무 = it.next();
                    if (나무.사망) {
                        땅[행][열].양분 += (나무.나이 / 2);
                        it.remove();
                    }
                }
            }
    }

    static void 가을(Cell[][] 땅) {
        for (int 행 = 0; 행 < 땅.length; ++행)
            for (int 열 = 0; 열 < 땅.length; ++열)
                for (Tree 나무 : 땅[행][열].나무목록)
                    if (나무.나이 % 5 == 0) 번식(땅, 행, 열);
    }

    static void 번식(Cell[][] 땅, int 기준행, int 기준열) {
        for (int r = -1; r <= 1; ++r)
            for (int c = -1; c <= 1; ++c) {
                if (r == 0 && c == 0) continue;
                int 행 = 기준행 + r;
                int 열 = 기준열 + c;
                if (행 < 0 || 행 >= 땅.length) continue;
                if (열 < 0 || 열 >= 땅.length) continue;
                땅[행][열].나무심기(new Tree(1));
            }
    }

    static void 겨울(Cell[][] 땅, int[][] 양분추가) {
        for (int 행 = 0; 행 < 땅.length; ++행)
            for (int 열 = 0; 열 < 땅.length; ++열)
                땅[행][열].양분 += 양분추가[행][열];
    }

    static int 나무수(Cell[][] 땅) {
        int 수 = 0;
        for (int 행 = 0; 행 < 땅.length; ++행)
            for (int 열 = 0; 열 < 땅.length; ++열)
                수 += 땅[행][열].나무목록.size();
        return 수;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int 최초나무_수 = scanner.nextInt();
            int 종료_년 = scanner.nextInt();

            int[][] 양분추가 = new int[N][N];
            for (int 행 = 0; 행 < N; ++행)
                for (int 열 = 0; 열 < N; ++열)
                    양분추가[행][열] = scanner.nextInt();

            Cell[][] 땅 = new Cell[N][N];
            for (int 행 = 0; 행 < N; ++행)
                for (int 열 = 0; 열 < N; ++열)
                    땅[행][열] = new Cell();

            for (int i = 0; i < 최초나무_수; ++i) {
                int 행 = scanner.nextInt() - 1;
                int 열 = scanner.nextInt() - 1;
                int 나이 = scanner.nextInt();
                땅[행][열].나무심기(new Tree(나이));
            }

            for (int 년 = 0; 년 < 종료_년; ++년) {
                봄(땅);
                여름(땅);
                가을(땅);
                겨울(땅, 양분추가);
            }
            System.out.println(나무수(땅));
        }
    }
}
