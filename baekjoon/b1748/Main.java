package baekjoon.b1748;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int length(int value) {
        int result = 0;
        while (value > 0) {
            ++result;
            value /= 10;
        }
        return result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        long result = 0;
        for (int i = 1; i <= N; ++i)
            result += length(i);
        System.out.println(result);
    }
}