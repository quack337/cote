package baekjoon.b1914;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    static int hanoi(StringBuilder builder, int count, int from, int to, int temp) {
        if (count == 1) {
            builder.append(from).append(' ').append(to).append('\n');
            return 1;
        }
        return hanoi(builder, count - 1, from, temp, to) +
               hanoi(builder, 1, from, to, temp) +
               hanoi(builder, count - 1, temp, to, from);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();
        int count = hanoi(builder, N, 1, 3, 2);
        builder.insert(0, count + "\n");
        System.out.println(builder);
    }
}