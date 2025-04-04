package baekjoon.b03.p3038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    static int[] 트리2생성(int depth) {
        int[] 트리 = 트리생성(depth);
        int leafIndex = (int)Math.pow(2, depth-1) - 1;
        for (int i = 0; i < leafIndex; ++i)
            트리[i] = 트리[i] * 2;
        for (int i = leafIndex; i < 트리.length; ++i)
            트리[i] = 트리[i] * 2 + 1;
        return 트리;
    }

    static int[] 트리3생성(int depth) {
        int[] 트리 = 트리생성(depth);
        int leafIndex = (int)Math.pow(2, depth-1) - 1;
        for (int i = 0; i < leafIndex; ++i)
            트리[i] = 트리[i] * 2 + 1;
        for (int i = leafIndex; i < 트리.length; ++i)
            트리[i] = 트리[i] * 2;
        return 트리;
    }

    static int[] 트리생성(int depth) {
        if (depth == 1) return new int[] { 1 };
        if (depth == 2) return new int[] { 1, 3, 2 };
        int[] a = new int[(int)Math.pow(2,depth) - 1];
        a[0] = 1;
        int[] 트리2 = 트리2생성(depth-1), 트리3 = 트리3생성(depth-1);
        int index = 1;
        for (int i : 트리2)
            a[index++] = i;
        for (int i : 트리3)
            a[index++] = i;
        return a;
    }

    static void preorder(int[] a, int i) {
        if (i >= a.length) return;
        System.out.println(a[i]);
        preorder(a, 2*i + 1);
        preorder(a, 2*i + 2);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int depth = Integer.parseInt(reader.readLine());
        int[] a = 트리생성(depth);
        preorder(a, 0);
    }
}