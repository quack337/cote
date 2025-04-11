package baekjoon.b1406;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray())
            list.add(c);
        int N = Integer.parseInt(reader.readLine());
        int index = list.size();
        for (int i = 0; i < N; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String cmd = tokenizer.nextToken();
            switch (cmd) {
            case "L": if (index > 0 ) --index; break;
            case "D": if (index < list.size()-1) ++index; break;
            case "B":
                if (index > 0) {
                    list.remove(index - 1);
                    --index;
                }
                break;
            case "P":
                list.add(index, tokenizer.nextToken().charAt(0));
                ++index;
                break;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (char c : list)
            builder.append(c);
        System.out.println(builder.toString());
    }
}