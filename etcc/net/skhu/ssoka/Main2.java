package etcc.net.skhu.ssoka;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main2 {
    static final int X1 = 0, Y1 = 1, X2 = 2, Y2 = 3;
    static int N; // 사각형 수
    static int[][] _rectangles;

    // r1 이 r2 보다 윗쪽인가?
    // 즉 r2가 r1 보다 먼저 아래로 이동해야 하는가?
    static boolean 윗쪽인가(int[] r1, int[] r2) {
        if (r2[X2] <= r1[X1]) return false;
        if (r2[X1] >= r1[X2]) return false;
        return r1[Y1] >= r2[Y2];
    }

    // r1 이 r2 보다 오른쪽인가?
    // 즉 r2가 r1 보다 먼저 왼쪽으로 이동해야 하는가?
    static boolean 오른쪽인가(int[] r1, int[] r2) {
        if (r2[Y2] <= r1[Y1]) return false;
        if (r2[Y1] >= r1[Y2]) return false;
        return r1[X1] >= r2[X2];
    }

    @SuppressWarnings("unchecked")
    static void 아래로이동() {
        // graph[a]는 ArrayList<Integer> 이고, a번 rectangle 보다 윗쪽에 잇는 사각형들의 목록
        ArrayList<Integer>[] children = new ArrayList[N];
        ArrayList<Integer>[] parents = new ArrayList[N];
        int[] parentsCount = new int[N]; // parents[a] 값은 a 사각형보다 먼저 아래로 이동해야 하는 사각형 수
        for (int a = 0; a < N; a++) {
            children[a] = new ArrayList<Integer>();
            parents[a] = new ArrayList<Integer>();
        }
        for (int a = 0; a < N; a++) {
            for (int b = 0; b < N; ++b)
                // a가 먼저 아래로 이동해야 하는가?
                if (a != b && 윗쪽인가(_rectangles[b], _rectangles[a])) {
                    children[a].add(b);
                    parents[b].add(a);
                    parentsCount[b]++;
                }
        }

        // System.out.println(Arrays.toString(parentsCount));

        // 위상 정렬에 사용할 큐
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; ++i)
            if (parentsCount[i] == 0)
                queue.add(i);
        while (queue.size() > 0) {
            int p = queue.remove();

            //System.out.println(p);
            아래로이동(parents[p], p);

            for (int c : children[p]) {
                parentsCount[c]--;
                if (parentsCount[c] == 0)
                    queue.add(c);
            }
        }
    }

    static void 아래로이동(ArrayList<Integer> parent, int c) {
        int maxY = 0;
        for (int p : parent)
            maxY = Math.max(_rectangles[p][Y2], maxY);
        int moveY = _rectangles[c][Y1] - maxY;
        _rectangles[c][Y1] -= moveY;
        _rectangles[c][Y2] -= moveY;
        //System.out.println("  " + c + " " + Arrays.toString(_rectangles[c]));
    }

    @SuppressWarnings("unchecked")
    static void 왼쪽으로이동() {
        // graph[a]는 ArrayList<Integer> 이고, a번 rectangle 보다 오른쪽에 잇는 사각형들의 목록
        ArrayList<Integer>[] children = new ArrayList[N];
        ArrayList<Integer>[] parents = new ArrayList[N];
        int[] parentsCount = new int[N]; // parents[a] 값은 a 사각형보다 먼저 왼쪽으로 이동해야 하는 사각형 수
        for (int a = 0; a < N; a++) {
            children[a] = new ArrayList<Integer>();
            parents[a] = new ArrayList<Integer>();
        }
        for (int a = 0; a < N; a++) {
            for (int b = 0; b < N; ++b)
                // a가 먼저 왼쪽으로 이동해야 하는가?
                if (a != b && 오른쪽인가(_rectangles[b], _rectangles[a])) {
                    children[a].add(b);
                    parents[b].add(a);
                    parentsCount[b]++;
                }
        }

        // System.out.println(Arrays.toString(parentsCount));

        // 위상 정렬에 사용할 큐
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; ++i)
            if (parentsCount[i] == 0)
                queue.add(i);
        while (queue.size() > 0) {
            int p = queue.remove();

            //System.out.println(p);
            왼쪽으로이동(parents[p], p);

            for (int c : children[p]) {
                parentsCount[c]--;
                if (parentsCount[c] == 0)
                    queue.add(c);
            }
        }
    }

    static void 왼쪽으로이동(ArrayList<Integer> parent, int c) {
        int maxX = 0;
        for (int p : parent)
            maxX = Math.max(_rectangles[p][X2], maxX);
        int moveX = _rectangles[c][X1] - maxX;
        _rectangles[c][X1] -= moveX;
        _rectangles[c][X2] -= moveX;
        //System.out.println("  " + c + " " + Arrays.toString(_rectangles[c]));
    }

    static String[] solution(int[][] rectangles) {
        N = rectangles.length;
        _rectangles = rectangles;
        아래로이동();
        왼쪽으로이동();
        String[] answer = new String[N];
        for (int i = 0; i < N; ++i) {
            int[] r = _rectangles[i];
            answer[i] = r[X1] + " " + r[Y1] + " "+ r[X2] + " " + r[Y2];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] rectangles = new int[][] {{0,2,1,3}, {1,2,2,5}, {3,3,4,4}, {4,1,6,3}, {1,6,5,7}, {5,5,7,6}, {5,8,6,10}};
        String[] a = solution(rectangles);
        for (String s : a)
            System.out.println(s);
    }

}