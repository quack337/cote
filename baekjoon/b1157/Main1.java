package baekjoon.b1157;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int[] count = new int['Z' - 'A' + 1];
        for (char c : s.toUpperCase().toCharArray())
            ++count[c - 'A'];
        int maxIndex = 0;
        for (int i = 1; i < count.length; ++i)
            if (count[i] > count[maxIndex])
                maxIndex = i;
        int maxCount = 0;
        for (int i = 1; i < count.length; ++i)
            if (count[i] == count[maxIndex])
                ++maxCount;
        System.out.printf("%c\n", maxCount > 1 ? '?' : 'A' + maxIndex);
    }
}