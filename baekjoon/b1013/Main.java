package baekjoon.b1013;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; ++i) {
      String input = br.readLine();
      System.out.println(input.matches("((100+1+)|(01))+") ? "YES" : "NO");
    }
  }
}