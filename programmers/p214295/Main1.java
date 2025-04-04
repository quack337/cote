package programmers.p214295;

public class Main1 {

    static class Solution {
        static final int 외부 = 0, 걸침 = 1, 내부 = 2;
        static final int X = 0, Y = 1, D = 2, FLAG = 3;

        static class Node {
            int x1, y1, x2, y2;
            long value;
            Node[] children;

            Node (int x1, int y1, int x2, int y2) {
                this.x1 = x1; this.y1 = y1;  this.x2 = x2; this.y2 = y2;
                this.value = (x2 - x1 + 1L) * (y2 - y1 + 1L);
            }

            void createChildren() {
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
                }
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

        static void DFS(Node node, int[] test) {
            if (node.value == 0)
                return;
            int 내외부 = 내부인가(node, test);

            if ((내외부 == 외부 && test[FLAG] == 1) ||
                (내외부 == 내부 && test[FLAG] == 0)) {
                node.children = null;
                node.value = 0;
            }
            else if (내외부 == 걸침) {
                if (node.children == null)
                    node.createChildren();
                for (Node child : node.children)
                    DFS(child, test);
                node.value = 0;
                for (Node child : node.children)
                    node.value += child.value;
            }
        }

        static void print(Node node, int depth) {
            for (int i = 0; i < depth; ++i)
                System.out.print(" ");
            System.out.printf("%d %d %d %d: %d\n", node.x1, node.y1, node.x2, node.y2, node.value);
            if (node.children != null)
                for (Node child : node.children)
                    print(child, depth + 1);
        }

        public long solution(int n, int m, int[][] tests) {
            Node root = new Node(0, 0, n, m);
            //System.out.println(" " + root.value);
            for (int[] test : tests) {
                if (test[FLAG] == 0)
                    DFS(root, test);
                //System.out.println(" root: " + root.value);
                //print(root, 1); System.out.println();
            }
            return root.value;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(3, 5, new int[][] {{2, 3, 2, 1}, {1, 0, 4, 0}, {0, 4, 1, 0}}));
        System.out.println(new Solution().solution(99999, 99999, new int[][] {{0, 0, 199997, 1}}));
        System.out.println(new Solution().solution(99999, 99999, new int[][] {{50000, 50000, 3, 0}}));
        System.out.println(new Solution().solution(300, 100, new int[][] {{123, 28, 124, 1}, {183, 22, 34, 0}, {188, 81, 116, 1}, {167, 53, 33, 0}, {125, 55, 20, 0}}));
        //System.out.println(new Solution().solution(5, 5, new int[][] {{0,0,4,1},{2,2,1,1}}));
    }

}