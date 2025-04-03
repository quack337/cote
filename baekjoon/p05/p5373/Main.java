package baekjoon.p05.p5373;

import java.util.Arrays;
import java.util.Scanner;

interface Filter {
    boolean eval(Box box);
}

class Box implements Comparable<Box> {
    int x, y, z;
    String color;

    public Box(int x, int y, int z, String color) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.color = color;
    }

    public void 회전(int[][] 회전) {
        int X = x * 회전[0][0] + y * 회전[1][0] + z * 회전[2][0];
        int Y = x * 회전[0][1] + y * 회전[1][1] + z * 회전[2][1];
        int Z = x * 회전[0][2] + y * 회전[1][2] + z * 회전[2][2];
        x = X; y = Y; z = Z;
    }

    @Override
    public int compareTo(Box box) {
        // z 내림차순, y 내림차순, x 오름차순
        return (box.z - z) * 100 + (box.y - y) * 10 + x - box.x;
    }
}

public class Main {
    // 회전 행렬
    static int[][] x축시계방향 = { {1, 0, 0}, {0, 0, -1}, {0, 1, 0} };
    static int[][] x축반시계방향 = { {1, 0, 0}, {0, 0, 1}, {0, -1, 0} };
    static int[][] y축시계방향 = { {0, 0, 1}, {0, 1, 0}, {-1, 0, 0} };
    static int[][] y축반시계방향 = { {0, 0, -1}, {0, 1, 0}, {1, 0, 0} };
    static int[][] z축시계방향 = { {0, -1, 0}, {1, 0, 0}, {0, 0, 1} };
    static int[][] z축반시계방향 = { {0, 1, 0}, {-1, 0, 0}, {0, 0, 1} };

    static Box[] create박스목록() {
        return new Box[] {
                    new Box(-1, 1, 2, "w"), new Box(0, 1, 2, "w"), new Box(1, 1, 2, "w"),
                    new Box(-1, 0, 2, "w"), new Box(0, 0, 2, "w"), new Box(1, 0, 2, "w"),
                    new Box(-1, -1, 2, "w"), new Box(0, -1, 2, "w"), new Box(1, -1, 2, "w"),
                    new Box(-1, -2, 1, "r"), new Box(0, -2, 1, "r"), new Box(1, -2, 1, "r"),
                    new Box(-1, -2, 0, "r"), new Box(0, -2, 0, "r"), new Box(1, -2, 0, "r"),
                    new Box(-1, -2, -1, "r"), new Box(0, -2, -1, "r"), new Box(1, -2, -1, "r"),
                    new Box(-2, 1, 1, "g"), new Box(-2, 0, 1, "g"), new Box(-2, -1, 1, "g"),
                    new Box(-2, 1, 0, "g"), new Box(-2, 0, 0, "g"), new Box(-2, -1, 0, "g"),
                    new Box(-2, 1, -1, "g"), new Box(-2, 0, -1, "g"), new Box(-2, -1, -1, "g"),
                    new Box(2, -1, 1, "b"), new Box(2, 0, 1, "b"), new Box(2, 1, 1, "b"),
                    new Box(2, -1, 0, "b"), new Box(2, 0, 0, "b"), new Box(2, 1, 0, "b"),
                    new Box(2, -1, -1, "b"), new Box(2, 0, -1, "b"), new Box(2, 1, -1, "b"),
                    new Box(1, 2, 1, "o"), new Box(0, 2, 1, "o"), new Box(-1, 2, 1, "o"),
                    new Box(1, 2, 0, "o"), new Box(0, 2, 0, "o"), new Box(-1, 2, 0, "o"),
                    new Box(1, 2, -1, "o"), new Box(0, 2, -1, "o"), new Box(-1, 2, -1, "o"),
                    new Box(-1, -1, -2, "y"), new Box(0, -1, -2, "y"), new Box(1, -1, -2, "y"),
                    new Box(-1, 0, -2, "y"), new Box(0, 0, -2, "y"), new Box(1, 0, -2, "y"),
                    new Box(-1, 1, -2, "y"), new Box(0, 1, -2, "y"), new Box(1, 1, -2, "y")
                };
    }

    static void 회전(Box[] 박스목록, int[][] 회전, Filter 선택기준) {
        for (Box box : 박스목록) {
            if (선택기준.eval(box)) box.회전(회전);
        }
    }

    static void 윗면출력(Box[] 박스목록) {
        Arrays.sort(박스목록);
        for (int i = 0; i < 9; ++i) {
            System.out.print(박스목록[i].color);
            if (i % 3 == 2) System.out.println();
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            for (int i = 0; i < count; ++i) {
                int 회전수 = scanner.nextInt();
                Box[] 박스목록 = create박스목록();
                for (int j = 0; j < 회전수; ++j) {
                    int[][] 회전 = null;  Filter 선택기준 = null;
                    String 명령 = scanner.next();
                    char c = 명령.charAt(1);
                    switch (명령.charAt(0)) {
                    case 'U': 회전 = c=='+' ? z축시계방향 : z축반시계방향; 선택기준 = (box -> box.z > 0); break;
                    case 'D': 회전 = c=='+' ? z축반시계방향 : z축시계방향; 선택기준 = (box -> box.z < 0); break;
                    case 'B': 회전 = c=='+' ? y축시계방향 : y축반시계방향; 선택기준 = (box -> box.y > 0); break;
                    case 'F': 회전 = c=='+' ? y축반시계방향 : y축시계방향; 선택기준 = (box -> box.y < 0); break;
                    case 'R': 회전 = c=='+' ? x축시계방향 : x축반시계방향; 선택기준 = (box -> box.x > 0); break;
                    case 'L': 회전 = c=='+' ? x축반시계방향 : x축시계방향; 선택기준 = (box -> box.x < 0); break;
                    }
                    회전(박스목록, 회전, 선택기준);
                }
                윗면출력(박스목록);
            }
        }
    }
}