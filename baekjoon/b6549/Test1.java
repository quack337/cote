package baekjoon.b6549;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Test1 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("d:/temp/t.txt")));
        Random random = new Random();
        for (int N = 100; N <= 1000; N += 10) {
            out.printf("%d ", N);
            for (int i = 0; i < N; ++i)
                out.printf("%d ", random.nextInt(10));
            out.println();
        }
        out.println(0);
        out.close();
    }
}