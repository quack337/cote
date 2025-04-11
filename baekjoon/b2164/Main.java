package baekjoon.b2164;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        ArrayDeque<Integer> a = new ArrayDeque<>();
        for (int i = 0; i < N; ++i)
            a.add(i+1);
        while (a.size() > 1) {
            a.remove();
            int i = a.remove();
            a.addLast(i);
        }
        System.out.println(a.getFirst());
    }
}