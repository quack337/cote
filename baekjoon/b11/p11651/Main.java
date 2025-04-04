package baekjoon.b11.p11651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static class Point implements Comparable<Point>  {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p) {
            int r = this.y - p.y;
            if (r != 0) return r;
            return this.x - p.x;
        }

        @Override
        public String toString() {
            return String.format("%d %d", x, y);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            list.add(new Point(x, y));
        }
        Collections.sort(list);
        for (Point p : list)
            System.out.println(p);
    }

}