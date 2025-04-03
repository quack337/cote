package baekjoon.p13.p13460;

import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

enum Direction { RIGHT, LEFT, UP, DOWN }

class Location implements Cloneable {
    int 행, 열;

    public Location(int 행, int 열) {
        this.행 = 행;
        this.열 = 열;
    }

    public void 이동하라(Direction 방향) {
        switch (방향) {
        case UP: --행; break;
        case DOWN: ++행; break;
        case LEFT: --열; break;
        case RIGHT: ++열; break;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Location == false) return false;
        Location p = (Location)obj;
        return this.행 == p.행 && this.열 == p.열;
    }

    public boolean notEquals(Object obj) {
        return !equals(obj);
    }

    @Override
    public Location clone() {
        return new Location(행, 열);
    }

    @Override
    public int hashCode() {
        return Objects.hash(행, 열);
    }
}

class Board implements Cloneable {
    static int 행수, 열수;      // 탐색 과정에서 변화하지 않는 값들은 static 변수로 구현
    static char[][] 게임판문자; // 탐색 과정에서 Board 객체를 복제할 때, static 변수들은 복제 안됨
    static Location 구멍위치;

    Location 파란공위치, 빨간공위치;   // 탐색 과정에서 변화하는 값들은 instance 변수로 구현
    int 이동횟수;

    public Board(int 행수, int 열수, char[][] 게임판문자) {
        Board.행수 = 행수;
        Board.열수 = 열수;
        Board.게임판문자 = 게임판문자;
        Board.구멍위치 = 위치찾기('O');
        this.이동횟수 = 0;
        this.파란공위치 = 위치찾기('B');
        this.빨간공위치 = 위치찾기('R');
        Board.게임판문자[this.파란공위치.행][this.파란공위치.열] = '.';
        Board.게임판문자[this.빨간공위치.행][this.빨간공위치.열] = '.';
    }

    @Override
    public Board clone() {
        try {
            Board 복제 = (Board)super.clone();
            복제.파란공위치 = this.파란공위치.clone(); // deep copy를 구현함
            복제.빨간공위치 = this.빨간공위치.clone();
            return 복제;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public boolean equals(Object obj) { // 이미 방문한 노드를 찾기 위해 필요함. 공의 위치만 비교함.
        if (obj instanceof Board == false) return false;
        Board board = (Board)obj;
        return Objects.equals(파란공위치, board.파란공위치) &&
               Objects.equals(빨간공위치, board.빨간공위치);
    }

    @Override
    public int hashCode() {             // 이미 방문한 노드를 찾기 위해 필요함. 공의 위치만 계산함
        return Objects.hash(파란공위치, 빨간공위치);
    }

    private static Location 위치찾기(char ch) {
        for (int 행 = 0; 행 < 행수; ++행)
            for (int 열 = 0; 열 < 열수; ++열)
                if (게임판문자[행][열] == ch)
                    return new Location(행, 열);
        return null;
    }

    private char get게임판문자(Location 위치) {
        if (위치.행 < 0 || 위치.행 >= 행수) return '#';
        if (위치.열 < 0 || 위치.열 >= 열수) return '#';
        if (구멍위치.equals(위치)) return 'O';
        if (파란공위치.equals(위치)) return 'B';
        if (빨간공위치.equals(위치)) return 'R';
        return 게임판문자[위치.행][위치.열];
    }

    private boolean 이동할칸이_빈칸인가(Location 현재위치, Direction 방향) {
        Location 다음위치 = 현재위치.clone();
        다음위치.이동하라(방향);
        return get게임판문자(다음위치) == '.' || get게임판문자(다음위치) == 'O';
    }

    public void 이동하라(Direction 방향) {
        ++이동횟수;
        while (true) {
            // 두 공 중 하나라도 이동할 수 있을 때까지 이동을 반복한다
            if (이동할칸이_빈칸인가(파란공위치, 방향) && 파란공위치.notEquals(구멍위치))
                파란공위치.이동하라(방향);
            else if (이동할칸이_빈칸인가(빨간공위치, 방향) && 빨간공위치.notEquals(구멍위치))
                빨간공위치.이동하라(방향);
            else return;  //  두 공 다 이동 못하면, 리턴한다
        }
    }
}

public class Main {

    static int BFS(Board board) {
        Location 구멍위치 = Board.구멍위치;
        Queue<Board> queue = new ArrayDeque<>();  // 방문할 노드 목록
        Set<Board> 방문한노드 = new HashSet<>();  // 방문한 노드 목록
        queue.add(board);                         // 시작 노드
        while (queue.size() > 0) {
            Board 노드 = queue.remove();          // 현재 노드
            방문한노드.add(노드);                 // 현재 노드 방문
            if (노드.파란공위치.equals(구멍위치)) continue; // 파란공이 구멍에 떨어지면 실패
            if (노드.이동횟수 > 10) return -1;              // 최대 이동 횟수 초과
            if (노드.빨간공위치.equals(구멍위치)) return 노드.이동횟수;  // 성공

            for (Direction 방향 : Direction.values()) {
                Board 자식노드 = 노드.clone();              // 부모 노드를 복제하여 자식 노드 생성
                자식노드.이동하라(방향);
                if (방문한노드.contains(자식노드) == false) // 이미 방문한 노드가 아니면,
                    queue.add(자식노드);                    // 방문할 노드 목록에 추가한다
            }
        }
        return -1;
    }

    static Board inputBoard(InputStream in) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            scanner.nextLine();
            char[][] a = new char[N][];
            for (int i = 0; i < N; ++i)
                a[i] = scanner.nextLine().toCharArray();
            return new Board(N, M, a);
        }
    }

    public static void main(String[] args) {
        Board board = inputBoard(System.in);
        System.out.println(BFS(board));
    }
}