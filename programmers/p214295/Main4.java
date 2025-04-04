package programmers.p214295;

import java.util.Arrays;

public class Main4 {

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
                } else
                    throw new Exception("child");

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
        }

        static boolean 내부인가(Point p, int[] 마름모) {
            return Math.abs(p.x - 마름모[X]) + Math.abs(p.y - 마름모[Y]) <= 마름모[D];
        }

        static boolean 모두내부인가(Point[] points, int[] 마름모) {
            for (Point p : points)
                if (내부인가(p, 마름모) == false) return false;
            return true;
        }

        static boolean 모두외부인가(Point[] points, int[] 마름모) {
            for (Point p : points)
                if (내부인가(p, 마름모) == true) return false;
            return true;
        }

        static boolean 내부인가(Point p, Node node) {
            return node.x1 <= p.x && p.x <= node.x2 && node.y1 <= p.y && p.y <= node.y2;
        }

        static boolean 모두외부인가(Point[] points, Node node) {
            for (Point p : points)
                if (내부인가(p, node) == true) return false;
            return true;
        }

        static int 내부인가(Node node, int[] 마름모) {
            Point[] 사각형꼭지점 = new Point[] {
               new Point(node.x1, node.y1),
               new Point(node.x1, node.y2),
               new Point(node.x2, node.y1),
               new Point(node.x2, node.y2) };
            Point[] 마름모꼭지점 = new Point[] {
               new Point(마름모[X] - 마름모[D], 마름모[Y]),
               new Point(마름모[X] + 마름모[D], 마름모[Y]),
               new Point(마름모[X], 마름모[Y] - 마름모[D]),
               new Point(마름모[X], 마름모[Y] + 마름모[D]) };
            if (모두내부인가(사각형꼭지점, 마름모)) return 내부;
            if (모두외부인가(사각형꼭지점, 마름모) && 모두외부인가(마름모꼭지점, node)) return 외부;
            return 걸침;
        }

        static void DFS(Node node, int[] test) throws Exception {
            if (node.value == 0) return;

            int 내외부 = 내부인가(node, test);

            if (node.x1 == 151 && node.y1 == 26 && test[FLAG] == 0) {
                System.out.printf("A: %d %d %d %d: %d\n", node.x1, node.y1, node.x2, node.y2, node.value);
                System.out.println(Arrays.toString(test));
                System.out.println(내외부);
            }

            if (node.area() >= 50 && 내외부 == 외부) {
                System.out.printf("  %d %d %d %d: %d\n", node.x1, node.y1, node.x2, node.y2, node.value);
            }

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

            A = new char[n + 1][m + 1];
            C = new int[n + 1][m + 1];
            print2(root); print3();


            for (int[] test : tests)
                if (test[FLAG] == 1) {
                    DFS(root, test);
                    //print(root, 1); System.out.println();
                    System.out.println(Arrays.toString(test) + " " + root.value);
                    C = new int[n + 1][m + 1]; print2(root); print3();
                }
            if (root.value == 0)
                root.value = root.area();
            for (int[] test : tests)
                if (test[FLAG] == 0) {
                    DFS(root, test);
                    //print(root, 1); System.out.println();
                    System.out.println(Arrays.toString(test) + " " + root.value);
                    C = new int[n + 1][m + 1];
                    print2(root); print3();
                }
            //printC();
            return root.value;
        }
    }

    public static void main(String[] args) throws Exception {
        //System.out.println(new Solution().solution(3, 5, new int[][] {{2, 3, 2, 1}, {1, 0, 4, 0}, {0, 4, 1, 0}}));
        //System.out.println(new Solution().solution(99999, 99999, new int[][] {{0, 0, 199997, 1}}));
        //System.out.println(new Solution().solution(99999, 99999, new int[][] {{50000, 50000, 3, 0}}));

        System.out.println(new Solution().solution(300, 100, new int[][] {
            //{123, 28, 124, 1},
            {183, 22, 34, 0},
            //{188, 81, 116, 1},
            //{167, 53, 33, 0},
            //{125, 55, 20, 0}
        }));

        //System.out.println(new Solution().solution(4, 4, new int[][] {{0,0,4,1},{2,2,1,1},{1,3,2,0},{2,1,1,0}}));
        //System.out.println(new Solution().solution(4, 4, new int[][] {{0,0,4,1},{0,0,2,0},{4,3,3,1},{1,4,3,0}}));

    }

}