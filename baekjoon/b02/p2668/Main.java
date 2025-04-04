package baekjoon.b02.p2668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static int[] A;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        A = new int[N+1];
        for (int i = 1; i <= N; ++i)
            A[i] = Integer.parseInt(reader.readLine());
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; ++i) {
            boolean[] visited = new boolean[N+1];
            visited[i] = true;
            int index = A[i];
            while (index != i && visited[index] == false) {
                visited[index] = true;
                index = A[index];
            }
            if (index == i) result.add(i);
        }
        System.out.println(result.size());
        for (int i : result)
            System.out.println(i);
    }
}