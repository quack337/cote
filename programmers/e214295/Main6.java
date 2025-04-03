package programmers.e214295;

public class Main6 {

    static class Solution {
        static final int 외부 = 0, 걸침 = 1, 내부 = 2;
        static final int X = 0, Y = 1, D = 2, FLAG = 3;

        static class Node {
            int x1, y1, x2, y2;
            long value;
            Node[] children;

            Node (int x1, int y1, int x2, int y2) {
                this.x1 = x1; this.y1 = y1;  this.x2 = x2; this.y2 = y2;
                value = (x2 - x1 + 1L) * (y2 - y1 + 1L);
            }

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

        static boolean 모두내부인가(Point[] points, int[] 마름모) {
            for (Point p : points)
                if (Math.abs(p.x - 마름모[X]) + Math.abs(p.y - 마름모[Y]) <= 마름모[D] == false)
                    return false;
            return true;
        }

        static boolean 모두내부인가(Point[] points, Node node) {
            for (Point p : points)
                if ((node.x1 <= p.x && p.x <= node.x2 && node.y1 <= p.y && p.y <= node.y2) == false)
                    return false;
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

        public long solution(int n, int m, int[][] tests) throws Exception {
            Node root = new Node(0, 0, n, m);
            for (int[] test : tests)
                DFS(root, test);
            return root.value;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new Solution().solution(3, 5, new int[][] {{2, 3, 2, 1}, {1, 0, 4, 0}, {0, 4, 1, 0}}));
        System.out.println(new Solution().solution(99999, 99999, new int[][] {{0, 0, 199997, 1}}));
        System.out.println(new Solution().solution(99999, 99999, new int[][] {{50000, 50000, 3, 0}}));
        System.out.println(new Solution().solution(300, 100, new int[][] {
            {123, 28, 124, 1}, {183, 22, 34, 0}, {188, 81, 116, 1}, {167, 53, 33, 0}, {125, 55, 20, 0}
        }));
        System.out.println(new Solution().solution(4, 4, new int[][] {{0,0,4,1},{2,2,1,1},{1,3,2,0},{2,1,1,0}}));
        System.out.println(new Solution().solution(4, 4, new int[][] {{0,0,4,1},{0,0,2,0},{4,3,3,1},{1,4,3,0}}));
    }

}