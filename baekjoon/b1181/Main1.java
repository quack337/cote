package baekjoon.b1181;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; ++i)
            list.add(reader.readLine());
        list.sort((s1, s2) -> {
            int r = s1.length() - s2.length();
            if (r != 0) return r;
            return s1.compareTo(s2);
        });
        String prev = "";
        for (String s : list) {
            if (prev.equals(s) == false)
                System.out.println(s);
            prev = s;
        }
    }
}