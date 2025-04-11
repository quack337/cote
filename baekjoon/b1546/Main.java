package baekjoon.b1546;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(reader.readLine());
    var s = reader.readLine();
    var tokenizer = new StringTokenizer(s);
    int sum = 0, max = 0;
    for (int i = 0; i < N; ++i) {
      int value = Integer.parseInt(tokenizer.nextToken());
      sum += value;
      if (value > max) max = value;
    }
    System.out.println(sum * 100.0 / max / N);
    reader.close();
  }
}