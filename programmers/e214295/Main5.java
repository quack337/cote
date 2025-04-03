package programmers.e214295;

import java.util.Arrays;

public class Main5 {

    static class Solution {
        static final int 외부 = 0, 걸침 = 1, 내부 = 2;
        static final int X = 0, Y = 1, D = 2, FLAG = 3;

        static class Node {
            int x1, y1, x2, y2;
            long value;
            Node[] children;

            Node (int x1, int y1, int x2, int y2) {
                this.x1 = x1; this.y1 = y1;  this.x2 = x2; this.y2 = y2;
                value = area();
            }

            long area() { return (x2 - x1 + 1L) * (y2 - y1 + 1L); }

            void createChildren() throws Exception {
                if (x1 < x2 && y1 < y2) {
                    children = new Node[4];
                    int xm = (x1 + x2) / 2;
                    int ym = (y1 + y2) / 2;
                    children[0] = new Node(x1,     y1, xm, ym);
                    children[1] = new Node(xm+1,   y1, x2, ym);
                    children[2] = new Node(x1,   ym+1, xm, y2);
                    children[3] = new Node(xm+1, ym+1, x2, y2);
                } else if (x1 < x2) {
                    children = new Node[2];
                    int xm = (x1 + x2) / 2;
                    children[0] = new Node(x1,   y1, xm, y2);
                    children[1] = new Node(xm+1, y1, x2, y2);
                } else if (y1 < y2) {
                    children = new Node[2];
                    int ym = (y1 + y2) / 2;
                    children[0] = new Node(x1, y1,   x2, ym);
                    children[1] = new Node(x1, ym+1, x2, y2);
                } else {
                    System.out.printf("X: %d %d %d %d: %d\n", x1, y1, x2, y2, value);
                    throw new Exception("child");
                }

            }

            void updateValue() {
                if (children == null) return;
                value = 0;
                for (Node child : children)
                    value += child.value;
            }
        }

        static class Point {
            int x, y;
            Point(int x, int y) { this.x = x; this.y = y; }
            int alpa() { return x + y; }
            int beta() { return x - y; }
        }

        static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) { // CounterClockWise
            long value = (long)(x2 - x1) * (y3 - y1) - (long)(x3 - x1) * (y2 - y1);
            return value < 0 ? -1 : value > 0 ? 1 : 0; // -1 : 시계 방향, 1 : 반시계 방향, 0 : 일직선
        }

        static boolean 선분교차(Point p1, Point p2, Point q1, Point q2) {
            int x1 = p1.x, x2 = p2.x, x3 = q1.x, x4 = q2.x;
            int y1 = p1.y, y2 = p2.y, y3 = q1.y, y4 = q2.y;
            if (x1 == x2 && y1 == y2) return false;
            if (x3 == x4 && y3 == y4) return false;
            return 선분교차(x1, y1, x2, y2, x3, y3, x4, y4);
        }

        static boolean 선분교차(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
            int d123 = ccw(x1, y1, x2, y2, x3, y3), d124 = ccw(x1, y1, x2, y2, x4, y4),
                d341 = ccw(x3, y3, x4, y4, x1, y1), d342 = ccw(x3, y3, x4, y4, x2, y2); // direction
            int v12 = d123 * d124, v34 = d341 * d342;
            if (v12 == 0 && v34 == 0) {
                if (d123 == 0 && d124 == 0 && d341 == 0 && d342 == 0) { // 네 점이 일직선
                    int pA, pB, pC, pD;
                    if (x1 == x2) { pA = Math.min(y1, y2); pB = Math.max(y1, y2); }
                    else { pA = Math.min(x1, x2); pB = Math.max(x1, x2); }
                    if (x3 == x4) { pC = Math.min(y3, y4); pD = Math.max(y3, y4); }
                    else { pC = Math.min(x3, x4); pD = Math.max(x3, x4); }
                    return pC <= pB && pA <= pD;
                }
                return true; // 세 점이 일직선인데 그 중 두 점이 겹침
            }
            return v12 <= 0 && v34 <= 0; // 세 점이 일직선인데 두 점 사이에 있거나 / 두 선분이 서로 교차
        }

        static boolean 내부인가(Point p, int[] 마름모) {
            return Math.abs(p.x - 마름모[X]) + Math.abs(p.y - 마름모[Y]) <= 마름모[D];
        }

        static boolean 내부인가(Point p, Node node) {
            return node.x1 <= p.x && p.x <= node.x2 && node.y1 <= p.y && p.y <= node.y2;
        }

        static boolean 모두내부인가(Point[] points, int[] 마름모) {
            for (Point p : points)
                if (내부인가(p, 마름모) == false) return false;
            return true;
        }

        static boolean 모두내부인가(Point[] points, Node node) {
            for (Point p : points)
                if (내부인가(p, node) == false) return false;
            return true;
        }

