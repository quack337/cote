package baekjoon.b2751;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Maina {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        byte[] b = new byte[2000000 + 1];
        for (int i = 0; i < N; ++i) {
            int value = Integer.parseInt(reader.readLine());
            b[value + 1000000] = 1;
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < b.length; ++i)
            if (b[i] == 1) {
                writer.write(String.valueOf(i - 1000000));
                writer.write('\n');
            }
        writer.close();
    }
}