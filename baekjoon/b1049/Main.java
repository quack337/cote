package baekjoon.b1049;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int minPackage = Integer.MAX_VALUE;
        int minPiece = Integer.MAX_VALUE;
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int p = Integer.parseInt(tokenizer.nextToken());
            int a = Integer.parseInt(tokenizer.nextToken());
            if (p < minPackage) minPackage = p;
            if (a < minPiece) minPiece = a;
        }
        if (N <= 6)
            System.out.println(Math.min(minPackage, minPiece * N));
        else {
            if (minPackage < minPiece * 6) {
                int a1 = (N / 6) * minPackage;
                int a2 = Math.min(minPackage, minPiece * (N % 6));
                System.out.println(a1 + a2);
            } else
                System.out.println(N * minPiece);
        }
    }
}