        static int 내부인가(Node node, int[] 마름모) {
            Point[] 사각형꼭지점 = new Point[] {
               new Point(node.x1, node.y1),
               new Point(node.x2, node.y1),
               new Point(node.x2, node.y2),
               new Point(node.x1, node.y2) };
            Point[] 마름모꼭지점 = new Point[] {
               new Point(마름모[X] - 마름모[D], 마름모[Y]),
               new Point(마름모[X], 마름모[Y] - 마름모[D]),
               new Point(마름모[X] + 마름모[D], 마름모[Y]),
               new Point(마름모[X], 마름모[Y] + 마름모[D]) };
            if (모두내부인가(사각형꼭지점, 마름모)) return 내부;
            if (모두내부인가(마름모꼭지점, node)) return 걸침;
            for (int i = 0; i < 4; ++i)
                for (int j = 0; j < 4; ++j) {
                    if (선분교차(사각형꼭지점[i], 사각형꼭지점[(i + 1) % 4], 마름모꼭지점[j], 마름모꼭지점[(j + 1) % 4]))
                        return 걸침;
                }
            return 외부;
        }

        static void DFS(Node node, int[] test) throws Exception {
            if (node.value == 0) return;

            int 내외부 = 내부인가(node, test);

            if (node.x1 == 71 && node.y1 == 82 && node.x2 == 71 && node.y2 == 82) {
                System.out.printf("A: %d %d %d %d: %d\n", node.x1, node.y1, node.x2, node.y2, node.value);
                System.out.println(Arrays.toString(test));
                System.out.println(내외부);
            }


            if (node.x1 == 151 && node.y1 == 26 && test[FLAG] == 0) {
                //System.out.printf("A: %d %d %d %d: %d\n", node.x1, node.y1, node.x2, node.y2, node.value);
                //System.out.println(Arrays.toString(test));
                //System.out.println(내외부);
            }

            /*
            if (node.area() >= 50 && 내외부 == 외부) {
                System.out.printf("  %d %d %d %d: %d\n", node.x1, node.y1, node.x2, node.y2, node.value);
            }
            */

            if ((내외부 == 내부 && test[FLAG] == 0) ||
                (내외부 == 외부 && test[FLAG] == 1)) {
                node.children = null;
                node.value = 0;
            }
            else if (내외부 == 걸침) {
                if (node.children == null)
                    node.createChildren();
                for (Node child : node.children)
                    DFS(child, test);
            }
            node.updateValue();
        }

        static void print(Node node, int depth) {
            for (int i = 0; i < depth; ++i)
                System.out.print(" ");
            System.out.printf("%d %d %d %d: %d\n", node.x1, node.y1, node.x2, node.y2, node.value);
            if (node.children != null)
                for (Node child : node.children)
                    print(child, depth + 1);
        }

        char[][] A;
        int[][] C;

        void print2(Node node) throws Exception {
            if (node.children == null) {
                char c = node.value == 0 ? '0' : '1';
                if (node.value != 0 && node.value != node.area()) throw new Exception();
                for (int x = node.x1; x <= node.x2; ++x)
                    for (int y = node.y1; y <= node.y2; ++y) {
                        if (C[x][y] != 0) throw new Exception(x + " " + y + " " + C[x][y] + " " + A[x][y]);
                        A[x][y] = c;
                        C[x][y]++;
                    }
            } else
                for (Node child : node.children)
                    print2(child);
        }

        void print3() {
            for (int x = 0; x < A.length; ++x) {
                for (int y = 0; y < A[0].length; ++y)
                    System.out.print(A[x][y]);
                System.out.println();
            }
        }

        void printC() {
            System.out.println();
            for (int x = 0; x < C.length; ++x) {
                for (int y = 0; y < C[0].length; ++y)
                    System.out.print((char)('0' + C[x][y]));
                System.out.println();
            }
        }

        public long solution(int n, int m, int[][] tests) throws Exception {
            Node root = new Node(0, 0, n, m);

            //A = new char[n + 1][m + 1];
            //C = new int[n + 1][m + 1];
            //print2(root); print3();


            for (int[] test : tests)
                if (test[FLAG] == 1) {
                    DFS(root, test);
                    //print(root, 1); System.out.println();
                    //System.out.println(Arrays.toString(test) + " " + root.value);
                    //C = new int[n + 1][m + 1]; print2(root); print3();
                }
            if (root.value == 0)
                root.value = root.area();
            for (int[] test : tests)
                if (test[FLAG] == 0) {
                    DFS(root, test);
                    //print(root, 1); System.out.println();
                    //System.out.println(Arrays.toString(test) + " " + root.value);
                    //C = new int[n + 1][m + 1];
                    //print2(root); print3();
                }
            //printC();
            return root.value;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new Solution().solution(3, 5, new int[][] {{2, 3, 2, 1}, {1, 0, 4, 0}, {0, 4, 1, 0}}));
        System.out.println(new Solution().solution(99999, 99999, new int[][] {{0, 0, 199997, 1}}));
        System.out.println(new Solution().solution(99999, 99999, new int[][] {{50000, 50000, 3, 0}}));
        System.out.println(new Solution().solution(300, 100, new int[][] {
            {123, 28, 124, 1},
            {183, 22, 34, 0},
            {188, 81, 116, 1},
            {167, 53, 33, 0},
            {125, 55, 20, 0}
        }));
        System.out.println(new Solution().solution(4, 4, new int[][] {{0,0,4,1},{2,2,1,1},{1,3,2,0},{2,1,1,0}}));
        System.out.println(new Solution().solution(4, 4, new int[][] {{0,0,4,1},{0,0,2,0},{4,3,3,1},{1,4,3,0}}));
    }

}