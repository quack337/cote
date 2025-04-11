package baekjoon.b1475;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] count = new int[10];
        if (N == 0) count[0] = 1;
        while (N > 0) {
            int digit = N % 10;
            ++count[digit];
            N /= 10;
        }
        int count69 = count[6] + count[9];
        count[6] = count[9] = 0;
        int maxCount = 0;
        for (int c : count)
            if (c > maxCount) maxCount = c;
        int answer = Math.max(maxCount, (count69 + 1) / 2);
        System.out.println(answer);
    }
}