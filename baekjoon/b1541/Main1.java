package baekjoon.b1541;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), "+-", true);
        int sum = 0;
        while (tokenizer.hasMoreTokens()) {
            String s = tokenizer.nextToken();
            if (s.charAt(0) == '-') break;
            else if (s.charAt(0) == '+') continue;
            sum += Integer.parseInt(s);
        }
        while (tokenizer.hasMoreTokens()) {
            String s = tokenizer.nextToken();
            if (s.charAt(0) == '-' || s.charAt(0) == '+') continue;
            sum -= Integer.parseInt(s);
        }
        System.out.println(sum);
    }
}