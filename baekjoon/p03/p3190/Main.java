package baekjoon.p03.p3190;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class Location { // 좌표
    int y, x;

    public Location(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Location == false) return false;
        Location p = (Location)obj;
        return p.y == y && p.x == x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}

class Board {
    int 게임판크기;
    Set<Location> 사과좌표 = new HashSet<>();

    public Board(int 크기) {
        this.게임판크기 = 크기;
    }

    public void 사과등록(int y, int x) {
        사과좌표.add(new Location(y, x));
    }

    public boolean 사과가있는가(Location 좌표) {
        return 사과좌표.contains(좌표);
    }

    public void 사과제거(Location 좌표) {
        사과좌표.remove(좌표);
    }

    public boolean 벽에충돌(Location 좌표) {
        return 좌표.y < 1 || 좌표.y > 게임판크기 || 좌표.x < 1 || 좌표.x > 게임판크기;
    }
}

class Snake {
    ArrayDeque<Location> 몸좌표목록; // 뱀을 구성하는 칸들의 목록
    int vx; // 수평 방향 이동 속도 (-1, 0, 1)
    int vy; // 수직 방향 이동 속도 (-1, 0, 1)

    public Snake() {
        vx = 1; vy = 0;                     // 오른쪽으로 이동
        몸좌표목록 = new ArrayDeque<>();
        몸좌표목록.add(new Location(1, 1)); // 최초 좌표
    }

    public Location get머리가전진할좌표() {
        Location 머리좌표 = 몸좌표목록.peekFirst();
        return new Location(머리좌표.y + vy, 머리좌표.x + vx);
    }

    public void 머리가_전진한다(Location 머리가전진할좌표) {
        몸좌표목록.addFirst(머리가전진할좌표);
    }

    public void 꼬리가_전진한다() {
        몸좌표목록.removeLast();
    }

    public boolean 몸에충돌(Location 좌표) {
        return 몸좌표목록.contains(좌표);
    }

    public void 회전하라(String 회전방향) {
        if (vy == -1) {                         // 위쪽으로 이동 중
            vy = 0;
            vx = 회전방향.equals("L") ? -1 : 1; // 왼쪽 : 오른쪽
        } else if (vy == 1) {                   // 아래쪽으로 이동 중
            vy = 0;
            vx = 회전방향.equals("L") ? 1 : -1; // 오른쪽 : 왼쪽
        } else if (vx == -1) {                  // 왼쪽으로 이동 중
            vx = 0;
            vy = 회전방향.equals("L") ? 1 : -1; // 아래쪽 : 위쪽
        } else if (vx == 1) {                   // 오른쪽으로 이동 중
            vx = 0;
            vy = 회전방향.equals("L") ? -1 : 1; // 위쪽 : 아래쪽
        }
    }
}

public class Main {

    static boolean 이동하라(Snake 뱀, Board 게임판) {
        Location 새좌표 = 뱀.get머리가전진할좌표();
        if (게임판.벽에충돌(새좌표)) return false;
        if (뱀.몸에충돌(새좌표)) return false;
        뱀.머리가_전진한다(새좌표);
        if (게임판.사과가있는가(새좌표))
            게임판.사과제거(새좌표);
        else
            뱀.꼬리가_전진한다();
        return true;
    }

    static int 플레이(Board 게임판, Map<Integer, String> 회전명령) {
        Snake 뱀 = new Snake();
        int 초 = 1;
        while (이동하라(뱀, 게임판)) {
            String 회전방향 = 회전명령.get(초);
            if (회전방향 != null) 뱀.회전하라(회전방향);
            ++초;
        }
        return 초;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            Board 게임판 = new Board(N);

            int 사과_수 = scanner.nextInt();
            for (int i = 0; i < 사과_수; ++i) {
                int y = scanner.nextInt();
                int x = scanner.nextInt();
                게임판.사과등록(y, x);
            }

            int 회전명령_수 = scanner.nextInt();
            Map<Integer, String> 회전명령 = new HashMap<>();
            for (int i = 0; i < 회전명령_수; ++i) {
                int 초 = scanner.nextInt();
                String 방향 = scanner.next();
                회전명령.put(초, 방향);
            }

            int 초 = 플레이(게임판, 회전명령);
            System.out.println(초);
        }
    }
}
