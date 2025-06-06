package baekjoon.b2193;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    static int DFS(int n, int previous) {
        if (n == 0) return 1;
        if (previous == -1) return DFS(n-1, 1);
        else if (previous == 0) return DFS(n-1, 1) + DFS(n-1, 0);
        return DFS(n-1, 0);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        System.out.println(DFS(N, -1));
    }
}