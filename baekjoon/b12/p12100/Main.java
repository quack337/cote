package baekjoon.b12.p12100;

import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;


class Board implements Cloneable {
    int[][] a;
    int moveCount;
    static int maxValue = 0;

    public Board(int[][] a) {
        this.a = a;
        moveCount = 0;
    }

    @Override
    public Board clone() {
        int[][] b = new int[a.length][];
        for (int r = 0; r < a.length; ++r)
            b[r] = Arrays.copyOf(a[r], a[r].length);
        Board board = new Board(b);
        board.moveCount = moveCount;
        return board;
    }

    private void moveLeft(int r, int c) {
        if (a[r][c] == 0) return;
        int c1 = c - 1;
        while (c1 > 0 && a[r][c1] == 0)
            --c1;
        if (a[r][c1] == 0) a[r][c1] = a[r][c];
        else if (a[r][c1] == a[r][c]) a[r][c1] *= -2; // 숫자 두개 결합
        else if (c1 + 1 == c)  return;
        else a[r][c1 + 1] = a[r][c];
        a[r][c] = 0;
    }

    public void moveLeft() {
        ++moveCount;
        for (int c = 1; c < a[0].length; ++c)
            for (int r = 0; r < a.length; ++r)
                moveLeft(r, c);
        findMaxValue(a); // 숫자들을 이동한 후, 최대 숫자를 찾는다
    }

    private void moveUp(int r, int c) {
        if (a[r][c] == 0) return;
        int r1 = r - 1;
        while (r1 > 0 && a[r1][c] == 0)
            --r1;
        if (a[r1][c] == 0) a[r1][c] = a[r][c];
        else if (a[r1][c] == a[r][c]) a[r1][c] *= -2; // 숫자 두개 결합
        else if (r1 + 1 == r)  return;
        else a[r1 + 1][c] = a[r][c];
        a[r][c] = 0;
    }

    public void moveUp() {
        ++moveCount;
        for (int r = 1; r < a.length; ++r)
            for (int c = 0; c < a[0].length; ++c)
                moveUp(r, c);
        findMaxValue(a); // 숫자들을 이동한 후, 최대 숫자를 찾는다
    }

    private void moveRight(int r, int c) {
        if (a[r][c] == 0) return;
        int c1 = c + 1;
        while (c1 < a[0].length - 1 && a[r][c1] == 0)
            ++c1;
        if (a[r][c1] == 0) a[r][c1] = a[r][c];
        else if (a[r][c1] == a[r][c]) a[r][c1] *= -2;
        else if (c1 - 1 == c)  return;
        else a[r][c1 - 1] = a[r][c];
        a[r][c] = 0;
    }

    public  void moveRight() {
        ++moveCount;
        for (int c = a[0].length - 2; c >= 0; --c)
            for (int r = 0; r < a.length; ++r)
                moveRight(r, c);
        findMaxValue(a);
    }

    private void moveDown(int r, int c) {
        if (a[r][c] == 0) return;
        int r1 = r + 1;
        while (r1 < a.length - 1 && a[r1][c] == 0)
            ++r1;
        if (a[r1][c] == 0) a[r1][c] = a[r][c];
        else if (a[r1][c] == a[r][c]) a[r1][c] *= -2;
        else if (r1 - 1 == r)  return;
        else a[r1 - 1][c] = a[r][c];
        a[r][c] = 0;
    }

    public void moveDown() {
        ++moveCount;
        for (int r = a.length - 2; r >= 0; --r)
            for (int c = 0; c < a[0].length; ++c)
                moveDown(r, c);
        findMaxValue(a);
    }

    private void findMaxValue(int[][] a) {
        for (int r = 0; r < a.length; ++r)
            for (int c = 0; c < a[0].length; ++c) {
                if (a[r][c] < 0) a[r][c] *= -1;
                if (a[r][c] > maxValue) maxValue = a[r][c];
            }
    }
}

public class Main {

    static Board inputBoard(InputStream in) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            scanner.nextLine();
            int[][] a = new int[N][];
            for (int r = 0; r < N; ++r) {
                a[r] = new int[N];
                for (int c = 0; c < N; ++c)
                    a[r][c] = scanner.nextInt();
            }
            return new Board(a);
        }
    }

    static int BFS(Board board) {
        Queue<Board> queue = new ArrayDeque<>(); // 방문할 노드 목록
        queue.add(board);                        // 시작 노드
        while (queue.size() > 0) {
            Board node = queue.remove();         // 현재 노드
            if (node.moveCount == 5) continue;   // 최대 이동 횟수

            Board newNode = node.clone();        // 부모 노드를 복제하여 자식 노드 생성
            newNode.moveRight();                 // 오른쪽으로 이동
            queue.add(newNode);                  // 방문할 노드 목록에 추가

            newNode = node.clone();
            newNode.moveLeft();
            queue.add(newNode);

            newNode = node.clone();
            newNode.moveDown();
            queue.add(newNode);

            newNode = node.clone();
            newNode.moveUp();
            queue.add(newNode);
        }
        return Board.maxValue;
    }

    public static void main(String[] args) {
        Board board = inputBoard(System.in);
        System.out.println(BFS(board));
    }
}